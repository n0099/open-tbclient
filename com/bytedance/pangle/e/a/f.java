package com.bytedance.pangle.e.a;
/* loaded from: classes9.dex */
public final class f {
    public int[] a;
    public int[] b;

    public static final int a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        if ((i % 4) / 2 == 0) {
            return i2 & 65535;
        }
        return i2 >>> 16;
    }

    public final String a(int i) {
        int[] iArr;
        if (i >= 0 && (iArr = this.a) != null && i < iArr.length) {
            int i2 = iArr[i];
            int a = a(this.b, i2);
            StringBuilder sb = new StringBuilder(a);
            while (a != 0) {
                i2 += 2;
                sb.append((char) a(this.b, i2));
                a--;
            }
            return sb.toString();
        }
        return null;
    }
}
