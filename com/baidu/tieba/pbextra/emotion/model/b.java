package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    int hIA;
    private int hIf;
    private int hIg;
    private byte[] hIh;
    private int hIi;
    private int hIj;
    private int hIk;
    int hIl;
    int hIn;
    int hIu;
    int hIv;
    int hIw;
    int hIm = 12;
    int hIo = 4096;
    int[] hIp = new int[5003];
    int[] hIq = new int[5003];
    int hIr = 5003;
    int hIs = 0;
    boolean hIt = false;
    int hIx = 0;
    int hIy = 0;
    int[] hIz = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] hIB = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.hIf = i;
        this.hIg = i2;
        this.hIh = bArr;
        this.hIi = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.hIB;
        int i = this.hIA;
        this.hIA = i + 1;
        bArr[i] = b;
        if (this.hIA >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        wO(this.hIr);
        this.hIs = this.hIv + 2;
        this.hIt = true;
        b(this.hIv, outputStream);
    }

    void wO(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.hIp[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.hIu = i;
        this.hIt = false;
        this.hIl = this.hIu;
        this.hIn = wP(this.hIl);
        this.hIv = 1 << (i - 1);
        this.hIw = this.hIv + 1;
        this.hIs = this.hIv + 2;
        this.hIA = 0;
        int bPN = bPN();
        for (int i3 = this.hIr; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.hIr;
        wO(i5);
        b(this.hIv, outputStream);
        while (true) {
            int bPN2 = bPN();
            if (bPN2 != -1) {
                int i6 = (bPN2 << this.hIm) + bPN;
                int i7 = (bPN2 << i4) ^ bPN;
                if (this.hIp[i7] == i6) {
                    bPN = this.hIq[i7];
                } else {
                    if (this.hIp[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.hIp[i7] == i6) {
                                bPN = this.hIq[i7];
                                break;
                            }
                        } while (this.hIp[i7] >= 0);
                    }
                    b(bPN, outputStream);
                    if (this.hIs < this.hIo) {
                        int[] iArr = this.hIq;
                        int i9 = this.hIs;
                        this.hIs = i9 + 1;
                        iArr[i7] = i9;
                        this.hIp[i7] = i6;
                        bPN = bPN2;
                    } else {
                        e(outputStream);
                        bPN = bPN2;
                    }
                }
            } else {
                b(bPN, outputStream);
                b(this.hIw, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.hIi);
        this.hIj = this.hIf * this.hIg;
        this.hIk = 0;
        a(this.hIi + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.hIA > 0) {
            outputStream.write(this.hIA);
            outputStream.write(this.hIB, 0, this.hIA);
            this.hIA = 0;
        }
    }

    final int wP(int i) {
        return (1 << i) - 1;
    }

    private int bPN() {
        if (this.hIj == 0) {
            return -1;
        }
        this.hIj--;
        byte[] bArr = this.hIh;
        int i = this.hIk;
        this.hIk = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.hIx &= this.hIz[this.hIy];
        if (this.hIy > 0) {
            this.hIx |= i << this.hIy;
        } else {
            this.hIx = i;
        }
        this.hIy += this.hIl;
        while (this.hIy >= 8) {
            a((byte) (this.hIx & 255), outputStream);
            this.hIx >>= 8;
            this.hIy -= 8;
        }
        if (this.hIs > this.hIn || this.hIt) {
            if (this.hIt) {
                int i2 = this.hIu;
                this.hIl = i2;
                this.hIn = wP(i2);
                this.hIt = false;
            } else {
                this.hIl++;
                if (this.hIl == this.hIm) {
                    this.hIn = this.hIo;
                } else {
                    this.hIn = wP(this.hIl);
                }
            }
        }
        if (i == this.hIw) {
            while (this.hIy > 0) {
                a((byte) (this.hIx & 255), outputStream);
                this.hIx >>= 8;
                this.hIy -= 8;
            }
            f(outputStream);
        }
    }
}
