/**
 * @author qiyun.yqy
 * @date 2020/7/16
 * 位操作
 */
public class Bitwise {
    // ～0 == -1
    // x ^ -1 == ~x == -x - 1
    // ~x + 1 == -x 相反数
    // -~x == x + 1，上面公式，令x=~x
    // ~-x == x - 1，同上，令x=-x

    // 获取最低位的1
    public static int lowestOneBit(int x) {
        return x & -x; // Integer.lowestOneBit(x);
    }

    // 清除最低位的1
    public static int clearLowestOneBit(int x) {
        return x & (x - 1);
    }

    // 获取最高位的1
    public static int highestOneBit(int x) {
        return Integer.highestOneBit(x);
    }

    // 获取第n位的值，从右往左数，从0开始
    public static int getNBit(int x, int n) {
        return (x >>> n) & 1;
    }

    // 获取第n位的幂值
    public static int getNBitPow(int x, int n) {
        return x & (1 << (n - 1));
    }

    // 设置第n位为1
    public static int setNBit(int x, int n) {
        return x | (1 << n);
    }

    // 设置第n位为0
    public static int clearNBit(int x, int n) {
        return x & ~(1 << n);
    }

    // 将右边到第n位清0，包括n
    public static int clearRight2NBit(int x, int n) {
        return x & (~0 << n); // 等价于 x & (~((1 << (n)) - 1))
    }

    // 将左边到第n位清0，包括n
    public static int clearLeft2NBit(int x, int n) {
        return x & ((1 << n) - 1);
    }

    // 全1
    public static int allOneBit() {
        return ~0; // return -1;
    }

    // 全0
    public static int allZeroBit() {
        return 0;
    }

    // 是否为偶数
    public static boolean isEven(int x) {
        return (x & 1) == 0;
    }

    // 是否为奇数：奇偶判断易错方式 x%2==1 忽略了负数
    public static boolean isOdd(int x) {
        return (x & 1) != 0;
    }

    // 反转位顺序
    public static int reverse(int x) {
        return Integer.reverse(x);
    }

    // 反转字节的顺序
    public static int reverseBytes(int x) {
        return Integer.reverseBytes(x);
    }

    // 符号函数：整数返回1，0返回0，负数返回-1
    public static int signum(int x) {
        return (x >> 31) | (-x >>> 31); // Integer.signum(x);
    }

    // 整数最大值
    public static int getMaxInt(int x) {
        return ~(1 << 31); // 或 (1 << 31) - 1 或 Integer.MAX_VALUE
    }

    // 整数最小值
    public static int getMinInt(int x) {
        return 1 << 31; // 或 Integer.MIN_VALUE
    }

    // 除2
    public static int div2(int x) { // 对于奇数都是向下取整，5>>1=2，-5>>1=-3。而除法是丢弃小数点后的
        return x >> 1;
    }

    // 乘2
    public static int mul2(int x) {
        return x << 1;
    }

    // 除2^m
    public static int div2m(int x, int m) { // 对于奇数同除2
        return x >> m;
    }

    // 乘2^m
    public static int mul2m(int x, int m) {
        return x << m;
    }

    // n为2的某次方，m对n取余
    public static int modPow2(int m, int n) {
        return m & (n - 1); // 如果要求2的n次方取余，可以 m & (2^n - 1)
    }

    // 取绝对值
    public static int abs(int x) {
        // 若x为正数，x>>31为0；若x为负数，x>>31为-1，即 (x ^ -1) - (-1)，x ^ -1 == ~x，即x取反+1。
        // 负数的补码和原码的相互转换都是除符号位之外，取反+1，上面的取反正好连符号位也取反了
        return ( x ^ (x >> 31)) - (x >> 31);
        // (x & ~(x>>31)) | (-x & (x>>31))
    }

    // 取最大值
    public static int max(int a, int b) {
        return b & ((a-b) >> 31) | a & (~(a-b) >> 31); // 如果a>=b则(a-b) >> 31==0，~(a-b) >> 31 == 1；如果a<b则相反。即a、b二选一
    }

    // 取最小值
    public static int min(int a, int b) {
        return a & ((a-b) >> 31) | b & (~(a-b) >> 31); // 同上
    }

    // 取均值
    public static int avg(int a, int b) {
        return (a + b) >> 1; // 注意负奇数的取整问题和除2不同
    }

    // 是否符号相同
    public boolean isSameSign(int a, int b) {
        return (a ^ b) >= 0;
    }

    // 2的n次幂
    public static int pow2(int n) {
        return 1 << n;
    }

    // 判断n是否2的幂
    public static boolean isPow2(int n) {
        return n > 0 ? (n & (n - 1)) == 0 : false; // 即清除最低位1然后与0比较
    }

    // 计数

    // 获取1的个数
    public static int bitCount(int x) {
        return Integer.bitCount(x);
    }

    // 获取前导0个数
    public static int numberOfLeadingZeros(int x) {
        return Integer.numberOfLeadingZeros(x);
    }

    // 获取后缀0个数
    public static int numberOfTrailingZeros(int x) {
        return Integer.numberOfTrailingZeros(x);
    }

    // 汉明距离
    public static int hammingDistance(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    // 位移
    // java位移说明：
    // 1.负距离：-distance = 32-distance
    // 2.距离范围是-31~31，0不移动。大于31或小于-31的会取余，余数符号同distance：distance % 32

    // 循环左移
    public static int rotateLeft(int i, int distance) {
        return (i << distance) | (i >>> -distance); // Integer.rotateLeft(i, distance);
    }

    // 循环右移
    public static int rotateRight(int i, int distance) {
        return (i >>> distance) | (i << -distance); // Integer.rotateRight(i, distance);
    }

    // 打印二进制
    public static String toBinaryString(int x) {
        return Integer.toBinaryString(x);
    }

    public static void main(String[] args) {
    }
}
