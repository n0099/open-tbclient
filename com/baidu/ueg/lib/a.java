package com.baidu.ueg.lib;

import android.support.v4.view.MotionEventCompat;
/* loaded from: classes.dex */
public class a extends b {
    static final byte[] cDD = {13, 10};
    private static final byte[] cDE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] cDF = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] cDG = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] cDH;
    private final byte[] cDI;
    private final byte[] cDJ;
    private final int cDK;
    private final int cDL;

    public a() {
        this(0);
    }

    public a(boolean z) {
        this(76, cDD, z);
    }

    public a(int i) {
        this(i, cDD);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.cDI = cDG;
        if (bArr != null) {
            if (F(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + e.H(bArr) + "]");
            } else if (i > 0) {
                this.cDL = bArr.length + 4;
                this.cDJ = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.cDJ, 0, bArr.length);
            } else {
                this.cDL = 4;
                this.cDJ = null;
            }
        } else {
            this.cDL = 4;
            this.cDJ = null;
        }
        this.cDK = this.cDL - 1;
        this.cDH = z ? cDF : cDE;
    }

    @Override // com.baidu.ueg.lib.b
    void a(byte[] bArr, int i, int i2, c cVar) {
        if (!cVar.eof) {
            if (i2 < 0) {
                cVar.eof = true;
                if (cVar.cDU != 0 || this.xQ != 0) {
                    byte[] a = a(this.cDL, cVar);
                    int i3 = cVar.pos;
                    switch (cVar.cDU) {
                        case 0:
                            break;
                        case 1:
                            int i4 = cVar.pos;
                            cVar.pos = i4 + 1;
                            a[i4] = this.cDH[(cVar.cDQ >> 2) & 63];
                            int i5 = cVar.pos;
                            cVar.pos = i5 + 1;
                            a[i5] = this.cDH[(cVar.cDQ << 4) & 63];
                            if (this.cDH == cDE) {
                                int i6 = cVar.pos;
                                cVar.pos = i6 + 1;
                                a[i6] = 61;
                                int i7 = cVar.pos;
                                cVar.pos = i7 + 1;
                                a[i7] = 61;
                                break;
                            }
                            break;
                        case 2:
                            int i8 = cVar.pos;
                            cVar.pos = i8 + 1;
                            a[i8] = this.cDH[(cVar.cDQ >> 10) & 63];
                            int i9 = cVar.pos;
                            cVar.pos = i9 + 1;
                            a[i9] = this.cDH[(cVar.cDQ >> 4) & 63];
                            int i10 = cVar.pos;
                            cVar.pos = i10 + 1;
                            a[i10] = this.cDH[(cVar.cDQ << 2) & 63];
                            if (this.cDH == cDE) {
                                int i11 = cVar.pos;
                                cVar.pos = i11 + 1;
                                a[i11] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + cVar.cDU);
                    }
                    cVar.cDT = (cVar.pos - i3) + cVar.cDT;
                    if (this.xQ > 0 && cVar.cDT > 0) {
                        System.arraycopy(this.cDJ, 0, a, cVar.pos, this.cDJ.length);
                        cVar.pos += this.cDJ.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            while (i12 < i2) {
                byte[] a2 = a(this.cDL, cVar);
                cVar.cDU = (cVar.cDU + 1) % 3;
                int i13 = i + 1;
                int i14 = bArr[i];
                if (i14 < 0) {
                    i14 += 256;
                }
                cVar.cDQ = i14 + (cVar.cDQ << 8);
                if (cVar.cDU == 0) {
                    int i15 = cVar.pos;
                    cVar.pos = i15 + 1;
                    a2[i15] = this.cDH[(cVar.cDQ >> 18) & 63];
                    int i16 = cVar.pos;
                    cVar.pos = i16 + 1;
                    a2[i16] = this.cDH[(cVar.cDQ >> 12) & 63];
                    int i17 = cVar.pos;
                    cVar.pos = i17 + 1;
                    a2[i17] = this.cDH[(cVar.cDQ >> 6) & 63];
                    int i18 = cVar.pos;
                    cVar.pos = i18 + 1;
                    a2[i18] = this.cDH[cVar.cDQ & 63];
                    cVar.cDT += 4;
                    if (this.xQ > 0 && this.xQ <= cVar.cDT) {
                        System.arraycopy(this.cDJ, 0, a2, cVar.pos, this.cDJ.length);
                        cVar.pos += this.cDJ.length;
                        cVar.cDT = 0;
                    }
                }
                i12++;
                i = i13;
            }
        }
    }

    @Override // com.baidu.ueg.lib.b
    void b(byte[] bArr, int i, int i2, c cVar) {
        byte b;
        if (!cVar.eof) {
            if (i2 < 0) {
                cVar.eof = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                byte[] a = a(this.cDK, cVar);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    cVar.eof = true;
                    break;
                }
                if (b2 >= 0 && b2 < cDG.length && (b = cDG[b2]) >= 0) {
                    cVar.cDU = (cVar.cDU + 1) % 4;
                    cVar.cDQ = b + (cVar.cDQ << 6);
                    if (cVar.cDU == 0) {
                        int i5 = cVar.pos;
                        cVar.pos = i5 + 1;
                        a[i5] = (byte) ((cVar.cDQ >> 16) & MotionEventCompat.ACTION_MASK);
                        int i6 = cVar.pos;
                        cVar.pos = i6 + 1;
                        a[i6] = (byte) ((cVar.cDQ >> 8) & MotionEventCompat.ACTION_MASK);
                        int i7 = cVar.pos;
                        cVar.pos = i7 + 1;
                        a[i7] = (byte) (cVar.cDQ & MotionEventCompat.ACTION_MASK);
                    }
                }
                i3++;
                i = i4;
            }
            if (cVar.eof && cVar.cDU != 0) {
                byte[] a2 = a(this.cDK, cVar);
                switch (cVar.cDU) {
                    case 1:
                        return;
                    case 2:
                        cVar.cDQ >>= 4;
                        int i8 = cVar.pos;
                        cVar.pos = i8 + 1;
                        a2[i8] = (byte) (cVar.cDQ & MotionEventCompat.ACTION_MASK);
                        return;
                    case 3:
                        cVar.cDQ >>= 2;
                        int i9 = cVar.pos;
                        cVar.pos = i9 + 1;
                        a2[i9] = (byte) ((cVar.cDQ >> 8) & MotionEventCompat.ACTION_MASK);
                        int i10 = cVar.pos;
                        cVar.pos = i10 + 1;
                        a2[i10] = (byte) (cVar.cDQ & MotionEventCompat.ACTION_MASK);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + cVar.cDU);
                }
            }
        }
    }

    public static String E(byte[] bArr) {
        return e.H(b(bArr, false));
    }

    public static byte[] b(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr != null && bArr.length != 0) {
            a aVar = z ? new a(z2) : new a(0, cDD, z2);
            long G = aVar.G(bArr);
            if (G > i) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + G + ") than the specified maximum size of " + i);
            }
            return aVar.encode(bArr);
        }
        return bArr;
    }

    public static byte[] kf(String str) {
        return new a().decode(str);
    }

    @Override // com.baidu.ueg.lib.b
    protected boolean b(byte b) {
        return b >= 0 && b < this.cDI.length && this.cDI[b] != -1;
    }
}
