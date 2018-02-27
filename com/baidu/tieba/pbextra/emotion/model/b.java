package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int gfR;
    private int gfS;
    private byte[] gfT;
    private int gfU;
    private int gfV;
    private int gfW;
    int gfX;
    int gfZ;
    int ggg;
    int ggh;
    int ggi;
    int ggm;
    int gfY = 12;
    int gga = 4096;
    int[] ggb = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] ggc = new int[StatusCode.ERROR_NOT_LOGIN];
    int ggd = StatusCode.ERROR_NOT_LOGIN;
    int gge = 0;
    boolean ggf = false;
    int ggj = 0;
    int ggk = 0;
    int[] ggl = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ggn = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.gfR = i;
        this.gfS = i2;
        this.gfT = bArr;
        this.gfU = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ggn;
        int i = this.ggm;
        this.ggm = i + 1;
        bArr[i] = b;
        if (this.ggm >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        tx(this.ggd);
        this.gge = this.ggh + 2;
        this.ggf = true;
        b(this.ggh, outputStream);
    }

    void tx(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ggb[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ggg = i;
        this.ggf = false;
        this.gfX = this.ggg;
        this.gfZ = ty(this.gfX);
        this.ggh = 1 << (i - 1);
        this.ggi = this.ggh + 1;
        this.gge = this.ggh + 2;
        this.ggm = 0;
        int bic = bic();
        for (int i3 = this.ggd; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ggd;
        tx(i5);
        b(this.ggh, outputStream);
        while (true) {
            int bic2 = bic();
            if (bic2 != -1) {
                int i6 = (bic2 << this.gfY) + bic;
                int i7 = (bic2 << i4) ^ bic;
                if (this.ggb[i7] == i6) {
                    bic = this.ggc[i7];
                } else {
                    if (this.ggb[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ggb[i7] == i6) {
                                bic = this.ggc[i7];
                                break;
                            }
                        } while (this.ggb[i7] >= 0);
                    }
                    b(bic, outputStream);
                    if (this.gge < this.gga) {
                        int[] iArr = this.ggc;
                        int i9 = this.gge;
                        this.gge = i9 + 1;
                        iArr[i7] = i9;
                        this.ggb[i7] = i6;
                        bic = bic2;
                    } else {
                        e(outputStream);
                        bic = bic2;
                    }
                }
            } else {
                b(bic, outputStream);
                b(this.ggi, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.gfU);
        this.gfV = this.gfR * this.gfS;
        this.gfW = 0;
        a(this.gfU + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.ggm > 0) {
            outputStream.write(this.ggm);
            outputStream.write(this.ggn, 0, this.ggm);
            this.ggm = 0;
        }
    }

    final int ty(int i) {
        return (1 << i) - 1;
    }

    private int bic() {
        if (this.gfV == 0) {
            return -1;
        }
        this.gfV--;
        byte[] bArr = this.gfT;
        int i = this.gfW;
        this.gfW = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ggj &= this.ggl[this.ggk];
        if (this.ggk > 0) {
            this.ggj |= i << this.ggk;
        } else {
            this.ggj = i;
        }
        this.ggk += this.gfX;
        while (this.ggk >= 8) {
            a((byte) (this.ggj & 255), outputStream);
            this.ggj >>= 8;
            this.ggk -= 8;
        }
        if (this.gge > this.gfZ || this.ggf) {
            if (this.ggf) {
                int i2 = this.ggg;
                this.gfX = i2;
                this.gfZ = ty(i2);
                this.ggf = false;
            } else {
                this.gfX++;
                if (this.gfX == this.gfY) {
                    this.gfZ = this.gga;
                } else {
                    this.gfZ = ty(this.gfX);
                }
            }
        }
        if (i == this.ggi) {
            while (this.ggk > 0) {
                a((byte) (this.ggj & 255), outputStream);
                this.ggj >>= 8;
                this.ggk -= 8;
            }
            f(outputStream);
        }
    }
}
