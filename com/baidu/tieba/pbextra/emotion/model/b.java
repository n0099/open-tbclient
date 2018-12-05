package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    int goB;
    int goC;
    int goD;
    int goH;
    private int gom;
    private int gon;
    private byte[] goo;
    private int gop;
    private int goq;
    private int gor;
    int gos;
    int gou;
    int got = 12;
    int gov = 4096;
    int[] gow = new int[5003];
    int[] gox = new int[5003];
    int goy = 5003;
    int goz = 0;
    boolean goA = false;
    int goE = 0;
    int goF = 0;
    int[] goG = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] goI = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.gom = i;
        this.gon = i2;
        this.goo = bArr;
        this.gop = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.goI;
        int i = this.goH;
        this.goH = i + 1;
        bArr[i] = b;
        if (this.goH >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        sR(this.goy);
        this.goz = this.goC + 2;
        this.goA = true;
        b(this.goC, outputStream);
    }

    void sR(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.gow[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.goB = i;
        this.goA = false;
        this.gos = this.goB;
        this.gou = sS(this.gos);
        this.goC = 1 << (i - 1);
        this.goD = this.goC + 1;
        this.goz = this.goC + 2;
        this.goH = 0;
        int bnY = bnY();
        for (int i3 = this.goy; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.goy;
        sR(i5);
        b(this.goC, outputStream);
        while (true) {
            int bnY2 = bnY();
            if (bnY2 != -1) {
                int i6 = (bnY2 << this.got) + bnY;
                int i7 = (bnY2 << i4) ^ bnY;
                if (this.gow[i7] == i6) {
                    bnY = this.gox[i7];
                } else {
                    if (this.gow[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.gow[i7] == i6) {
                                bnY = this.gox[i7];
                                break;
                            }
                        } while (this.gow[i7] >= 0);
                    }
                    b(bnY, outputStream);
                    if (this.goz < this.gov) {
                        int[] iArr = this.gox;
                        int i9 = this.goz;
                        this.goz = i9 + 1;
                        iArr[i7] = i9;
                        this.gow[i7] = i6;
                        bnY = bnY2;
                    } else {
                        f(outputStream);
                        bnY = bnY2;
                    }
                }
            } else {
                b(bnY, outputStream);
                b(this.goD, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.gop);
        this.goq = this.gom * this.gon;
        this.gor = 0;
        a(this.gop + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.goH > 0) {
            outputStream.write(this.goH);
            outputStream.write(this.goI, 0, this.goH);
            this.goH = 0;
        }
    }

    final int sS(int i) {
        return (1 << i) - 1;
    }

    private int bnY() {
        if (this.goq == 0) {
            return -1;
        }
        this.goq--;
        byte[] bArr = this.goo;
        int i = this.gor;
        this.gor = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.goE &= this.goG[this.goF];
        if (this.goF > 0) {
            this.goE |= i << this.goF;
        } else {
            this.goE = i;
        }
        this.goF += this.gos;
        while (this.goF >= 8) {
            a((byte) (this.goE & 255), outputStream);
            this.goE >>= 8;
            this.goF -= 8;
        }
        if (this.goz > this.gou || this.goA) {
            if (this.goA) {
                int i2 = this.goB;
                this.gos = i2;
                this.gou = sS(i2);
                this.goA = false;
            } else {
                this.gos++;
                if (this.gos == this.got) {
                    this.gou = this.gov;
                } else {
                    this.gou = sS(this.gos);
                }
            }
        }
        if (i == this.goD) {
            while (this.goF > 0) {
                a((byte) (this.goE & 255), outputStream);
                this.goE >>= 8;
                this.goF -= 8;
            }
            g(outputStream);
        }
    }
}
