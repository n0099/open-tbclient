package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    private int igA;
    private int igB;
    private byte[] igC;
    private int igD;
    private int igE;
    private int igF;
    int igG;
    int igI;
    int igP;
    int igQ;
    int igR;
    int igV;
    int igH = 12;
    int igJ = 4096;
    int[] igK = new int[5003];
    int[] igL = new int[5003];
    int igM = 5003;
    int igN = 0;
    boolean igO = false;
    int igS = 0;
    int igT = 0;
    int[] igU = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] igW = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.igA = i;
        this.igB = i2;
        this.igC = bArr;
        this.igD = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.igW;
        int i = this.igV;
        this.igV = i + 1;
        bArr[i] = b;
        if (this.igV >= 254) {
            h(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        yz(this.igM);
        this.igN = this.igQ + 2;
        this.igO = true;
        b(this.igQ, outputStream);
    }

    void yz(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.igK[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.igP = i;
        this.igO = false;
        this.igG = this.igP;
        this.igI = yA(this.igG);
        this.igQ = 1 << (i - 1);
        this.igR = this.igQ + 1;
        this.igN = this.igQ + 2;
        this.igV = 0;
        int caz = caz();
        for (int i3 = this.igM; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.igM;
        yz(i5);
        b(this.igQ, outputStream);
        while (true) {
            int caz2 = caz();
            if (caz2 != -1) {
                int i6 = (caz2 << this.igH) + caz;
                int i7 = (caz2 << i4) ^ caz;
                if (this.igK[i7] == i6) {
                    caz = this.igL[i7];
                } else {
                    if (this.igK[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.igK[i7] == i6) {
                                caz = this.igL[i7];
                                break;
                            }
                        } while (this.igK[i7] >= 0);
                    }
                    b(caz, outputStream);
                    if (this.igN < this.igJ) {
                        int[] iArr = this.igL;
                        int i9 = this.igN;
                        this.igN = i9 + 1;
                        iArr[i7] = i9;
                        this.igK[i7] = i6;
                        caz = caz2;
                    } else {
                        f(outputStream);
                        caz = caz2;
                    }
                }
            } else {
                b(caz, outputStream);
                b(this.igR, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(OutputStream outputStream) throws IOException {
        outputStream.write(this.igD);
        this.igE = this.igA * this.igB;
        this.igF = 0;
        a(this.igD + 1, outputStream);
        outputStream.write(0);
    }

    void h(OutputStream outputStream) throws IOException {
        if (this.igV > 0) {
            outputStream.write(this.igV);
            outputStream.write(this.igW, 0, this.igV);
            this.igV = 0;
        }
    }

    final int yA(int i) {
        return (1 << i) - 1;
    }

    private int caz() {
        if (this.igE == 0) {
            return -1;
        }
        this.igE--;
        byte[] bArr = this.igC;
        int i = this.igF;
        this.igF = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.igS &= this.igU[this.igT];
        if (this.igT > 0) {
            this.igS |= i << this.igT;
        } else {
            this.igS = i;
        }
        this.igT += this.igG;
        while (this.igT >= 8) {
            a((byte) (this.igS & 255), outputStream);
            this.igS >>= 8;
            this.igT -= 8;
        }
        if (this.igN > this.igI || this.igO) {
            if (this.igO) {
                int i2 = this.igP;
                this.igG = i2;
                this.igI = yA(i2);
                this.igO = false;
            } else {
                this.igG++;
                if (this.igG == this.igH) {
                    this.igI = this.igJ;
                } else {
                    this.igI = yA(this.igG);
                }
            }
        }
        if (i == this.igR) {
            while (this.igT > 0) {
                a((byte) (this.igS & 255), outputStream);
                this.igS >>= 8;
                this.igT -= 8;
            }
            h(outputStream);
        }
    }
}
