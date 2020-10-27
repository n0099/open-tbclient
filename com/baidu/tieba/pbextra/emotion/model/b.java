package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
class b {
    int lMA;
    int lMB;
    int lMF;
    private int lMk;
    private int lMl;
    private byte[] lMm;
    private int lMn;
    private int lMo;
    private int lMp;
    int lMq;
    int lMs;
    int lMz;
    int lMr = 12;
    int lMt = 4096;
    int[] lMu = new int[5003];
    int[] lMv = new int[5003];
    int lMw = 5003;
    int lMx = 0;
    boolean lMy = false;
    int lMC = 0;
    int lMD = 0;
    int[] lME = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lMG = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lMk = i;
        this.lMl = i2;
        this.lMm = bArr;
        this.lMn = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lMG;
        int i = this.lMF;
        this.lMF = i + 1;
        bArr[i] = b;
        if (this.lMF >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Gy(this.lMw);
        this.lMx = this.lMA + 2;
        this.lMy = true;
        b(this.lMA, outputStream);
    }

    void Gy(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lMu[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lMz = i;
        this.lMy = false;
        this.lMq = this.lMz;
        this.lMs = Gz(this.lMq);
        this.lMA = 1 << (i - 1);
        this.lMB = this.lMA + 1;
        this.lMx = this.lMA + 2;
        this.lMF = 0;
        int dqq = dqq();
        for (int i3 = this.lMw; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lMw;
        Gy(i5);
        b(this.lMA, outputStream);
        while (true) {
            int dqq2 = dqq();
            if (dqq2 != -1) {
                int i6 = (dqq2 << this.lMr) + dqq;
                int i7 = (dqq2 << i4) ^ dqq;
                if (this.lMu[i7] == i6) {
                    dqq = this.lMv[i7];
                } else {
                    if (this.lMu[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lMu[i7] == i6) {
                                dqq = this.lMv[i7];
                                break;
                            }
                        } while (this.lMu[i7] >= 0);
                    }
                    b(dqq, outputStream);
                    if (this.lMx < this.lMt) {
                        int[] iArr = this.lMv;
                        int i9 = this.lMx;
                        this.lMx = i9 + 1;
                        iArr[i7] = i9;
                        this.lMu[i7] = i6;
                        dqq = dqq2;
                    } else {
                        c(outputStream);
                        dqq = dqq2;
                    }
                }
            } else {
                b(dqq, outputStream);
                b(this.lMB, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lMn);
        this.lMo = this.lMk * this.lMl;
        this.lMp = 0;
        a(this.lMn + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lMF > 0) {
            outputStream.write(this.lMF);
            outputStream.write(this.lMG, 0, this.lMF);
            this.lMF = 0;
        }
    }

    final int Gz(int i) {
        return (1 << i) - 1;
    }

    private int dqq() {
        if (this.lMo == 0) {
            return -1;
        }
        this.lMo--;
        byte[] bArr = this.lMm;
        int i = this.lMp;
        this.lMp = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lMC &= this.lME[this.lMD];
        if (this.lMD > 0) {
            this.lMC |= i << this.lMD;
        } else {
            this.lMC = i;
        }
        this.lMD += this.lMq;
        while (this.lMD >= 8) {
            a((byte) (this.lMC & 255), outputStream);
            this.lMC >>= 8;
            this.lMD -= 8;
        }
        if (this.lMx > this.lMs || this.lMy) {
            if (this.lMy) {
                int i2 = this.lMz;
                this.lMq = i2;
                this.lMs = Gz(i2);
                this.lMy = false;
            } else {
                this.lMq++;
                if (this.lMq == this.lMr) {
                    this.lMs = this.lMt;
                } else {
                    this.lMs = Gz(this.lMq);
                }
            }
        }
        if (i == this.lMB) {
            while (this.lMD > 0) {
                a((byte) (this.lMC & 255), outputStream);
                this.lMC >>= 8;
                this.lMD -= 8;
            }
            d(outputStream);
        }
    }
}
