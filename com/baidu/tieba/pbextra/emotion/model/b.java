package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes6.dex */
class b {
    int iZF;
    int iZG;
    int iZH;
    int iZL;
    private int iZq;
    private int iZr;
    private byte[] iZs;
    private int iZt;
    private int iZu;
    private int iZv;
    int iZw;
    int iZy;
    int iZx = 12;
    int iZz = 4096;
    int[] iZA = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] iZB = new int[StatusCode.ERROR_NOT_LOGIN];
    int iZC = StatusCode.ERROR_NOT_LOGIN;
    int iZD = 0;
    boolean iZE = false;
    int iZI = 0;
    int iZJ = 0;
    int[] iZK = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] iZM = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.iZq = i;
        this.iZr = i2;
        this.iZs = bArr;
        this.iZt = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.iZM;
        int i = this.iZL;
        this.iZL = i + 1;
        bArr[i] = b;
        if (this.iZL >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zu(this.iZC);
        this.iZD = this.iZG + 2;
        this.iZE = true;
        b(this.iZG, outputStream);
    }

    void zu(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.iZA[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.iZF = i;
        this.iZE = false;
        this.iZw = this.iZF;
        this.iZy = zv(this.iZw);
        this.iZG = 1 << (i - 1);
        this.iZH = this.iZG + 1;
        this.iZD = this.iZG + 2;
        this.iZL = 0;
        int crY = crY();
        for (int i3 = this.iZC; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.iZC;
        zu(i5);
        b(this.iZG, outputStream);
        while (true) {
            int crY2 = crY();
            if (crY2 != -1) {
                int i6 = (crY2 << this.iZx) + crY;
                int i7 = (crY2 << i4) ^ crY;
                if (this.iZA[i7] == i6) {
                    crY = this.iZB[i7];
                } else {
                    if (this.iZA[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.iZA[i7] == i6) {
                                crY = this.iZB[i7];
                                break;
                            }
                        } while (this.iZA[i7] >= 0);
                    }
                    b(crY, outputStream);
                    if (this.iZD < this.iZz) {
                        int[] iArr = this.iZB;
                        int i9 = this.iZD;
                        this.iZD = i9 + 1;
                        iArr[i7] = i9;
                        this.iZA[i7] = i6;
                        crY = crY2;
                    } else {
                        c(outputStream);
                        crY = crY2;
                    }
                }
            } else {
                b(crY, outputStream);
                b(this.iZH, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.iZt);
        this.iZu = this.iZq * this.iZr;
        this.iZv = 0;
        a(this.iZt + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.iZL > 0) {
            outputStream.write(this.iZL);
            outputStream.write(this.iZM, 0, this.iZL);
            this.iZL = 0;
        }
    }

    final int zv(int i) {
        return (1 << i) - 1;
    }

    private int crY() {
        if (this.iZu == 0) {
            return -1;
        }
        this.iZu--;
        byte[] bArr = this.iZs;
        int i = this.iZv;
        this.iZv = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.iZI &= this.iZK[this.iZJ];
        if (this.iZJ > 0) {
            this.iZI |= i << this.iZJ;
        } else {
            this.iZI = i;
        }
        this.iZJ += this.iZw;
        while (this.iZJ >= 8) {
            a((byte) (this.iZI & 255), outputStream);
            this.iZI >>= 8;
            this.iZJ -= 8;
        }
        if (this.iZD > this.iZy || this.iZE) {
            if (this.iZE) {
                int i2 = this.iZF;
                this.iZw = i2;
                this.iZy = zv(i2);
                this.iZE = false;
            } else {
                this.iZw++;
                if (this.iZw == this.iZx) {
                    this.iZy = this.iZz;
                } else {
                    this.iZy = zv(this.iZw);
                }
            }
        }
        if (i == this.iZH) {
            while (this.iZJ > 0) {
                a((byte) (this.iZI & 255), outputStream);
                this.iZI >>= 8;
                this.iZJ -= 8;
            }
            d(outputStream);
        }
    }
}
