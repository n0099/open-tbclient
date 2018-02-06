package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int ggc;
    private int ggd;
    private byte[] gge;
    private int ggf;
    private int ggg;
    private int ggh;
    int ggi;
    int ggk;
    int ggr;
    int ggs;
    int ggt;
    int ggx;
    int ggj = 12;
    int ggl = 4096;
    int[] ggm = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] ggn = new int[StatusCode.ERROR_NOT_LOGIN];
    int ggo = StatusCode.ERROR_NOT_LOGIN;
    int ggp = 0;
    boolean ggq = false;
    int ggu = 0;
    int ggv = 0;
    int[] ggw = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ggy = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.ggc = i;
        this.ggd = i2;
        this.gge = bArr;
        this.ggf = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ggy;
        int i = this.ggx;
        this.ggx = i + 1;
        bArr[i] = b;
        if (this.ggx >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        tw(this.ggo);
        this.ggp = this.ggs + 2;
        this.ggq = true;
        b(this.ggs, outputStream);
    }

    void tw(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ggm[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ggr = i;
        this.ggq = false;
        this.ggi = this.ggr;
        this.ggk = tx(this.ggi);
        this.ggs = 1 << (i - 1);
        this.ggt = this.ggs + 1;
        this.ggp = this.ggs + 2;
        this.ggx = 0;
        int bid = bid();
        for (int i3 = this.ggo; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ggo;
        tw(i5);
        b(this.ggs, outputStream);
        while (true) {
            int bid2 = bid();
            if (bid2 != -1) {
                int i6 = (bid2 << this.ggj) + bid;
                int i7 = (bid2 << i4) ^ bid;
                if (this.ggm[i7] == i6) {
                    bid = this.ggn[i7];
                } else {
                    if (this.ggm[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ggm[i7] == i6) {
                                bid = this.ggn[i7];
                                break;
                            }
                        } while (this.ggm[i7] >= 0);
                    }
                    b(bid, outputStream);
                    if (this.ggp < this.ggl) {
                        int[] iArr = this.ggn;
                        int i9 = this.ggp;
                        this.ggp = i9 + 1;
                        iArr[i7] = i9;
                        this.ggm[i7] = i6;
                        bid = bid2;
                    } else {
                        e(outputStream);
                        bid = bid2;
                    }
                }
            } else {
                b(bid, outputStream);
                b(this.ggt, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.ggf);
        this.ggg = this.ggc * this.ggd;
        this.ggh = 0;
        a(this.ggf + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.ggx > 0) {
            outputStream.write(this.ggx);
            outputStream.write(this.ggy, 0, this.ggx);
            this.ggx = 0;
        }
    }

    final int tx(int i) {
        return (1 << i) - 1;
    }

    private int bid() {
        if (this.ggg == 0) {
            return -1;
        }
        this.ggg--;
        byte[] bArr = this.gge;
        int i = this.ggh;
        this.ggh = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ggu &= this.ggw[this.ggv];
        if (this.ggv > 0) {
            this.ggu |= i << this.ggv;
        } else {
            this.ggu = i;
        }
        this.ggv += this.ggi;
        while (this.ggv >= 8) {
            a((byte) (this.ggu & 255), outputStream);
            this.ggu >>= 8;
            this.ggv -= 8;
        }
        if (this.ggp > this.ggk || this.ggq) {
            if (this.ggq) {
                int i2 = this.ggr;
                this.ggi = i2;
                this.ggk = tx(i2);
                this.ggq = false;
            } else {
                this.ggi++;
                if (this.ggi == this.ggj) {
                    this.ggk = this.ggl;
                } else {
                    this.ggk = tx(this.ggi);
                }
            }
        }
        if (i == this.ggt) {
            while (this.ggv > 0) {
                a((byte) (this.ggu & 255), outputStream);
                this.ggu >>= 8;
                this.ggv -= 8;
            }
            f(outputStream);
        }
    }
}
