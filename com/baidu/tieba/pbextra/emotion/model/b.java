package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int kCE;
    private int kCF;
    private byte[] kCG;
    private int kCH;
    private int kCI;
    private int kCJ;
    int kCK;
    int kCM;
    int kCT;
    int kCU;
    int kCV;
    int kCZ;
    int kCL = 12;
    int kCN = 4096;
    int[] kCO = new int[5003];
    int[] kCP = new int[5003];
    int kCQ = 5003;
    int kCR = 0;
    boolean kCS = false;
    int kCW = 0;
    int kCX = 0;
    int[] kCY = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] kDa = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.kCE = i;
        this.kCF = i2;
        this.kCG = bArr;
        this.kCH = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.kDa;
        int i = this.kCZ;
        this.kCZ = i + 1;
        bArr[i] = b;
        if (this.kCZ >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Ce(this.kCQ);
        this.kCR = this.kCU + 2;
        this.kCS = true;
        b(this.kCU, outputStream);
    }

    void Ce(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.kCO[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.kCT = i;
        this.kCS = false;
        this.kCK = this.kCT;
        this.kCM = Cf(this.kCK);
        this.kCU = 1 << (i - 1);
        this.kCV = this.kCU + 1;
        this.kCR = this.kCU + 2;
        this.kCZ = 0;
        int cRi = cRi();
        for (int i3 = this.kCQ; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.kCQ;
        Ce(i5);
        b(this.kCU, outputStream);
        while (true) {
            int cRi2 = cRi();
            if (cRi2 != -1) {
                int i6 = (cRi2 << this.kCL) + cRi;
                int i7 = (cRi2 << i4) ^ cRi;
                if (this.kCO[i7] == i6) {
                    cRi = this.kCP[i7];
                } else {
                    if (this.kCO[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.kCO[i7] == i6) {
                                cRi = this.kCP[i7];
                                break;
                            }
                        } while (this.kCO[i7] >= 0);
                    }
                    b(cRi, outputStream);
                    if (this.kCR < this.kCN) {
                        int[] iArr = this.kCP;
                        int i9 = this.kCR;
                        this.kCR = i9 + 1;
                        iArr[i7] = i9;
                        this.kCO[i7] = i6;
                        cRi = cRi2;
                    } else {
                        c(outputStream);
                        cRi = cRi2;
                    }
                }
            } else {
                b(cRi, outputStream);
                b(this.kCV, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.kCH);
        this.kCI = this.kCE * this.kCF;
        this.kCJ = 0;
        a(this.kCH + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.kCZ > 0) {
            outputStream.write(this.kCZ);
            outputStream.write(this.kDa, 0, this.kCZ);
            this.kCZ = 0;
        }
    }

    final int Cf(int i) {
        return (1 << i) - 1;
    }

    private int cRi() {
        if (this.kCI == 0) {
            return -1;
        }
        this.kCI--;
        byte[] bArr = this.kCG;
        int i = this.kCJ;
        this.kCJ = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.kCW &= this.kCY[this.kCX];
        if (this.kCX > 0) {
            this.kCW |= i << this.kCX;
        } else {
            this.kCW = i;
        }
        this.kCX += this.kCK;
        while (this.kCX >= 8) {
            a((byte) (this.kCW & 255), outputStream);
            this.kCW >>= 8;
            this.kCX -= 8;
        }
        if (this.kCR > this.kCM || this.kCS) {
            if (this.kCS) {
                int i2 = this.kCT;
                this.kCK = i2;
                this.kCM = Cf(i2);
                this.kCS = false;
            } else {
                this.kCK++;
                if (this.kCK == this.kCL) {
                    this.kCM = this.kCN;
                } else {
                    this.kCM = Cf(this.kCK);
                }
            }
        }
        if (i == this.kCV) {
            while (this.kCX > 0) {
                a((byte) (this.kCW & 255), outputStream);
                this.kCW >>= 8;
                this.kCX -= 8;
            }
            d(outputStream);
        }
    }
}
