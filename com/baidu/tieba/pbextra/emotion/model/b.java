package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int gfY;
    private int gfZ;
    private byte[] gga;
    private int ggb;
    private int ggc;
    private int ggd;
    int gge;
    int ggg;
    int ggn;
    int ggo;
    int ggp;
    int ggt;
    int ggf = 12;
    int ggh = 4096;
    int[] ggi = new int[5003];
    int[] ggj = new int[5003];
    int ggk = 5003;
    int ggl = 0;
    boolean ggm = false;
    int ggq = 0;
    int ggr = 0;
    int[] ggs = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ggu = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.gfY = i;
        this.gfZ = i2;
        this.gga = bArr;
        this.ggb = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ggu;
        int i = this.ggt;
        this.ggt = i + 1;
        bArr[i] = b;
        if (this.ggt >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        se(this.ggk);
        this.ggl = this.ggo + 2;
        this.ggm = true;
        b(this.ggo, outputStream);
    }

    void se(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ggi[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ggn = i;
        this.ggm = false;
        this.gge = this.ggn;
        this.ggg = sf(this.gge);
        this.ggo = 1 << (i - 1);
        this.ggp = this.ggo + 1;
        this.ggl = this.ggo + 2;
        this.ggt = 0;
        int bmJ = bmJ();
        for (int i3 = this.ggk; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ggk;
        se(i5);
        b(this.ggo, outputStream);
        while (true) {
            int bmJ2 = bmJ();
            if (bmJ2 != -1) {
                int i6 = (bmJ2 << this.ggf) + bmJ;
                int i7 = (bmJ2 << i4) ^ bmJ;
                if (this.ggi[i7] == i6) {
                    bmJ = this.ggj[i7];
                } else {
                    if (this.ggi[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ggi[i7] == i6) {
                                bmJ = this.ggj[i7];
                                break;
                            }
                        } while (this.ggi[i7] >= 0);
                    }
                    b(bmJ, outputStream);
                    if (this.ggl < this.ggh) {
                        int[] iArr = this.ggj;
                        int i9 = this.ggl;
                        this.ggl = i9 + 1;
                        iArr[i7] = i9;
                        this.ggi[i7] = i6;
                        bmJ = bmJ2;
                    } else {
                        f(outputStream);
                        bmJ = bmJ2;
                    }
                }
            } else {
                b(bmJ, outputStream);
                b(this.ggp, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.ggb);
        this.ggc = this.gfY * this.gfZ;
        this.ggd = 0;
        a(this.ggb + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.ggt > 0) {
            outputStream.write(this.ggt);
            outputStream.write(this.ggu, 0, this.ggt);
            this.ggt = 0;
        }
    }

    final int sf(int i) {
        return (1 << i) - 1;
    }

    private int bmJ() {
        if (this.ggc == 0) {
            return -1;
        }
        this.ggc--;
        byte[] bArr = this.gga;
        int i = this.ggd;
        this.ggd = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ggq &= this.ggs[this.ggr];
        if (this.ggr > 0) {
            this.ggq |= i << this.ggr;
        } else {
            this.ggq = i;
        }
        this.ggr += this.gge;
        while (this.ggr >= 8) {
            a((byte) (this.ggq & 255), outputStream);
            this.ggq >>= 8;
            this.ggr -= 8;
        }
        if (this.ggl > this.ggg || this.ggm) {
            if (this.ggm) {
                int i2 = this.ggn;
                this.gge = i2;
                this.ggg = sf(i2);
                this.ggm = false;
            } else {
                this.gge++;
                if (this.gge == this.ggf) {
                    this.ggg = this.ggh;
                } else {
                    this.ggg = sf(this.gge);
                }
            }
        }
        if (i == this.ggp) {
            while (this.ggr > 0) {
                a((byte) (this.ggq & 255), outputStream);
                this.ggq >>= 8;
                this.ggr -= 8;
            }
            g(outputStream);
        }
    }
}
