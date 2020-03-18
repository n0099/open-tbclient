package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int jfH;
    private int jfI;
    private byte[] jfJ;
    private int jfK;
    private int jfL;
    private int jfM;
    int jfN;
    int jfP;
    int jfW;
    int jfX;
    int jfY;
    int jgc;
    int jfO = 12;
    int jfQ = 4096;
    int[] jfR = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] jfS = new int[StatusCode.ERROR_NOT_LOGIN];
    int jfT = StatusCode.ERROR_NOT_LOGIN;
    int jfU = 0;
    boolean jfV = false;
    int jfZ = 0;
    int jga = 0;
    int[] jgb = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jgd = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jfH = i;
        this.jfI = i2;
        this.jfJ = bArr;
        this.jfK = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jgd;
        int i = this.jgc;
        this.jgc = i + 1;
        bArr[i] = b;
        if (this.jgc >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zO(this.jfT);
        this.jfU = this.jfX + 2;
        this.jfV = true;
        b(this.jfX, outputStream);
    }

    void zO(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jfR[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jfW = i;
        this.jfV = false;
        this.jfN = this.jfW;
        this.jfP = zP(this.jfN);
        this.jfX = 1 << (i - 1);
        this.jfY = this.jfX + 1;
        this.jfU = this.jfX + 2;
        this.jgc = 0;
        int cuW = cuW();
        for (int i3 = this.jfT; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jfT;
        zO(i5);
        b(this.jfX, outputStream);
        while (true) {
            int cuW2 = cuW();
            if (cuW2 != -1) {
                int i6 = (cuW2 << this.jfO) + cuW;
                int i7 = (cuW2 << i4) ^ cuW;
                if (this.jfR[i7] == i6) {
                    cuW = this.jfS[i7];
                } else {
                    if (this.jfR[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jfR[i7] == i6) {
                                cuW = this.jfS[i7];
                                break;
                            }
                        } while (this.jfR[i7] >= 0);
                    }
                    b(cuW, outputStream);
                    if (this.jfU < this.jfQ) {
                        int[] iArr = this.jfS;
                        int i9 = this.jfU;
                        this.jfU = i9 + 1;
                        iArr[i7] = i9;
                        this.jfR[i7] = i6;
                        cuW = cuW2;
                    } else {
                        c(outputStream);
                        cuW = cuW2;
                    }
                }
            } else {
                b(cuW, outputStream);
                b(this.jfY, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jfK);
        this.jfL = this.jfH * this.jfI;
        this.jfM = 0;
        a(this.jfK + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jgc > 0) {
            outputStream.write(this.jgc);
            outputStream.write(this.jgd, 0, this.jgc);
            this.jgc = 0;
        }
    }

    final int zP(int i) {
        return (1 << i) - 1;
    }

    private int cuW() {
        if (this.jfL == 0) {
            return -1;
        }
        this.jfL--;
        byte[] bArr = this.jfJ;
        int i = this.jfM;
        this.jfM = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jfZ &= this.jgb[this.jga];
        if (this.jga > 0) {
            this.jfZ |= i << this.jga;
        } else {
            this.jfZ = i;
        }
        this.jga += this.jfN;
        while (this.jga >= 8) {
            a((byte) (this.jfZ & 255), outputStream);
            this.jfZ >>= 8;
            this.jga -= 8;
        }
        if (this.jfU > this.jfP || this.jfV) {
            if (this.jfV) {
                int i2 = this.jfW;
                this.jfN = i2;
                this.jfP = zP(i2);
                this.jfV = false;
            } else {
                this.jfN++;
                if (this.jfN == this.jfO) {
                    this.jfP = this.jfQ;
                } else {
                    this.jfP = zP(this.jfN);
                }
            }
        }
        if (i == this.jfY) {
            while (this.jga > 0) {
                a((byte) (this.jfZ & 255), outputStream);
                this.jfZ >>= 8;
                this.jga -= 8;
            }
            d(outputStream);
        }
    }
}
