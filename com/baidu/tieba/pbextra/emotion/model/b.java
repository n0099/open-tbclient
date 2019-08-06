package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    private int ihC;
    private int ihD;
    private byte[] ihE;
    private int ihF;
    private int ihG;
    private int ihH;
    int ihI;
    int ihK;
    int ihR;
    int ihS;
    int ihT;
    int ihX;
    int ihJ = 12;
    int ihL = 4096;
    int[] ihM = new int[5003];
    int[] ihN = new int[5003];
    int ihO = 5003;
    int ihP = 0;
    boolean ihQ = false;
    int ihU = 0;
    int ihV = 0;
    int[] ihW = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ihY = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.ihC = i;
        this.ihD = i2;
        this.ihE = bArr;
        this.ihF = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ihY;
        int i = this.ihX;
        this.ihX = i + 1;
        bArr[i] = b;
        if (this.ihX >= 254) {
            h(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        yB(this.ihO);
        this.ihP = this.ihS + 2;
        this.ihQ = true;
        b(this.ihS, outputStream);
    }

    void yB(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ihM[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ihR = i;
        this.ihQ = false;
        this.ihI = this.ihR;
        this.ihK = yC(this.ihI);
        this.ihS = 1 << (i - 1);
        this.ihT = this.ihS + 1;
        this.ihP = this.ihS + 2;
        this.ihX = 0;
        int caR = caR();
        for (int i3 = this.ihO; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ihO;
        yB(i5);
        b(this.ihS, outputStream);
        while (true) {
            int caR2 = caR();
            if (caR2 != -1) {
                int i6 = (caR2 << this.ihJ) + caR;
                int i7 = (caR2 << i4) ^ caR;
                if (this.ihM[i7] == i6) {
                    caR = this.ihN[i7];
                } else {
                    if (this.ihM[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ihM[i7] == i6) {
                                caR = this.ihN[i7];
                                break;
                            }
                        } while (this.ihM[i7] >= 0);
                    }
                    b(caR, outputStream);
                    if (this.ihP < this.ihL) {
                        int[] iArr = this.ihN;
                        int i9 = this.ihP;
                        this.ihP = i9 + 1;
                        iArr[i7] = i9;
                        this.ihM[i7] = i6;
                        caR = caR2;
                    } else {
                        f(outputStream);
                        caR = caR2;
                    }
                }
            } else {
                b(caR, outputStream);
                b(this.ihT, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(OutputStream outputStream) throws IOException {
        outputStream.write(this.ihF);
        this.ihG = this.ihC * this.ihD;
        this.ihH = 0;
        a(this.ihF + 1, outputStream);
        outputStream.write(0);
    }

    void h(OutputStream outputStream) throws IOException {
        if (this.ihX > 0) {
            outputStream.write(this.ihX);
            outputStream.write(this.ihY, 0, this.ihX);
            this.ihX = 0;
        }
    }

    final int yC(int i) {
        return (1 << i) - 1;
    }

    private int caR() {
        if (this.ihG == 0) {
            return -1;
        }
        this.ihG--;
        byte[] bArr = this.ihE;
        int i = this.ihH;
        this.ihH = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ihU &= this.ihW[this.ihV];
        if (this.ihV > 0) {
            this.ihU |= i << this.ihV;
        } else {
            this.ihU = i;
        }
        this.ihV += this.ihI;
        while (this.ihV >= 8) {
            a((byte) (this.ihU & 255), outputStream);
            this.ihU >>= 8;
            this.ihV -= 8;
        }
        if (this.ihP > this.ihK || this.ihQ) {
            if (this.ihQ) {
                int i2 = this.ihR;
                this.ihI = i2;
                this.ihK = yC(i2);
                this.ihQ = false;
            } else {
                this.ihI++;
                if (this.ihI == this.ihJ) {
                    this.ihK = this.ihL;
                } else {
                    this.ihK = yC(this.ihI);
                }
            }
        }
        if (i == this.ihT) {
            while (this.ihV > 0) {
                a((byte) (this.ihU & 255), outputStream);
                this.ihU >>= 8;
                this.ihV -= 8;
            }
            h(outputStream);
        }
    }
}
