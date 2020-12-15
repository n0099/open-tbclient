package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
class b {
    private int mgD;
    private int mgE;
    private byte[] mgF;
    private int mgG;
    private int mgH;
    private int mgI;
    int mgJ;
    int mgL;
    int mgS;
    int mgT;
    int mgU;
    int mgY;
    int mgK = 12;
    int mgM = 4096;
    int[] mgN = new int[5003];
    int[] mgO = new int[5003];
    int mgP = 5003;
    int mgQ = 0;
    boolean mgR = false;
    int mgV = 0;
    int mgW = 0;
    int[] mgX = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] mgZ = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mgD = i;
        this.mgE = i2;
        this.mgF = bArr;
        this.mgG = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mgZ;
        int i = this.mgY;
        this.mgY = i + 1;
        bArr[i] = b;
        if (this.mgY >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Ia(this.mgP);
        this.mgQ = this.mgT + 2;
        this.mgR = true;
        b(this.mgT, outputStream);
    }

    void Ia(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mgN[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mgS = i;
        this.mgR = false;
        this.mgJ = this.mgS;
        this.mgL = Ib(this.mgJ);
        this.mgT = 1 << (i - 1);
        this.mgU = this.mgT + 1;
        this.mgQ = this.mgT + 2;
        this.mgY = 0;
        int dxL = dxL();
        for (int i3 = this.mgP; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mgP;
        Ia(i5);
        b(this.mgT, outputStream);
        while (true) {
            int dxL2 = dxL();
            if (dxL2 != -1) {
                int i6 = (dxL2 << this.mgK) + dxL;
                int i7 = (dxL2 << i4) ^ dxL;
                if (this.mgN[i7] == i6) {
                    dxL = this.mgO[i7];
                } else {
                    if (this.mgN[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mgN[i7] == i6) {
                                dxL = this.mgO[i7];
                                break;
                            }
                        } while (this.mgN[i7] >= 0);
                    }
                    b(dxL, outputStream);
                    if (this.mgQ < this.mgM) {
                        int[] iArr = this.mgO;
                        int i9 = this.mgQ;
                        this.mgQ = i9 + 1;
                        iArr[i7] = i9;
                        this.mgN[i7] = i6;
                        dxL = dxL2;
                    } else {
                        c(outputStream);
                        dxL = dxL2;
                    }
                }
            } else {
                b(dxL, outputStream);
                b(this.mgU, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mgG);
        this.mgH = this.mgD * this.mgE;
        this.mgI = 0;
        a(this.mgG + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mgY > 0) {
            outputStream.write(this.mgY);
            outputStream.write(this.mgZ, 0, this.mgY);
            this.mgY = 0;
        }
    }

    final int Ib(int i) {
        return (1 << i) - 1;
    }

    private int dxL() {
        if (this.mgH == 0) {
            return -1;
        }
        this.mgH--;
        byte[] bArr = this.mgF;
        int i = this.mgI;
        this.mgI = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mgV &= this.mgX[this.mgW];
        if (this.mgW > 0) {
            this.mgV |= i << this.mgW;
        } else {
            this.mgV = i;
        }
        this.mgW += this.mgJ;
        while (this.mgW >= 8) {
            a((byte) (this.mgV & 255), outputStream);
            this.mgV >>= 8;
            this.mgW -= 8;
        }
        if (this.mgQ > this.mgL || this.mgR) {
            if (this.mgR) {
                int i2 = this.mgS;
                this.mgJ = i2;
                this.mgL = Ib(i2);
                this.mgR = false;
            } else {
                this.mgJ++;
                if (this.mgJ == this.mgK) {
                    this.mgL = this.mgM;
                } else {
                    this.mgL = Ib(this.mgJ);
                }
            }
        }
        if (i == this.mgU) {
            while (this.mgW > 0) {
                a((byte) (this.mgV & 255), outputStream);
                this.mgV >>= 8;
                this.mgW -= 8;
            }
            d(outputStream);
        }
    }
}
