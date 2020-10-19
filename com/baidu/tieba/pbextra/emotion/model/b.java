package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
class b {
    int lAc;
    int lAd;
    int lAe;
    int lAi;
    private int lzN;
    private int lzO;
    private byte[] lzP;
    private int lzQ;
    private int lzR;
    private int lzS;
    int lzT;
    int lzV;
    int lzU = 12;
    int lzW = 4096;
    int[] lzX = new int[5003];
    int[] lzY = new int[5003];
    int lzZ = 5003;
    int lAa = 0;
    boolean lAb = false;
    int lAf = 0;
    int lAg = 0;
    int[] lAh = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lAj = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lzN = i;
        this.lzO = i2;
        this.lzP = bArr;
        this.lzQ = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lAj;
        int i = this.lAi;
        this.lAi = i + 1;
        bArr[i] = b;
        if (this.lAi >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Gf(this.lzZ);
        this.lAa = this.lAd + 2;
        this.lAb = true;
        b(this.lAd, outputStream);
    }

    void Gf(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lzX[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lAc = i;
        this.lAb = false;
        this.lzT = this.lAc;
        this.lzV = Gg(this.lzT);
        this.lAd = 1 << (i - 1);
        this.lAe = this.lAd + 1;
        this.lAa = this.lAd + 2;
        this.lAi = 0;
        int dni = dni();
        for (int i3 = this.lzZ; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lzZ;
        Gf(i5);
        b(this.lAd, outputStream);
        while (true) {
            int dni2 = dni();
            if (dni2 != -1) {
                int i6 = (dni2 << this.lzU) + dni;
                int i7 = (dni2 << i4) ^ dni;
                if (this.lzX[i7] == i6) {
                    dni = this.lzY[i7];
                } else {
                    if (this.lzX[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lzX[i7] == i6) {
                                dni = this.lzY[i7];
                                break;
                            }
                        } while (this.lzX[i7] >= 0);
                    }
                    b(dni, outputStream);
                    if (this.lAa < this.lzW) {
                        int[] iArr = this.lzY;
                        int i9 = this.lAa;
                        this.lAa = i9 + 1;
                        iArr[i7] = i9;
                        this.lzX[i7] = i6;
                        dni = dni2;
                    } else {
                        c(outputStream);
                        dni = dni2;
                    }
                }
            } else {
                b(dni, outputStream);
                b(this.lAe, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lzQ);
        this.lzR = this.lzN * this.lzO;
        this.lzS = 0;
        a(this.lzQ + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lAi > 0) {
            outputStream.write(this.lAi);
            outputStream.write(this.lAj, 0, this.lAi);
            this.lAi = 0;
        }
    }

    final int Gg(int i) {
        return (1 << i) - 1;
    }

    private int dni() {
        if (this.lzR == 0) {
            return -1;
        }
        this.lzR--;
        byte[] bArr = this.lzP;
        int i = this.lzS;
        this.lzS = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lAf &= this.lAh[this.lAg];
        if (this.lAg > 0) {
            this.lAf |= i << this.lAg;
        } else {
            this.lAf = i;
        }
        this.lAg += this.lzT;
        while (this.lAg >= 8) {
            a((byte) (this.lAf & 255), outputStream);
            this.lAf >>= 8;
            this.lAg -= 8;
        }
        if (this.lAa > this.lzV || this.lAb) {
            if (this.lAb) {
                int i2 = this.lAc;
                this.lzT = i2;
                this.lzV = Gg(i2);
                this.lAb = false;
            } else {
                this.lzT++;
                if (this.lzT == this.lzU) {
                    this.lzV = this.lzW;
                } else {
                    this.lzV = Gg(this.lzT);
                }
            }
        }
        if (i == this.lAe) {
            while (this.lAg > 0) {
                a((byte) (this.lAf & 255), outputStream);
                this.lAf >>= 8;
                this.lAg -= 8;
            }
            d(outputStream);
        }
    }
}
