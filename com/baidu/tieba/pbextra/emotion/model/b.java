package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    private int hIe;
    private int hIf;
    private byte[] hIg;
    private int hIh;
    private int hIi;
    private int hIj;
    int hIk;
    int hIm;
    int hIt;
    int hIu;
    int hIv;
    int hIz;
    int hIl = 12;
    int hIn = 4096;
    int[] hIo = new int[5003];
    int[] hIp = new int[5003];
    int hIq = 5003;
    int hIr = 0;
    boolean hIs = false;
    int hIw = 0;
    int hIx = 0;
    int[] hIy = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] hIA = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.hIe = i;
        this.hIf = i2;
        this.hIg = bArr;
        this.hIh = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.hIA;
        int i = this.hIz;
        this.hIz = i + 1;
        bArr[i] = b;
        if (this.hIz >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        wO(this.hIq);
        this.hIr = this.hIu + 2;
        this.hIs = true;
        b(this.hIu, outputStream);
    }

    void wO(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.hIo[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.hIt = i;
        this.hIs = false;
        this.hIk = this.hIt;
        this.hIm = wP(this.hIk);
        this.hIu = 1 << (i - 1);
        this.hIv = this.hIu + 1;
        this.hIr = this.hIu + 2;
        this.hIz = 0;
        int bPN = bPN();
        for (int i3 = this.hIq; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.hIq;
        wO(i5);
        b(this.hIu, outputStream);
        while (true) {
            int bPN2 = bPN();
            if (bPN2 != -1) {
                int i6 = (bPN2 << this.hIl) + bPN;
                int i7 = (bPN2 << i4) ^ bPN;
                if (this.hIo[i7] == i6) {
                    bPN = this.hIp[i7];
                } else {
                    if (this.hIo[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.hIo[i7] == i6) {
                                bPN = this.hIp[i7];
                                break;
                            }
                        } while (this.hIo[i7] >= 0);
                    }
                    b(bPN, outputStream);
                    if (this.hIr < this.hIn) {
                        int[] iArr = this.hIp;
                        int i9 = this.hIr;
                        this.hIr = i9 + 1;
                        iArr[i7] = i9;
                        this.hIo[i7] = i6;
                        bPN = bPN2;
                    } else {
                        e(outputStream);
                        bPN = bPN2;
                    }
                }
            } else {
                b(bPN, outputStream);
                b(this.hIv, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.hIh);
        this.hIi = this.hIe * this.hIf;
        this.hIj = 0;
        a(this.hIh + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.hIz > 0) {
            outputStream.write(this.hIz);
            outputStream.write(this.hIA, 0, this.hIz);
            this.hIz = 0;
        }
    }

    final int wP(int i) {
        return (1 << i) - 1;
    }

    private int bPN() {
        if (this.hIi == 0) {
            return -1;
        }
        this.hIi--;
        byte[] bArr = this.hIg;
        int i = this.hIj;
        this.hIj = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.hIw &= this.hIy[this.hIx];
        if (this.hIx > 0) {
            this.hIw |= i << this.hIx;
        } else {
            this.hIw = i;
        }
        this.hIx += this.hIk;
        while (this.hIx >= 8) {
            a((byte) (this.hIw & 255), outputStream);
            this.hIw >>= 8;
            this.hIx -= 8;
        }
        if (this.hIr > this.hIm || this.hIs) {
            if (this.hIs) {
                int i2 = this.hIt;
                this.hIk = i2;
                this.hIm = wP(i2);
                this.hIs = false;
            } else {
                this.hIk++;
                if (this.hIk == this.hIl) {
                    this.hIm = this.hIn;
                } else {
                    this.hIm = wP(this.hIk);
                }
            }
        }
        if (i == this.hIv) {
            while (this.hIx > 0) {
                a((byte) (this.hIw & 255), outputStream);
                this.hIw >>= 8;
                this.hIx -= 8;
            }
            f(outputStream);
        }
    }
}
