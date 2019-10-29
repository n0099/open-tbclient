package com.baidu.ueg.lib;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ueg.lib.b;
/* loaded from: classes3.dex */
public class a extends b {
    static final byte[] jZb = {13, 10};
    private static final byte[] jZc = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] jZd = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] jZe = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] jZf;
    private final byte[] jZg;
    private final byte[] jZh;
    private final int jZi;
    private final int jZj;

    public a() {
        this(0);
    }

    public a(boolean z) {
        this(76, jZb, z);
    }

    public a(int i) {
        this(i, jZb);
    }

    public a(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public a(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.jZg = jZe;
        if (bArr != null) {
            if (J(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + d.L(bArr) + "]");
            } else if (i > 0) {
                this.jZj = bArr.length + 4;
                this.jZh = new byte[bArr.length];
                System.arraycopy(bArr, 0, this.jZh, 0, bArr.length);
            } else {
                this.jZj = 4;
                this.jZh = null;
            }
        } else {
            this.jZj = 4;
            this.jZh = null;
        }
        this.jZi = this.jZj - 1;
        this.jZf = z ? jZd : jZc;
    }

    @Override // com.baidu.ueg.lib.b
    void a(byte[] bArr, int i, int i2, b.a aVar) {
        if (!aVar.jZr) {
            if (i2 < 0) {
                aVar.jZr = true;
                if (aVar.modulus != 0 || this.lineLength != 0) {
                    byte[] a = a(this.jZj, aVar);
                    int i3 = aVar.pos;
                    switch (aVar.modulus) {
                        case 0:
                            break;
                        case 1:
                            int i4 = aVar.pos;
                            aVar.pos = i4 + 1;
                            a[i4] = this.jZf[(aVar.jZo >> 2) & 63];
                            int i5 = aVar.pos;
                            aVar.pos = i5 + 1;
                            a[i5] = this.jZf[(aVar.jZo << 4) & 63];
                            if (this.jZf == jZc) {
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
                            a[i8] = this.jZf[(aVar.jZo >> 10) & 63];
                            int i9 = aVar.pos;
                            aVar.pos = i9 + 1;
                            a[i9] = this.jZf[(aVar.jZo >> 4) & 63];
                            int i10 = aVar.pos;
                            aVar.pos = i10 + 1;
                            a[i10] = this.jZf[(aVar.jZo << 2) & 63];
                            if (this.jZf == jZc) {
                                int i11 = aVar.pos;
                                aVar.pos = i11 + 1;
                                a[i11] = 61;
                                break;
                            }
                            break;
                        default:
                            throw new IllegalStateException("Impossible modulus " + aVar.modulus);
                    }
                    aVar.jZs = (aVar.pos - i3) + aVar.jZs;
                    if (this.lineLength > 0 && aVar.jZs > 0) {
                        System.arraycopy(this.jZh, 0, a, aVar.pos, this.jZh.length);
                        aVar.pos += this.jZh.length;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            while (i12 < i2) {
                byte[] a2 = a(this.jZj, aVar);
                aVar.modulus = (aVar.modulus + 1) % 3;
                int i13 = i + 1;
                int i14 = bArr[i];
                if (i14 < 0) {
                    i14 += 256;
                }
                aVar.jZo = i14 + (aVar.jZo << 8);
                if (aVar.modulus == 0) {
                    int i15 = aVar.pos;
                    aVar.pos = i15 + 1;
                    a2[i15] = this.jZf[(aVar.jZo >> 18) & 63];
                    int i16 = aVar.pos;
                    aVar.pos = i16 + 1;
                    a2[i16] = this.jZf[(aVar.jZo >> 12) & 63];
                    int i17 = aVar.pos;
                    aVar.pos = i17 + 1;
                    a2[i17] = this.jZf[(aVar.jZo >> 6) & 63];
                    int i18 = aVar.pos;
                    aVar.pos = i18 + 1;
                    a2[i18] = this.jZf[aVar.jZo & 63];
                    aVar.jZs += 4;
                    if (this.lineLength > 0 && this.lineLength <= aVar.jZs) {
                        System.arraycopy(this.jZh, 0, a2, aVar.pos, this.jZh.length);
                        aVar.pos += this.jZh.length;
                        aVar.jZs = 0;
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
        if (!aVar.jZr) {
            if (i2 < 0) {
                aVar.jZr = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                byte[] a = a(this.jZi, aVar);
                int i4 = i + 1;
                byte b2 = bArr[i];
                if (b2 == 61) {
                    aVar.jZr = true;
                    break;
                }
                if (b2 >= 0 && b2 < jZe.length && (b = jZe[b2]) >= 0) {
                    aVar.modulus = (aVar.modulus + 1) % 4;
                    aVar.jZo = b + (aVar.jZo << 6);
                    if (aVar.modulus == 0) {
                        int i5 = aVar.pos;
                        aVar.pos = i5 + 1;
                        a[i5] = (byte) ((aVar.jZo >> 16) & 255);
                        int i6 = aVar.pos;
                        aVar.pos = i6 + 1;
                        a[i6] = (byte) ((aVar.jZo >> 8) & 255);
                        int i7 = aVar.pos;
                        aVar.pos = i7 + 1;
                        a[i7] = (byte) (aVar.jZo & 255);
                    }
                }
                i3++;
                i = i4;
            }
            if (aVar.jZr && aVar.modulus != 0) {
                byte[] a2 = a(this.jZi, aVar);
                switch (aVar.modulus) {
                    case 1:
                        return;
                    case 2:
                        aVar.jZo >>= 4;
                        int i8 = aVar.pos;
                        aVar.pos = i8 + 1;
                        a2[i8] = (byte) (aVar.jZo & 255);
                        return;
                    case 3:
                        aVar.jZo >>= 2;
                        int i9 = aVar.pos;
                        aVar.pos = i9 + 1;
                        a2[i9] = (byte) ((aVar.jZo >> 8) & 255);
                        int i10 = aVar.pos;
                        aVar.pos = i10 + 1;
                        a2[i10] = (byte) (aVar.jZo & 255);
                        return;
                    default:
                        throw new IllegalStateException("Impossible modulus " + aVar.modulus);
                }
            }
        }
    }

    public static String I(byte[] bArr) {
        return d.L(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return a(bArr, z, false);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2) {
        return a(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] a(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr != null && bArr.length != 0) {
            a aVar = z ? new a(z2) : new a(0, jZb, z2);
            long K = aVar.K(bArr);
            if (K > i) {
                throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + K + ") than the specified maximum size of " + i);
            }
            return aVar.encode(bArr);
        }
        return bArr;
    }

    public static byte[] Go(String str) {
        return new a().decode(str);
    }

    @Override // com.baidu.ueg.lib.b
    protected boolean b(byte b) {
        return b >= 0 && b < this.jZg.length && this.jZg[b] != -1;
    }
}
