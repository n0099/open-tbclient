package com.baidu.ueg.lib;

import android.support.v4.view.MotionEventCompat;
import com.baidu.ueg.lib.b;
/* loaded from: classes.dex */
public class a extends b {
    private final byte[] gKB;
    private final byte[] gKC;
    private final byte[] gKD;
    private final int gKE;
    private final int gKF;
    static final byte[] gKx = {13, 10};
    private static final byte[] gKy = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] gKz = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] gKA = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public a() {
        this(0);
    }

    public a(boolean z) {
        this(76, gKx, z);
    }

    public a(int i) {
        this(i, gKx);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.gKC = gKA;
        if (bArr != null) {
            if (H(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d.J(bArr) + "]");
            } else if (i > 0) {
                this.gKF = bArr.length + 4;
                this.gKD = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.gKD, 0, bArr.length);
            } else {
                this.gKF = 4;
                this.gKD = null;
            }
        } else {
            this.gKF = 4;
            this.gKD = null;
        }
        this.gKE = this.gKF - 1;
        this.gKB = z ? gKz : gKy;
    }

    @Override // com.baidu.ueg.lib.b
    void a(byte[] bArr, int i, int i2, b.a aVar) {
        if (!aVar.eof) {
            if (i2 < 0) {
                aVar.eof = true;
                if (aVar.gKO != 0 || this.zN != 0) {
                    byte[] a = a(this.gKF, aVar);
                    int i3 = aVar.pos;
                    switch (aVar.gKO) {
                        case 0:
                            break;
                        case 1:
                            int i4 = aVar.pos;
                            aVar.pos = i4 + 1;
                            a[i4] = this.gKB[(aVar.gKK >> 2) & 63];
                            int i5 = aVar.pos;
                            aVar.pos = i5 + 1;
                            a[i5] = this.gKB[(aVar.gKK << 4) & 63];
                            if (this.gKB == gKy) {
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
                            a[i8] = this.gKB[(aVar.gKK >> 10) & 63];
                            int i9 = aVar.pos;
                            aVar.pos = i9 + 1;
                            a[i9] = this.gKB[(aVar.gKK >> 4) & 63];
                            int i10 = aVar.pos;
                            aVar.pos = i10 + 1;
                            a[i10] = this.gKB[(aVar.gKK << 2) & 63];
                            if (this.gKB == gKy) {
                                int i11 = aVar.pos;
                                aVar.pos = i11 + 1;
                                a[i11] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + aVar.gKO);
                    }
                    aVar.gKN = (aVar.pos - i3) + aVar.gKN;
                    if (this.zN > 0 && aVar.gKN > 0) {
                        System.arraycopy(this.gKD, 0, a, aVar.pos, this.gKD.length);
                        aVar.pos += this.gKD.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            while (i12 < i2) {
                byte[] a2 = a(this.gKF, aVar);
                aVar.gKO = (aVar.gKO + 1) % 3;
                int i13 = i + 1;
                int i14 = bArr[i];
                if (i14 < 0) {
                    i14 += 256;
                }
                aVar.gKK = i14 + (aVar.gKK << 8);
                if (aVar.gKO == 0) {
                    int i15 = aVar.pos;
                    aVar.pos = i15 + 1;
                    a2[i15] = this.gKB[(aVar.gKK >> 18) & 63];
                    int i16 = aVar.pos;
                    aVar.pos = i16 + 1;
                    a2[i16] = this.gKB[(aVar.gKK >> 12) & 63];
                    int i17 = aVar.pos;
                    aVar.pos = i17 + 1;
                    a2[i17] = this.gKB[(aVar.gKK >> 6) & 63];
                    int i18 = aVar.pos;
                    aVar.pos = i18 + 1;
                    a2[i18] = this.gKB[aVar.gKK & 63];
                    aVar.gKN += 4;
                    if (this.zN > 0 && this.zN <= aVar.gKN) {
                        System.arraycopy(this.gKD, 0, a2, aVar.pos, this.gKD.length);
                        aVar.pos += this.gKD.length;
                        aVar.gKN = 0;
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
                byte[] a = a(this.gKE, aVar);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    aVar.eof = true;
                    break;
                }
                if (b2 >= 0 && b2 < gKA.length && (b = gKA[b2]) >= 0) {
                    aVar.gKO = (aVar.gKO + 1) % 4;
                    aVar.gKK = b + (aVar.gKK << 6);
                    if (aVar.gKO == 0) {
                        int i5 = aVar.pos;
                        aVar.pos = i5 + 1;
                        a[i5] = (byte) ((aVar.gKK >> 16) & MotionEventCompat.ACTION_MASK);
                        int i6 = aVar.pos;
                        aVar.pos = i6 + 1;
                        a[i6] = (byte) ((aVar.gKK >> 8) & MotionEventCompat.ACTION_MASK);
                        int i7 = aVar.pos;
                        aVar.pos = i7 + 1;
                        a[i7] = (byte) (aVar.gKK & MotionEventCompat.ACTION_MASK);
                    }
                }
                i3++;
                i = i4;
            }
            if (aVar.eof && aVar.gKO != 0) {
                byte[] a2 = a(this.gKE, aVar);
                switch (aVar.gKO) {
                    case 1:
                        return;
                    case 2:
                        aVar.gKK >>= 4;
                        int i8 = aVar.pos;
                        aVar.pos = i8 + 1;
                        a2[i8] = (byte) (aVar.gKK & MotionEventCompat.ACTION_MASK);
                        return;
                    case 3:
                        aVar.gKK >>= 2;
                        int i9 = aVar.pos;
                        aVar.pos = i9 + 1;
                        a2[i9] = (byte) ((aVar.gKK >> 8) & MotionEventCompat.ACTION_MASK);
                        int i10 = aVar.pos;
                        aVar.pos = i10 + 1;
                        a2[i10] = (byte) (aVar.gKK & MotionEventCompat.ACTION_MASK);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + aVar.gKO);
                }
            }
        }
    }

    public static String G(byte[] bArr) {
        return d.J(b(bArr, false));
    }

    public static byte[] b(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr != null && bArr.length != 0) {
            a aVar = z ? new a(z2) : new a(0, gKx, z2);
            long I = aVar.I(bArr);
            if (I > i) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + I + ") than the specified maximum size of " + i);
            }
            return aVar.encode(bArr);
        }
        return bArr;
    }

    public static byte[] tu(String str) {
        return new a().decode(str);
    }

    @Override // com.baidu.ueg.lib.b
    protected boolean b(byte b) {
        return b >= 0 && b < this.gKC.length && this.gKC[b] != -1;
    }
}
