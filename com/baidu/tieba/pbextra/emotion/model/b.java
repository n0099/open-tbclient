package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int grd;
    private int gre;
    private byte[] grf;
    private int grg;
    private int grh;
    private int gri;
    int grj;
    int grl;
    int grs;
    int grt;
    int gru;
    int gry;
    int grk = 12;
    int grm = 4096;
    int[] grn = new int[5003];
    int[] gro = new int[5003];
    int grp = 5003;
    int grq = 0;
    boolean grr = false;
    int grv = 0;
    int grw = 0;
    int[] grx = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] grz = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.grd = i;
        this.gre = i2;
        this.grf = bArr;
        this.grg = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.grz;
        int i = this.gry;
        this.gry = i + 1;
        bArr[i] = b;
        if (this.gry >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        te(this.grp);
        this.grq = this.grt + 2;
        this.grr = true;
        b(this.grt, outputStream);
    }

    void te(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.grn[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.grs = i;
        this.grr = false;
        this.grj = this.grs;
        this.grl = tf(this.grj);
        this.grt = 1 << (i - 1);
        this.gru = this.grt + 1;
        this.grq = this.grt + 2;
        this.gry = 0;
        int boJ = boJ();
        for (int i3 = this.grp; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.grp;
        te(i5);
        b(this.grt, outputStream);
        while (true) {
            int boJ2 = boJ();
            if (boJ2 != -1) {
                int i6 = (boJ2 << this.grk) + boJ;
                int i7 = (boJ2 << i4) ^ boJ;
                if (this.grn[i7] == i6) {
                    boJ = this.gro[i7];
                } else {
                    if (this.grn[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.grn[i7] == i6) {
                                boJ = this.gro[i7];
                                break;
                            }
                        } while (this.grn[i7] >= 0);
                    }
                    b(boJ, outputStream);
                    if (this.grq < this.grm) {
                        int[] iArr = this.gro;
                        int i9 = this.grq;
                        this.grq = i9 + 1;
                        iArr[i7] = i9;
                        this.grn[i7] = i6;
                        boJ = boJ2;
                    } else {
                        f(outputStream);
                        boJ = boJ2;
                    }
                }
            } else {
                b(boJ, outputStream);
                b(this.gru, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.grg);
        this.grh = this.grd * this.gre;
        this.gri = 0;
        a(this.grg + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.gry > 0) {
            outputStream.write(this.gry);
            outputStream.write(this.grz, 0, this.gry);
            this.gry = 0;
        }
    }

    final int tf(int i) {
        return (1 << i) - 1;
    }

    private int boJ() {
        if (this.grh == 0) {
            return -1;
        }
        this.grh--;
        byte[] bArr = this.grf;
        int i = this.gri;
        this.gri = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.grv &= this.grx[this.grw];
        if (this.grw > 0) {
            this.grv |= i << this.grw;
        } else {
            this.grv = i;
        }
        this.grw += this.grj;
        while (this.grw >= 8) {
            a((byte) (this.grv & 255), outputStream);
            this.grv >>= 8;
            this.grw -= 8;
        }
        if (this.grq > this.grl || this.grr) {
            if (this.grr) {
                int i2 = this.grs;
                this.grj = i2;
                this.grl = tf(i2);
                this.grr = false;
            } else {
                this.grj++;
                if (this.grj == this.grk) {
                    this.grl = this.grm;
                } else {
                    this.grl = tf(this.grj);
                }
            }
        }
        if (i == this.gru) {
            while (this.grw > 0) {
                a((byte) (this.grv & 255), outputStream);
                this.grv >>= 8;
                this.grw -= 8;
            }
            g(outputStream);
        }
    }
}
