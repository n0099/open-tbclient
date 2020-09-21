package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes21.dex */
class b {
    private int lkA;
    int lkB;
    int lkD;
    int lkK;
    int lkL;
    int lkM;
    int lkQ;
    private int lkv;
    private int lkw;
    private byte[] lkx;
    private int lky;
    private int lkz;
    int lkC = 12;
    int lkE = 4096;
    int[] lkF = new int[5003];
    int[] lkG = new int[5003];
    int lkH = 5003;
    int lkI = 0;
    boolean lkJ = false;
    int lkN = 0;
    int lkO = 0;
    int[] lkP = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] lkR = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.lkv = i;
        this.lkw = i2;
        this.lkx = bArr;
        this.lky = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.lkR;
        int i = this.lkQ;
        this.lkQ = i + 1;
        bArr[i] = b;
        if (this.lkQ >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Fz(this.lkH);
        this.lkI = this.lkL + 2;
        this.lkJ = true;
        b(this.lkL, outputStream);
    }

    void Fz(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.lkF[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.lkK = i;
        this.lkJ = false;
        this.lkB = this.lkK;
        this.lkD = FA(this.lkB);
        this.lkL = 1 << (i - 1);
        this.lkM = this.lkL + 1;
        this.lkI = this.lkL + 2;
        this.lkQ = 0;
        int djz = djz();
        for (int i3 = this.lkH; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.lkH;
        Fz(i5);
        b(this.lkL, outputStream);
        while (true) {
            int djz2 = djz();
            if (djz2 != -1) {
                int i6 = (djz2 << this.lkC) + djz;
                int i7 = (djz2 << i4) ^ djz;
                if (this.lkF[i7] == i6) {
                    djz = this.lkG[i7];
                } else {
                    if (this.lkF[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.lkF[i7] == i6) {
                                djz = this.lkG[i7];
                                break;
                            }
                        } while (this.lkF[i7] >= 0);
                    }
                    b(djz, outputStream);
                    if (this.lkI < this.lkE) {
                        int[] iArr = this.lkG;
                        int i9 = this.lkI;
                        this.lkI = i9 + 1;
                        iArr[i7] = i9;
                        this.lkF[i7] = i6;
                        djz = djz2;
                    } else {
                        c(outputStream);
                        djz = djz2;
                    }
                }
            } else {
                b(djz, outputStream);
                b(this.lkM, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.lky);
        this.lkz = this.lkv * this.lkw;
        this.lkA = 0;
        a(this.lky + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.lkQ > 0) {
            outputStream.write(this.lkQ);
            outputStream.write(this.lkR, 0, this.lkQ);
            this.lkQ = 0;
        }
    }

    final int FA(int i) {
        return (1 << i) - 1;
    }

    private int djz() {
        if (this.lkz == 0) {
            return -1;
        }
        this.lkz--;
        byte[] bArr = this.lkx;
        int i = this.lkA;
        this.lkA = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.lkN &= this.lkP[this.lkO];
        if (this.lkO > 0) {
            this.lkN |= i << this.lkO;
        } else {
            this.lkN = i;
        }
        this.lkO += this.lkB;
        while (this.lkO >= 8) {
            a((byte) (this.lkN & 255), outputStream);
            this.lkN >>= 8;
            this.lkO -= 8;
        }
        if (this.lkI > this.lkD || this.lkJ) {
            if (this.lkJ) {
                int i2 = this.lkK;
                this.lkB = i2;
                this.lkD = FA(i2);
                this.lkJ = false;
            } else {
                this.lkB++;
                if (this.lkB == this.lkC) {
                    this.lkD = this.lkE;
                } else {
                    this.lkD = FA(this.lkB);
                }
            }
        }
        if (i == this.lkM) {
            while (this.lkO > 0) {
                a((byte) (this.lkN & 255), outputStream);
                this.lkN >>= 8;
                this.lkO -= 8;
            }
            d(outputStream);
        }
    }
}
