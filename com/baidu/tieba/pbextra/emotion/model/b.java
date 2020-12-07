package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
class b {
    private int mgB;
    private int mgC;
    private byte[] mgD;
    private int mgE;
    private int mgF;
    private int mgG;
    int mgH;
    int mgJ;
    int mgQ;
    int mgR;
    int mgS;
    int mgW;
    int mgI = 12;
    int mgK = 4096;
    int[] mgL = new int[5003];
    int[] mgM = new int[5003];
    int mgN = 5003;
    int mgO = 0;
    boolean mgP = false;
    int mgT = 0;
    int mgU = 0;
    int[] mgV = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] mgX = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mgB = i;
        this.mgC = i2;
        this.mgD = bArr;
        this.mgE = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mgX;
        int i = this.mgW;
        this.mgW = i + 1;
        bArr[i] = b;
        if (this.mgW >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Ia(this.mgN);
        this.mgO = this.mgR + 2;
        this.mgP = true;
        b(this.mgR, outputStream);
    }

    void Ia(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mgL[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mgQ = i;
        this.mgP = false;
        this.mgH = this.mgQ;
        this.mgJ = Ib(this.mgH);
        this.mgR = 1 << (i - 1);
        this.mgS = this.mgR + 1;
        this.mgO = this.mgR + 2;
        this.mgW = 0;
        int dxK = dxK();
        for (int i3 = this.mgN; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mgN;
        Ia(i5);
        b(this.mgR, outputStream);
        while (true) {
            int dxK2 = dxK();
            if (dxK2 != -1) {
                int i6 = (dxK2 << this.mgI) + dxK;
                int i7 = (dxK2 << i4) ^ dxK;
                if (this.mgL[i7] == i6) {
                    dxK = this.mgM[i7];
                } else {
                    if (this.mgL[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mgL[i7] == i6) {
                                dxK = this.mgM[i7];
                                break;
                            }
                        } while (this.mgL[i7] >= 0);
                    }
                    b(dxK, outputStream);
                    if (this.mgO < this.mgK) {
                        int[] iArr = this.mgM;
                        int i9 = this.mgO;
                        this.mgO = i9 + 1;
                        iArr[i7] = i9;
                        this.mgL[i7] = i6;
                        dxK = dxK2;
                    } else {
                        c(outputStream);
                        dxK = dxK2;
                    }
                }
            } else {
                b(dxK, outputStream);
                b(this.mgS, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mgE);
        this.mgF = this.mgB * this.mgC;
        this.mgG = 0;
        a(this.mgE + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mgW > 0) {
            outputStream.write(this.mgW);
            outputStream.write(this.mgX, 0, this.mgW);
            this.mgW = 0;
        }
    }

    final int Ib(int i) {
        return (1 << i) - 1;
    }

    private int dxK() {
        if (this.mgF == 0) {
            return -1;
        }
        this.mgF--;
        byte[] bArr = this.mgD;
        int i = this.mgG;
        this.mgG = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mgT &= this.mgV[this.mgU];
        if (this.mgU > 0) {
            this.mgT |= i << this.mgU;
        } else {
            this.mgT = i;
        }
        this.mgU += this.mgH;
        while (this.mgU >= 8) {
            a((byte) (this.mgT & 255), outputStream);
            this.mgT >>= 8;
            this.mgU -= 8;
        }
        if (this.mgO > this.mgJ || this.mgP) {
            if (this.mgP) {
                int i2 = this.mgQ;
                this.mgH = i2;
                this.mgJ = Ib(i2);
                this.mgP = false;
            } else {
                this.mgH++;
                if (this.mgH == this.mgI) {
                    this.mgJ = this.mgK;
                } else {
                    this.mgJ = Ib(this.mgH);
                }
            }
        }
        if (i == this.mgS) {
            while (this.mgU > 0) {
                a((byte) (this.mgT & 255), outputStream);
                this.mgT >>= 8;
                this.mgU -= 8;
            }
            d(outputStream);
        }
    }
}
