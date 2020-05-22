package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int khL;
    private int khM;
    private byte[] khN;
    private int khO;
    private int khP;
    private int khQ;
    int khR;
    int khT;
    int kia;
    int kib;
    int kic;
    int kih;
    int khS = 12;
    int khU = 4096;
    int[] khV = new int[5003];
    int[] khW = new int[5003];
    int khX = 5003;
    int khY = 0;
    boolean khZ = false;
    int kie = 0;
    int kif = 0;
    int[] kig = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] kii = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.khL = i;
        this.khM = i2;
        this.khN = bArr;
        this.khO = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.kii;
        int i = this.kih;
        this.kih = i + 1;
        bArr[i] = b;
        if (this.kih >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Ba(this.khX);
        this.khY = this.kib + 2;
        this.khZ = true;
        b(this.kib, outputStream);
    }

    void Ba(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.khV[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.kia = i;
        this.khZ = false;
        this.khR = this.kia;
        this.khT = Bb(this.khR);
        this.kib = 1 << (i - 1);
        this.kic = this.kib + 1;
        this.khY = this.kib + 2;
        this.kih = 0;
        int cMA = cMA();
        for (int i3 = this.khX; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.khX;
        Ba(i5);
        b(this.kib, outputStream);
        while (true) {
            int cMA2 = cMA();
            if (cMA2 != -1) {
                int i6 = (cMA2 << this.khS) + cMA;
                int i7 = (cMA2 << i4) ^ cMA;
                if (this.khV[i7] == i6) {
                    cMA = this.khW[i7];
                } else {
                    if (this.khV[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.khV[i7] == i6) {
                                cMA = this.khW[i7];
                                break;
                            }
                        } while (this.khV[i7] >= 0);
                    }
                    b(cMA, outputStream);
                    if (this.khY < this.khU) {
                        int[] iArr = this.khW;
                        int i9 = this.khY;
                        this.khY = i9 + 1;
                        iArr[i7] = i9;
                        this.khV[i7] = i6;
                        cMA = cMA2;
                    } else {
                        c(outputStream);
                        cMA = cMA2;
                    }
                }
            } else {
                b(cMA, outputStream);
                b(this.kic, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.khO);
        this.khP = this.khL * this.khM;
        this.khQ = 0;
        a(this.khO + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.kih > 0) {
            outputStream.write(this.kih);
            outputStream.write(this.kii, 0, this.kih);
            this.kih = 0;
        }
    }

    final int Bb(int i) {
        return (1 << i) - 1;
    }

    private int cMA() {
        if (this.khP == 0) {
            return -1;
        }
        this.khP--;
        byte[] bArr = this.khN;
        int i = this.khQ;
        this.khQ = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.kie &= this.kig[this.kif];
        if (this.kif > 0) {
            this.kie |= i << this.kif;
        } else {
            this.kie = i;
        }
        this.kif += this.khR;
        while (this.kif >= 8) {
            a((byte) (this.kie & 255), outputStream);
            this.kie >>= 8;
            this.kif -= 8;
        }
        if (this.khY > this.khT || this.khZ) {
            if (this.khZ) {
                int i2 = this.kia;
                this.khR = i2;
                this.khT = Bb(i2);
                this.khZ = false;
            } else {
                this.khR++;
                if (this.khR == this.khS) {
                    this.khT = this.khU;
                } else {
                    this.khT = Bb(this.khR);
                }
            }
        }
        if (i == this.kic) {
            while (this.kif > 0) {
                a((byte) (this.kie & 255), outputStream);
                this.kie >>= 8;
                this.kif -= 8;
            }
            d(outputStream);
        }
    }
}
