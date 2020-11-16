package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes21.dex */
class b {
    private int lSA;
    private int lSB;
    int lSC;
    int lSE;
    int lSL;
    int lSM;
    int lSN;
    int lSR;
    private int lSw;
    private int lSx;
    private byte[] lSy;
    private int lSz;
    int lSD = 12;
    int lSF = 4096;
    int[] lSG = new int[5003];
    int[] lSH = new int[5003];
    int lSI = 5003;
    int lSJ = 0;
    boolean lSK = false;
    int lSO = 0;
    int lSP = 0;
    int[] lSQ = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lSS = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lSw = i;
        this.lSx = i2;
        this.lSy = bArr;
        this.lSz = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lSS;
        int i = this.lSR;
        this.lSR = i + 1;
        bArr[i] = b;
        if (this.lSR >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Hj(this.lSI);
        this.lSJ = this.lSM + 2;
        this.lSK = true;
        b(this.lSM, outputStream);
    }

    void Hj(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lSG[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lSL = i;
        this.lSK = false;
        this.lSC = this.lSL;
        this.lSE = Hk(this.lSC);
        this.lSM = 1 << (i - 1);
        this.lSN = this.lSM + 1;
        this.lSJ = this.lSM + 2;
        this.lSR = 0;
        int dss = dss();
        for (int i3 = this.lSI; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lSI;
        Hj(i5);
        b(this.lSM, outputStream);
        while (true) {
            int dss2 = dss();
            if (dss2 != -1) {
                int i6 = (dss2 << this.lSD) + dss;
                int i7 = (dss2 << i4) ^ dss;
                if (this.lSG[i7] == i6) {
                    dss = this.lSH[i7];
                } else {
                    if (this.lSG[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lSG[i7] == i6) {
                                dss = this.lSH[i7];
                                break;
                            }
                        } while (this.lSG[i7] >= 0);
                    }
                    b(dss, outputStream);
                    if (this.lSJ < this.lSF) {
                        int[] iArr = this.lSH;
                        int i9 = this.lSJ;
                        this.lSJ = i9 + 1;
                        iArr[i7] = i9;
                        this.lSG[i7] = i6;
                        dss = dss2;
                    } else {
                        c(outputStream);
                        dss = dss2;
                    }
                }
            } else {
                b(dss, outputStream);
                b(this.lSN, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lSz);
        this.lSA = this.lSw * this.lSx;
        this.lSB = 0;
        a(this.lSz + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lSR > 0) {
            outputStream.write(this.lSR);
            outputStream.write(this.lSS, 0, this.lSR);
            this.lSR = 0;
        }
    }

    final int Hk(int i) {
        return (1 << i) - 1;
    }

    private int dss() {
        if (this.lSA == 0) {
            return -1;
        }
        this.lSA--;
        byte[] bArr = this.lSy;
        int i = this.lSB;
        this.lSB = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lSO &= this.lSQ[this.lSP];
        if (this.lSP > 0) {
            this.lSO |= i << this.lSP;
        } else {
            this.lSO = i;
        }
        this.lSP += this.lSC;
        while (this.lSP >= 8) {
            a((byte) (this.lSO & 255), outputStream);
            this.lSO >>= 8;
            this.lSP -= 8;
        }
        if (this.lSJ > this.lSE || this.lSK) {
            if (this.lSK) {
                int i2 = this.lSL;
                this.lSC = i2;
                this.lSE = Hk(i2);
                this.lSK = false;
            } else {
                this.lSC++;
                if (this.lSC == this.lSD) {
                    this.lSE = this.lSF;
                } else {
                    this.lSE = Hk(this.lSC);
                }
            }
        }
        if (i == this.lSN) {
            while (this.lSP > 0) {
                a((byte) (this.lSO & 255), outputStream);
                this.lSO >>= 8;
                this.lSP -= 8;
            }
            d(outputStream);
        }
    }
}
