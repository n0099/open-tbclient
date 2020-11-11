package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes22.dex */
class b {
    int lSB;
    private int lSg;
    private int lSh;
    private byte[] lSi;
    private int lSj;
    private int lSk;
    private int lSl;
    int lSm;
    int lSo;
    int lSv;
    int lSw;
    int lSx;
    int lSn = 12;
    int lSp = 4096;
    int[] lSq = new int[5003];
    int[] lSr = new int[5003];
    int lSs = 5003;
    int lSt = 0;
    boolean lSu = false;
    int lSy = 0;
    int lSz = 0;
    int[] lSA = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lSC = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lSg = i;
        this.lSh = i2;
        this.lSi = bArr;
        this.lSj = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lSC;
        int i = this.lSB;
        this.lSB = i + 1;
        bArr[i] = b;
        if (this.lSB >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        GL(this.lSs);
        this.lSt = this.lSw + 2;
        this.lSu = true;
        b(this.lSw, outputStream);
    }

    void GL(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lSq[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lSv = i;
        this.lSu = false;
        this.lSm = this.lSv;
        this.lSo = GM(this.lSm);
        this.lSw = 1 << (i - 1);
        this.lSx = this.lSw + 1;
        this.lSt = this.lSw + 2;
        this.lSB = 0;
        int dsS = dsS();
        for (int i3 = this.lSs; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lSs;
        GL(i5);
        b(this.lSw, outputStream);
        while (true) {
            int dsS2 = dsS();
            if (dsS2 != -1) {
                int i6 = (dsS2 << this.lSn) + dsS;
                int i7 = (dsS2 << i4) ^ dsS;
                if (this.lSq[i7] == i6) {
                    dsS = this.lSr[i7];
                } else {
                    if (this.lSq[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lSq[i7] == i6) {
                                dsS = this.lSr[i7];
                                break;
                            }
                        } while (this.lSq[i7] >= 0);
                    }
                    b(dsS, outputStream);
                    if (this.lSt < this.lSp) {
                        int[] iArr = this.lSr;
                        int i9 = this.lSt;
                        this.lSt = i9 + 1;
                        iArr[i7] = i9;
                        this.lSq[i7] = i6;
                        dsS = dsS2;
                    } else {
                        c(outputStream);
                        dsS = dsS2;
                    }
                }
            } else {
                b(dsS, outputStream);
                b(this.lSx, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lSj);
        this.lSk = this.lSg * this.lSh;
        this.lSl = 0;
        a(this.lSj + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lSB > 0) {
            outputStream.write(this.lSB);
            outputStream.write(this.lSC, 0, this.lSB);
            this.lSB = 0;
        }
    }

    final int GM(int i) {
        return (1 << i) - 1;
    }

    private int dsS() {
        if (this.lSk == 0) {
            return -1;
        }
        this.lSk--;
        byte[] bArr = this.lSi;
        int i = this.lSl;
        this.lSl = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lSy &= this.lSA[this.lSz];
        if (this.lSz > 0) {
            this.lSy |= i << this.lSz;
        } else {
            this.lSy = i;
        }
        this.lSz += this.lSm;
        while (this.lSz >= 8) {
            a((byte) (this.lSy & 255), outputStream);
            this.lSy >>= 8;
            this.lSz -= 8;
        }
        if (this.lSt > this.lSo || this.lSu) {
            if (this.lSu) {
                int i2 = this.lSv;
                this.lSm = i2;
                this.lSo = GM(i2);
                this.lSu = false;
            } else {
                this.lSm++;
                if (this.lSm == this.lSn) {
                    this.lSo = this.lSp;
                } else {
                    this.lSo = GM(this.lSm);
                }
            }
        }
        if (i == this.lSx) {
            while (this.lSz > 0) {
                a((byte) (this.lSy & 255), outputStream);
                this.lSy >>= 8;
                this.lSz -= 8;
            }
            d(outputStream);
        }
    }
}
