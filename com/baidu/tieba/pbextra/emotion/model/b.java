package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    int ggC;
    private int ggh;
    private int ggi;
    private byte[] ggj;
    private int ggk;
    private int ggl;
    private int ggm;
    int ggn;
    int ggp;
    int ggw;
    int ggx;
    int ggy;
    int ggo = 12;
    int ggq = 4096;
    int[] ggr = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] ggs = new int[StatusCode.ERROR_NOT_LOGIN];
    int ggt = StatusCode.ERROR_NOT_LOGIN;
    int ggu = 0;
    boolean ggv = false;
    int ggz = 0;
    int ggA = 0;
    int[] ggB = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ggD = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.ggh = i;
        this.ggi = i2;
        this.ggj = bArr;
        this.ggk = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ggD;
        int i = this.ggC;
        this.ggC = i + 1;
        bArr[i] = b;
        if (this.ggC >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        tx(this.ggt);
        this.ggu = this.ggx + 2;
        this.ggv = true;
        b(this.ggx, outputStream);
    }

    void tx(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ggr[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ggw = i;
        this.ggv = false;
        this.ggn = this.ggw;
        this.ggp = ty(this.ggn);
        this.ggx = 1 << (i - 1);
        this.ggy = this.ggx + 1;
        this.ggu = this.ggx + 2;
        this.ggC = 0;
        int bid = bid();
        for (int i3 = this.ggt; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ggt;
        tx(i5);
        b(this.ggx, outputStream);
        while (true) {
            int bid2 = bid();
            if (bid2 != -1) {
                int i6 = (bid2 << this.ggo) + bid;
                int i7 = (bid2 << i4) ^ bid;
                if (this.ggr[i7] == i6) {
                    bid = this.ggs[i7];
                } else {
                    if (this.ggr[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ggr[i7] == i6) {
                                bid = this.ggs[i7];
                                break;
                            }
                        } while (this.ggr[i7] >= 0);
                    }
                    b(bid, outputStream);
                    if (this.ggu < this.ggq) {
                        int[] iArr = this.ggs;
                        int i9 = this.ggu;
                        this.ggu = i9 + 1;
                        iArr[i7] = i9;
                        this.ggr[i7] = i6;
                        bid = bid2;
                    } else {
                        e(outputStream);
                        bid = bid2;
                    }
                }
            } else {
                b(bid, outputStream);
                b(this.ggy, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.ggk);
        this.ggl = this.ggh * this.ggi;
        this.ggm = 0;
        a(this.ggk + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.ggC > 0) {
            outputStream.write(this.ggC);
            outputStream.write(this.ggD, 0, this.ggC);
            this.ggC = 0;
        }
    }

    final int ty(int i) {
        return (1 << i) - 1;
    }

    private int bid() {
        if (this.ggl == 0) {
            return -1;
        }
        this.ggl--;
        byte[] bArr = this.ggj;
        int i = this.ggm;
        this.ggm = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ggz &= this.ggB[this.ggA];
        if (this.ggA > 0) {
            this.ggz |= i << this.ggA;
        } else {
            this.ggz = i;
        }
        this.ggA += this.ggn;
        while (this.ggA >= 8) {
            a((byte) (this.ggz & 255), outputStream);
            this.ggz >>= 8;
            this.ggA -= 8;
        }
        if (this.ggu > this.ggp || this.ggv) {
            if (this.ggv) {
                int i2 = this.ggw;
                this.ggn = i2;
                this.ggp = ty(i2);
                this.ggv = false;
            } else {
                this.ggn++;
                if (this.ggn == this.ggo) {
                    this.ggp = this.ggq;
                } else {
                    this.ggp = ty(this.ggn);
                }
            }
        }
        if (i == this.ggy) {
            while (this.ggA > 0) {
                a((byte) (this.ggz & 255), outputStream);
                this.ggz >>= 8;
                this.ggA -= 8;
            }
            f(outputStream);
        }
    }
}
