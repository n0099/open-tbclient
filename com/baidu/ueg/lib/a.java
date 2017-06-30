package com.baidu.ueg.lib;

import android.support.v4.view.MotionEventCompat;
import com.baidu.ueg.lib.b;
/* loaded from: classes.dex */
public class a extends b {
    private final byte[] gnC;
    private final byte[] gnD;
    private final byte[] gnE;
    private final int gnF;
    private final int gnG;
    static final byte[] gny = {13, 10};
    private static final byte[] gnz = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] gnA = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] gnB = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(0);
    }

    public a(boolean z) {
        this(76, gny, z);
    }

    public a(int i) {
        this(i, gny);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.gnD = gnB;
        if (bArr != null) {
            if (E(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d.G(bArr) + "]");
            } else if (i > 0) {
                this.gnG = bArr.length + 4;
                this.gnE = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.gnE, 0, bArr.length);
            } else {
                this.gnG = 4;
                this.gnE = null;
            }
        } else {
            this.gnG = 4;
            this.gnE = null;
        }
        this.gnF = this.gnG - 1;
        this.gnC = z ? gnA : gnz;
    }

    @Override // com.baidu.ueg.lib.b
    void a(byte[] bArr, int i, int i2, b.a aVar) {
        if (!aVar.eof) {
            if (i2 < 0) {
                aVar.eof = true;
                if (aVar.gnP != 0 || this.yl != 0) {
                    byte[] a = a(this.gnG, aVar);
                    int i3 = aVar.pos;
                    switch (aVar.gnP) {
                        case 0:
                            break;
                        case 1:
                            int i4 = aVar.pos;
                            aVar.pos = i4 + 1;
                            a[i4] = this.gnC[(aVar.gnL >> 2) & 63];
                            int i5 = aVar.pos;
                            aVar.pos = i5 + 1;
                            a[i5] = this.gnC[(aVar.gnL << 4) & 63];
                            if (this.gnC == gnz) {
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
                            a[i8] = this.gnC[(aVar.gnL >> 10) & 63];
                            int i9 = aVar.pos;
                            aVar.pos = i9 + 1;
                            a[i9] = this.gnC[(aVar.gnL >> 4) & 63];
                            int i10 = aVar.pos;
                            aVar.pos = i10 + 1;
                            a[i10] = this.gnC[(aVar.gnL << 2) & 63];
                            if (this.gnC == gnz) {
                                int i11 = aVar.pos;
                                aVar.pos = i11 + 1;
                                a[i11] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + aVar.gnP);
                    }
                    aVar.gnO = (aVar.pos - i3) + aVar.gnO;
                    if (this.yl > 0 && aVar.gnO > 0) {
                        System.arraycopy(this.gnE, 0, a, aVar.pos, this.gnE.length);
                        aVar.pos += this.gnE.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            while (i12 < i2) {
                byte[] a2 = a(this.gnG, aVar);
                aVar.gnP = (aVar.gnP + 1) % 3;
                int i13 = i + 1;
                int i14 = bArr[i];
                if (i14 < 0) {
                    i14 += 256;
                }
                aVar.gnL = i14 + (aVar.gnL << 8);
                if (aVar.gnP == 0) {
                    int i15 = aVar.pos;
                    aVar.pos = i15 + 1;
                    a2[i15] = this.gnC[(aVar.gnL >> 18) & 63];
                    int i16 = aVar.pos;
                    aVar.pos = i16 + 1;
                    a2[i16] = this.gnC[(aVar.gnL >> 12) & 63];
                    int i17 = aVar.pos;
                    aVar.pos = i17 + 1;
                    a2[i17] = this.gnC[(aVar.gnL >> 6) & 63];
                    int i18 = aVar.pos;
                    aVar.pos = i18 + 1;
                    a2[i18] = this.gnC[aVar.gnL & 63];
                    aVar.gnO += 4;
                    if (this.yl > 0 && this.yl <= aVar.gnO) {
                        System.arraycopy(this.gnE, 0, a2, aVar.pos, this.gnE.length);
                        aVar.pos += this.gnE.length;
                        aVar.gnO = 0;
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
                byte[] a = a(this.gnF, aVar);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    aVar.eof = true;
                    break;
                }
                if (b2 >= 0 && b2 < gnB.length && (b = gnB[b2]) >= 0) {
                    aVar.gnP = (aVar.gnP + 1) % 4;
                    aVar.gnL = b + (aVar.gnL << 6);
                    if (aVar.gnP == 0) {
                        int i5 = aVar.pos;
                        aVar.pos = i5 + 1;
                        a[i5] = (byte) ((aVar.gnL >> 16) & MotionEventCompat.ACTION_MASK);
                        int i6 = aVar.pos;
                        aVar.pos = i6 + 1;
                        a[i6] = (byte) ((aVar.gnL >> 8) & MotionEventCompat.ACTION_MASK);
                        int i7 = aVar.pos;
                        aVar.pos = i7 + 1;
                        a[i7] = (byte) (aVar.gnL & MotionEventCompat.ACTION_MASK);
                    }
                }
                i3++;
                i = i4;
            }
            if (aVar.eof && aVar.gnP != 0) {
                byte[] a2 = a(this.gnF, aVar);
                switch (aVar.gnP) {
                    case 1:
                        return;
                    case 2:
                        aVar.gnL >>= 4;
                        int i8 = aVar.pos;
                        aVar.pos = i8 + 1;
                        a2[i8] = (byte) (aVar.gnL & MotionEventCompat.ACTION_MASK);
                        return;
                    case 3:
                        aVar.gnL >>= 2;
                        int i9 = aVar.pos;
                        aVar.pos = i9 + 1;
                        a2[i9] = (byte) ((aVar.gnL >> 8) & MotionEventCompat.ACTION_MASK);
                        int i10 = aVar.pos;
                        aVar.pos = i10 + 1;
                        a2[i10] = (byte) (aVar.gnL & MotionEventCompat.ACTION_MASK);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + aVar.gnP);
                }
            }
        }
    }

    public static String D(byte[] bArr) {
        return d.G(b(bArr, false));
    }

    public static byte[] b(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr != null && bArr.length != 0) {
            a aVar = z ? new a(z2) : new a(0, gny, z2);
            long F = aVar.F(bArr);
            if (F > i) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + F + ") than the specified maximum size of " + i);
            }
            return aVar.encode(bArr);
        }
        return bArr;
    }

    public static byte[] sC(String str) {
        return new a().decode(str);
    }

    @Override // com.baidu.ueg.lib.b
    protected boolean b(byte b) {
        return b >= 0 && b < this.gnD.length && this.gnD[b] != -1;
    }
}
