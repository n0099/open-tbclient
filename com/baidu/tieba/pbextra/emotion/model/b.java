package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    private int ijB;
    private int ijC;
    private byte[] ijD;
    private int ijE;
    private int ijF;
    private int ijG;
    int ijH;
    int ijJ;
    int ijQ;
    int ijR;
    int ijS;
    int ijW;
    int ijI = 12;
    int ijK = 4096;
    int[] ijL = new int[5003];
    int[] ijM = new int[5003];
    int ijN = 5003;
    int ijO = 0;
    boolean ijP = false;
    int ijT = 0;
    int ijU = 0;
    int[] ijV = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ijX = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.ijB = i;
        this.ijC = i2;
        this.ijD = bArr;
        this.ijE = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ijX;
        int i = this.ijW;
        this.ijW = i + 1;
        bArr[i] = b;
        if (this.ijW >= 254) {
            h(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        yE(this.ijN);
        this.ijO = this.ijR + 2;
        this.ijP = true;
        b(this.ijR, outputStream);
    }

    void yE(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ijL[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ijQ = i;
        this.ijP = false;
        this.ijH = this.ijQ;
        this.ijJ = yF(this.ijH);
        this.ijR = 1 << (i - 1);
        this.ijS = this.ijR + 1;
        this.ijO = this.ijR + 2;
        this.ijW = 0;
        int cbF = cbF();
        for (int i3 = this.ijN; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ijN;
        yE(i5);
        b(this.ijR, outputStream);
        while (true) {
            int cbF2 = cbF();
            if (cbF2 != -1) {
                int i6 = (cbF2 << this.ijI) + cbF;
                int i7 = (cbF2 << i4) ^ cbF;
                if (this.ijL[i7] == i6) {
                    cbF = this.ijM[i7];
                } else {
                    if (this.ijL[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ijL[i7] == i6) {
                                cbF = this.ijM[i7];
                                break;
                            }
                        } while (this.ijL[i7] >= 0);
                    }
                    b(cbF, outputStream);
                    if (this.ijO < this.ijK) {
                        int[] iArr = this.ijM;
                        int i9 = this.ijO;
                        this.ijO = i9 + 1;
                        iArr[i7] = i9;
                        this.ijL[i7] = i6;
                        cbF = cbF2;
                    } else {
                        f(outputStream);
                        cbF = cbF2;
                    }
                }
            } else {
                b(cbF, outputStream);
                b(this.ijS, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(OutputStream outputStream) throws IOException {
        outputStream.write(this.ijE);
        this.ijF = this.ijB * this.ijC;
        this.ijG = 0;
        a(this.ijE + 1, outputStream);
        outputStream.write(0);
    }

    void h(OutputStream outputStream) throws IOException {
        if (this.ijW > 0) {
            outputStream.write(this.ijW);
            outputStream.write(this.ijX, 0, this.ijW);
            this.ijW = 0;
        }
    }

    final int yF(int i) {
        return (1 << i) - 1;
    }

    private int cbF() {
        if (this.ijF == 0) {
            return -1;
        }
        this.ijF--;
        byte[] bArr = this.ijD;
        int i = this.ijG;
        this.ijG = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ijT &= this.ijV[this.ijU];
        if (this.ijU > 0) {
            this.ijT |= i << this.ijU;
        } else {
            this.ijT = i;
        }
        this.ijU += this.ijH;
        while (this.ijU >= 8) {
            a((byte) (this.ijT & 255), outputStream);
            this.ijT >>= 8;
            this.ijU -= 8;
        }
        if (this.ijO > this.ijJ || this.ijP) {
            if (this.ijP) {
                int i2 = this.ijQ;
                this.ijH = i2;
                this.ijJ = yF(i2);
                this.ijP = false;
            } else {
                this.ijH++;
                if (this.ijH == this.ijI) {
                    this.ijJ = this.ijK;
                } else {
                    this.ijJ = yF(this.ijH);
                }
            }
        }
        if (i == this.ijS) {
            while (this.ijU > 0) {
                a((byte) (this.ijT & 255), outputStream);
                this.ijT >>= 8;
                this.ijU -= 8;
            }
            h(outputStream);
        }
    }
}
