package com.baidu.ueg.lib;

import android.support.v4.view.MotionEventCompat;
import com.baidu.ueg.lib.b;
/* loaded from: classes.dex */
public class a extends b {
    static final byte[] dZD = {13, 10};
    private static final byte[] dZE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] dZF = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] dZG = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] dZH;
    private final byte[] dZI;
    private final byte[] dZJ;
    private final int dZK;
    private final int dZL;

    public a() {
        this(0);
    }

    public a(boolean z) {
        this(76, dZD, z);
    }

    public a(int i) {
        this(i, dZD);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.dZI = dZG;
        if (bArr != null) {
            if (W(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d.Y(bArr) + "]");
            } else if (i > 0) {
                this.dZL = bArr.length + 4;
                this.dZJ = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.dZJ, 0, bArr.length);
            } else {
                this.dZL = 4;
                this.dZJ = null;
            }
        } else {
            this.dZL = 4;
            this.dZJ = null;
        }
        this.dZK = this.dZL - 1;
        this.dZH = z ? dZF : dZE;
    }

    @Override // com.baidu.ueg.lib.b
    void a(byte[] bArr, int i, int i2, b.a aVar) {
        if (!aVar.eof) {
            if (i2 < 0) {
                aVar.eof = true;
                if (aVar.dZU != 0 || this.xS != 0) {
                    byte[] a = a(this.dZL, aVar);
                    int i3 = aVar.pos;
                    switch (aVar.dZU) {
                        case 0:
                            break;
                        case 1:
                            int i4 = aVar.pos;
                            aVar.pos = i4 + 1;
                            a[i4] = this.dZH[(aVar.dZQ >> 2) & 63];
                            int i5 = aVar.pos;
                            aVar.pos = i5 + 1;
                            a[i5] = this.dZH[(aVar.dZQ << 4) & 63];
                            if (this.dZH == dZE) {
                                int i6 = aVar.pos;
                                aVar.pos = i6 + 1;
                                a[i6] = 61;
                                int i7 = aVar.pos;
                                aVar.pos = i7 + 1;
                                a[i7] = 61;
                                break;
                            }
                            break;
                        case 2:
                            int i8 = aVar.pos;
                            aVar.pos = i8 + 1;
                            a[i8] = this.dZH[(aVar.dZQ >> 10) & 63];
                            int i9 = aVar.pos;
                            aVar.pos = i9 + 1;
                            a[i9] = this.dZH[(aVar.dZQ >> 4) & 63];
                            int i10 = aVar.pos;
                            aVar.pos = i10 + 1;
                            a[i10] = this.dZH[(aVar.dZQ << 2) & 63];
                            if (this.dZH == dZE) {
                                int i11 = aVar.pos;
                                aVar.pos = i11 + 1;
                                a[i11] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + aVar.dZU);
                    }
                    aVar.dZT = (aVar.pos - i3) + aVar.dZT;
                    if (this.xS > 0 && aVar.dZT > 0) {
                        System.arraycopy(this.dZJ, 0, a, aVar.pos, this.dZJ.length);
                        aVar.pos += this.dZJ.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            while (i12 < i2) {
                byte[] a2 = a(this.dZL, aVar);
                aVar.dZU = (aVar.dZU + 1) % 3;
                int i13 = i + 1;
                int i14 = bArr[i];
                if (i14 < 0) {
                    i14 += 256;
                }
                aVar.dZQ = i14 + (aVar.dZQ << 8);
                if (aVar.dZU == 0) {
                    int i15 = aVar.pos;
                    aVar.pos = i15 + 1;
                    a2[i15] = this.dZH[(aVar.dZQ >> 18) & 63];
                    int i16 = aVar.pos;
                    aVar.pos = i16 + 1;
                    a2[i16] = this.dZH[(aVar.dZQ >> 12) & 63];
                    int i17 = aVar.pos;
                    aVar.pos = i17 + 1;
                    a2[i17] = this.dZH[(aVar.dZQ >> 6) & 63];
                    int i18 = aVar.pos;
                    aVar.pos = i18 + 1;
                    a2[i18] = this.dZH[aVar.dZQ & 63];
                    aVar.dZT += 4;
                    if (this.xS > 0 && this.xS <= aVar.dZT) {
                        System.arraycopy(this.dZJ, 0, a2, aVar.pos, this.dZJ.length);
                        aVar.pos += this.dZJ.length;
                        aVar.dZT = 0;
                    }
                }
                i12++;
                i = i13;
            }
        }
    }

    @Override // com.baidu.ueg.lib.b
    void b(byte[] bArr, int i, int i2, b.a aVar) {
        byte b;
        if (!aVar.eof) {
            if (i2 < 0) {
                aVar.eof = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                byte[] a = a(this.dZK, aVar);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    aVar.eof = true;
                    break;
                }
                if (b2 >= 0 && b2 < dZG.length && (b = dZG[b2]) >= 0) {
                    aVar.dZU = (aVar.dZU + 1) % 4;
                    aVar.dZQ = b + (aVar.dZQ << 6);
                    if (aVar.dZU == 0) {
                        int i5 = aVar.pos;
                        aVar.pos = i5 + 1;
                        a[i5] = (byte) ((aVar.dZQ >> 16) & MotionEventCompat.ACTION_MASK);
                        int i6 = aVar.pos;
                        aVar.pos = i6 + 1;
                        a[i6] = (byte) ((aVar.dZQ >> 8) & MotionEventCompat.ACTION_MASK);
                        int i7 = aVar.pos;
                        aVar.pos = i7 + 1;
                        a[i7] = (byte) (aVar.dZQ & MotionEventCompat.ACTION_MASK);
                    }
                }
                i3++;
                i = i4;
            }
            if (aVar.eof && aVar.dZU != 0) {
                byte[] a2 = a(this.dZK, aVar);
                switch (aVar.dZU) {
                    case 1:
                        return;
                    case 2:
                        aVar.dZQ >>= 4;
                        int i8 = aVar.pos;
                        aVar.pos = i8 + 1;
                        a2[i8] = (byte) (aVar.dZQ & MotionEventCompat.ACTION_MASK);
                        return;
                    case 3:
                        aVar.dZQ >>= 2;
                        int i9 = aVar.pos;
                        aVar.pos = i9 + 1;
                        a2[i9] = (byte) ((aVar.dZQ >> 8) & MotionEventCompat.ACTION_MASK);
                        int i10 = aVar.pos;
                        aVar.pos = i10 + 1;
                        a2[i10] = (byte) (aVar.dZQ & MotionEventCompat.ACTION_MASK);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + aVar.dZU);
                }
            }
        }
    }

    public static String V(byte[] bArr) {
        return d.Y(b(bArr, false));
    }

    public static byte[] b(byte[] bArr, boolean z) {
        return b(bArr, z, false);
    }

    public static byte[] b(byte[] bArr, boolean z, boolean z2) {
        return b(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] b(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr != null && bArr.length != 0) {
            a aVar = z ? new a(z2) : new a(0, dZD, z2);
            long X = aVar.X(bArr);
            if (X > i) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + X + ") than the specified maximum size of " + i);
            }
            return aVar.encode(bArr);
        }
        return bArr;
    }

    public static byte[] nz(String str) {
        return new a().decode(str);
    }

    @Override // com.baidu.ueg.lib.b
    protected boolean c(byte b) {
        return b >= 0 && b < this.dZI.length && this.dZI[b] != -1;
    }
}
