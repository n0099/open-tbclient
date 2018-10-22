package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int gfZ;
    private int gga;
    private byte[] ggb;
    private int ggc;
    private int ggd;
    private int gge;
    int ggf;
    int ggh;
    int ggo;
    int ggp;
    int ggq;
    int ggu;
    int ggg = 12;
    int ggi = 4096;
    int[] ggj = new int[5003];
    int[] ggk = new int[5003];
    int ggl = 5003;
    int ggm = 0;
    boolean ggn = false;
    int ggr = 0;
    int ggs = 0;
    int[] ggt = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ggv = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.gfZ = i;
        this.gga = i2;
        this.ggb = bArr;
        this.ggc = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ggv;
        int i = this.ggu;
        this.ggu = i + 1;
        bArr[i] = b;
        if (this.ggu >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        se(this.ggl);
        this.ggm = this.ggp + 2;
        this.ggn = true;
        b(this.ggp, outputStream);
    }

    void se(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ggj[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ggo = i;
        this.ggn = false;
        this.ggf = this.ggo;
        this.ggh = sf(this.ggf);
        this.ggp = 1 << (i - 1);
        this.ggq = this.ggp + 1;
        this.ggm = this.ggp + 2;
        this.ggu = 0;
        int bmJ = bmJ();
        for (int i3 = this.ggl; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ggl;
        se(i5);
        b(this.ggp, outputStream);
        while (true) {
            int bmJ2 = bmJ();
            if (bmJ2 != -1) {
                int i6 = (bmJ2 << this.ggg) + bmJ;
                int i7 = (bmJ2 << i4) ^ bmJ;
                if (this.ggj[i7] == i6) {
                    bmJ = this.ggk[i7];
                } else {
                    if (this.ggj[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ggj[i7] == i6) {
                                bmJ = this.ggk[i7];
                                break;
                            }
                        } while (this.ggj[i7] >= 0);
                    }
                    b(bmJ, outputStream);
                    if (this.ggm < this.ggi) {
                        int[] iArr = this.ggk;
                        int i9 = this.ggm;
                        this.ggm = i9 + 1;
                        iArr[i7] = i9;
                        this.ggj[i7] = i6;
                        bmJ = bmJ2;
                    } else {
                        f(outputStream);
                        bmJ = bmJ2;
                    }
                }
            } else {
                b(bmJ, outputStream);
                b(this.ggq, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.ggc);
        this.ggd = this.gfZ * this.gga;
        this.gge = 0;
        a(this.ggc + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.ggu > 0) {
            outputStream.write(this.ggu);
            outputStream.write(this.ggv, 0, this.ggu);
            this.ggu = 0;
        }
    }

    final int sf(int i) {
        return (1 << i) - 1;
    }

    private int bmJ() {
        if (this.ggd == 0) {
            return -1;
        }
        this.ggd--;
        byte[] bArr = this.ggb;
        int i = this.gge;
        this.gge = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ggr &= this.ggt[this.ggs];
        if (this.ggs > 0) {
            this.ggr |= i << this.ggs;
        } else {
            this.ggr = i;
        }
        this.ggs += this.ggf;
        while (this.ggs >= 8) {
            a((byte) (this.ggr & 255), outputStream);
            this.ggr >>= 8;
            this.ggs -= 8;
        }
        if (this.ggm > this.ggh || this.ggn) {
            if (this.ggn) {
                int i2 = this.ggo;
                this.ggf = i2;
                this.ggh = sf(i2);
                this.ggn = false;
            } else {
                this.ggf++;
                if (this.ggf == this.ggg) {
                    this.ggh = this.ggi;
                } else {
                    this.ggh = sf(this.ggf);
                }
            }
        }
        if (i == this.ggq) {
            while (this.ggs > 0) {
                a((byte) (this.ggr & 255), outputStream);
                this.ggr >>= 8;
                this.ggs -= 8;
            }
            g(outputStream);
        }
    }
}
