package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    int hIA;
    int hIH;
    int hII;
    int hIJ;
    int hIN;
    private int hIs;
    private int hIt;
    private byte[] hIu;
    private int hIv;
    private int hIw;
    private int hIx;
    int hIy;
    int hIz = 12;
    int hIB = 4096;
    int[] hIC = new int[5003];
    int[] hID = new int[5003];
    int hIE = 5003;
    int hIF = 0;
    boolean hIG = false;
    int hIK = 0;
    int hIL = 0;
    int[] hIM = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] hIO = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.hIs = i;
        this.hIt = i2;
        this.hIu = bArr;
        this.hIv = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.hIO;
        int i = this.hIN;
        this.hIN = i + 1;
        bArr[i] = b;
        if (this.hIN >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        wS(this.hIE);
        this.hIF = this.hII + 2;
        this.hIG = true;
        b(this.hII, outputStream);
    }

    void wS(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.hIC[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.hIH = i;
        this.hIG = false;
        this.hIy = this.hIH;
        this.hIA = wT(this.hIy);
        this.hII = 1 << (i - 1);
        this.hIJ = this.hII + 1;
        this.hIF = this.hII + 2;
        this.hIN = 0;
        int bPQ = bPQ();
        for (int i3 = this.hIE; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.hIE;
        wS(i5);
        b(this.hII, outputStream);
        while (true) {
            int bPQ2 = bPQ();
            if (bPQ2 != -1) {
                int i6 = (bPQ2 << this.hIz) + bPQ;
                int i7 = (bPQ2 << i4) ^ bPQ;
                if (this.hIC[i7] == i6) {
                    bPQ = this.hID[i7];
                } else {
                    if (this.hIC[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.hIC[i7] == i6) {
                                bPQ = this.hID[i7];
                                break;
                            }
                        } while (this.hIC[i7] >= 0);
                    }
                    b(bPQ, outputStream);
                    if (this.hIF < this.hIB) {
                        int[] iArr = this.hID;
                        int i9 = this.hIF;
                        this.hIF = i9 + 1;
                        iArr[i7] = i9;
                        this.hIC[i7] = i6;
                        bPQ = bPQ2;
                    } else {
                        e(outputStream);
                        bPQ = bPQ2;
                    }
                }
            } else {
                b(bPQ, outputStream);
                b(this.hIJ, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.hIv);
        this.hIw = this.hIs * this.hIt;
        this.hIx = 0;
        a(this.hIv + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.hIN > 0) {
            outputStream.write(this.hIN);
            outputStream.write(this.hIO, 0, this.hIN);
            this.hIN = 0;
        }
    }

    final int wT(int i) {
        return (1 << i) - 1;
    }

    private int bPQ() {
        if (this.hIw == 0) {
            return -1;
        }
        this.hIw--;
        byte[] bArr = this.hIu;
        int i = this.hIx;
        this.hIx = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.hIK &= this.hIM[this.hIL];
        if (this.hIL > 0) {
            this.hIK |= i << this.hIL;
        } else {
            this.hIK = i;
        }
        this.hIL += this.hIy;
        while (this.hIL >= 8) {
            a((byte) (this.hIK & 255), outputStream);
            this.hIK >>= 8;
            this.hIL -= 8;
        }
        if (this.hIF > this.hIA || this.hIG) {
            if (this.hIG) {
                int i2 = this.hIH;
                this.hIy = i2;
                this.hIA = wT(i2);
                this.hIG = false;
            } else {
                this.hIy++;
                if (this.hIy == this.hIz) {
                    this.hIA = this.hIB;
                } else {
                    this.hIA = wT(this.hIy);
                }
            }
        }
        if (i == this.hIJ) {
            while (this.hIL > 0) {
                a((byte) (this.hIK & 255), outputStream);
                this.hIK >>= 8;
                this.hIL -= 8;
            }
            f(outputStream);
        }
    }
}
