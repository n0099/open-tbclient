package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes16.dex */
class b {
    private int lbA;
    private int lbB;
    private int lbC;
    int lbD;
    int lbF;
    int lbM;
    int lbN;
    int lbO;
    int lbS;
    private int lbx;
    private int lby;
    private byte[] lbz;
    int lbE = 12;
    int lbG = 4096;
    int[] lbH = new int[5003];
    int[] lbI = new int[5003];
    int lbJ = 5003;
    int lbK = 0;
    boolean lbL = false;
    int lbP = 0;
    int lbQ = 0;
    int[] lbR = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lbT = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lbx = i;
        this.lby = i2;
        this.lbz = bArr;
        this.lbA = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lbT;
        int i = this.lbS;
        this.lbS = i + 1;
        bArr[i] = b;
        if (this.lbS >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        EY(this.lbJ);
        this.lbK = this.lbN + 2;
        this.lbL = true;
        b(this.lbN, outputStream);
    }

    void EY(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lbH[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lbM = i;
        this.lbL = false;
        this.lbD = this.lbM;
        this.lbF = EZ(this.lbD);
        this.lbN = 1 << (i - 1);
        this.lbO = this.lbN + 1;
        this.lbK = this.lbN + 2;
        this.lbS = 0;
        int dfV = dfV();
        for (int i3 = this.lbJ; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lbJ;
        EY(i5);
        b(this.lbN, outputStream);
        while (true) {
            int dfV2 = dfV();
            if (dfV2 != -1) {
                int i6 = (dfV2 << this.lbE) + dfV;
                int i7 = (dfV2 << i4) ^ dfV;
                if (this.lbH[i7] == i6) {
                    dfV = this.lbI[i7];
                } else {
                    if (this.lbH[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lbH[i7] == i6) {
                                dfV = this.lbI[i7];
                                break;
                            }
                        } while (this.lbH[i7] >= 0);
                    }
                    b(dfV, outputStream);
                    if (this.lbK < this.lbG) {
                        int[] iArr = this.lbI;
                        int i9 = this.lbK;
                        this.lbK = i9 + 1;
                        iArr[i7] = i9;
                        this.lbH[i7] = i6;
                        dfV = dfV2;
                    } else {
                        c(outputStream);
                        dfV = dfV2;
                    }
                }
            } else {
                b(dfV, outputStream);
                b(this.lbO, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lbA);
        this.lbB = this.lbx * this.lby;
        this.lbC = 0;
        a(this.lbA + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lbS > 0) {
            outputStream.write(this.lbS);
            outputStream.write(this.lbT, 0, this.lbS);
            this.lbS = 0;
        }
    }

    final int EZ(int i) {
        return (1 << i) - 1;
    }

    private int dfV() {
        if (this.lbB == 0) {
            return -1;
        }
        this.lbB--;
        byte[] bArr = this.lbz;
        int i = this.lbC;
        this.lbC = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lbP &= this.lbR[this.lbQ];
        if (this.lbQ > 0) {
            this.lbP |= i << this.lbQ;
        } else {
            this.lbP = i;
        }
        this.lbQ += this.lbD;
        while (this.lbQ >= 8) {
            a((byte) (this.lbP & 255), outputStream);
            this.lbP >>= 8;
            this.lbQ -= 8;
        }
        if (this.lbK > this.lbF || this.lbL) {
            if (this.lbL) {
                int i2 = this.lbM;
                this.lbD = i2;
                this.lbF = EZ(i2);
                this.lbL = false;
            } else {
                this.lbD++;
                if (this.lbD == this.lbE) {
                    this.lbF = this.lbG;
                } else {
                    this.lbF = EZ(this.lbD);
                }
            }
        }
        if (i == this.lbO) {
            while (this.lbQ > 0) {
                a((byte) (this.lbP & 255), outputStream);
                this.lbP >>= 8;
                this.lbQ -= 8;
            }
            d(outputStream);
        }
    }
}
