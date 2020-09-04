package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes16.dex */
class b {
    private int lbE;
    private int lbF;
    private byte[] lbG;
    private int lbH;
    private int lbI;
    private int lbJ;
    int lbK;
    int lbM;
    int lbT;
    int lbU;
    int lbV;
    int lbZ;
    int lbL = 12;
    int lbN = 4096;
    int[] lbO = new int[5003];
    int[] lbP = new int[5003];
    int lbQ = 5003;
    int lbR = 0;
    boolean lbS = false;
    int lbW = 0;
    int lbX = 0;
    int[] lbY = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lca = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lbE = i;
        this.lbF = i2;
        this.lbG = bArr;
        this.lbH = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lca;
        int i = this.lbZ;
        this.lbZ = i + 1;
        bArr[i] = b;
        if (this.lbZ >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        EY(this.lbQ);
        this.lbR = this.lbU + 2;
        this.lbS = true;
        b(this.lbU, outputStream);
    }

    void EY(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lbO[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lbT = i;
        this.lbS = false;
        this.lbK = this.lbT;
        this.lbM = EZ(this.lbK);
        this.lbU = 1 << (i - 1);
        this.lbV = this.lbU + 1;
        this.lbR = this.lbU + 2;
        this.lbZ = 0;
        int dfW = dfW();
        for (int i3 = this.lbQ; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lbQ;
        EY(i5);
        b(this.lbU, outputStream);
        while (true) {
            int dfW2 = dfW();
            if (dfW2 != -1) {
                int i6 = (dfW2 << this.lbL) + dfW;
                int i7 = (dfW2 << i4) ^ dfW;
                if (this.lbO[i7] == i6) {
                    dfW = this.lbP[i7];
                } else {
                    if (this.lbO[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lbO[i7] == i6) {
                                dfW = this.lbP[i7];
                                break;
                            }
                        } while (this.lbO[i7] >= 0);
                    }
                    b(dfW, outputStream);
                    if (this.lbR < this.lbN) {
                        int[] iArr = this.lbP;
                        int i9 = this.lbR;
                        this.lbR = i9 + 1;
                        iArr[i7] = i9;
                        this.lbO[i7] = i6;
                        dfW = dfW2;
                    } else {
                        c(outputStream);
                        dfW = dfW2;
                    }
                }
            } else {
                b(dfW, outputStream);
                b(this.lbV, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lbH);
        this.lbI = this.lbE * this.lbF;
        this.lbJ = 0;
        a(this.lbH + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lbZ > 0) {
            outputStream.write(this.lbZ);
            outputStream.write(this.lca, 0, this.lbZ);
            this.lbZ = 0;
        }
    }

    final int EZ(int i) {
        return (1 << i) - 1;
    }

    private int dfW() {
        if (this.lbI == 0) {
            return -1;
        }
        this.lbI--;
        byte[] bArr = this.lbG;
        int i = this.lbJ;
        this.lbJ = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lbW &= this.lbY[this.lbX];
        if (this.lbX > 0) {
            this.lbW |= i << this.lbX;
        } else {
            this.lbW = i;
        }
        this.lbX += this.lbK;
        while (this.lbX >= 8) {
            a((byte) (this.lbW & 255), outputStream);
            this.lbW >>= 8;
            this.lbX -= 8;
        }
        if (this.lbR > this.lbM || this.lbS) {
            if (this.lbS) {
                int i2 = this.lbT;
                this.lbK = i2;
                this.lbM = EZ(i2);
                this.lbS = false;
            } else {
                this.lbK++;
                if (this.lbK == this.lbL) {
                    this.lbM = this.lbN;
                } else {
                    this.lbM = EZ(this.lbK);
                }
            }
        }
        if (i == this.lbV) {
            while (this.lbX > 0) {
                a((byte) (this.lbW & 255), outputStream);
                this.lbW >>= 8;
                this.lbX -= 8;
            }
            d(outputStream);
        }
    }
}
