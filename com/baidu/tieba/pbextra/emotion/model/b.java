package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    int fRC;
    private int fRh;
    private int fRi;
    private byte[] fRj;
    private int fRk;
    private int fRl;
    private int fRm;
    int fRn;
    int fRp;
    int fRw;
    int fRx;
    int fRy;
    int fRo = 12;
    int fRq = 4096;
    int[] fRr = new int[5003];
    int[] fRs = new int[5003];
    int fRt = 5003;
    int fRu = 0;
    boolean fRv = false;
    int fRz = 0;
    int fRA = 0;
    int[] fRB = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fRD = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fRh = i;
        this.fRi = i2;
        this.fRj = bArr;
        this.fRk = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fRD;
        int i = this.fRC;
        this.fRC = i + 1;
        bArr[i] = b;
        if (this.fRC >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        rk(this.fRt);
        this.fRu = this.fRx + 2;
        this.fRv = true;
        b(this.fRx, outputStream);
    }

    void rk(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fRr[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fRw = i;
        this.fRv = false;
        this.fRn = this.fRw;
        this.fRp = rl(this.fRn);
        this.fRx = 1 << (i - 1);
        this.fRy = this.fRx + 1;
        this.fRu = this.fRx + 2;
        this.fRC = 0;
        int bgX = bgX();
        for (int i3 = this.fRt; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fRt;
        rk(i5);
        b(this.fRx, outputStream);
        while (true) {
            int bgX2 = bgX();
            if (bgX2 != -1) {
                int i6 = (bgX2 << this.fRo) + bgX;
                int i7 = (bgX2 << i4) ^ bgX;
                if (this.fRr[i7] == i6) {
                    bgX = this.fRs[i7];
                } else {
                    if (this.fRr[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fRr[i7] == i6) {
                                bgX = this.fRs[i7];
                                break;
                            }
                        } while (this.fRr[i7] >= 0);
                    }
                    b(bgX, outputStream);
                    if (this.fRu < this.fRq) {
                        int[] iArr = this.fRs;
                        int i9 = this.fRu;
                        this.fRu = i9 + 1;
                        iArr[i7] = i9;
                        this.fRr[i7] = i6;
                        bgX = bgX2;
                    } else {
                        e(outputStream);
                        bgX = bgX2;
                    }
                }
            } else {
                b(bgX, outputStream);
                b(this.fRy, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fRk);
        this.fRl = this.fRh * this.fRi;
        this.fRm = 0;
        a(this.fRk + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fRC > 0) {
            outputStream.write(this.fRC);
            outputStream.write(this.fRD, 0, this.fRC);
            this.fRC = 0;
        }
    }

    final int rl(int i) {
        return (1 << i) - 1;
    }

    private int bgX() {
        if (this.fRl == 0) {
            return -1;
        }
        this.fRl--;
        byte[] bArr = this.fRj;
        int i = this.fRm;
        this.fRm = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fRz &= this.fRB[this.fRA];
        if (this.fRA > 0) {
            this.fRz |= i << this.fRA;
        } else {
            this.fRz = i;
        }
        this.fRA += this.fRn;
        while (this.fRA >= 8) {
            a((byte) (this.fRz & 255), outputStream);
            this.fRz >>= 8;
            this.fRA -= 8;
        }
        if (this.fRu > this.fRp || this.fRv) {
            if (this.fRv) {
                int i2 = this.fRw;
                this.fRn = i2;
                this.fRp = rl(i2);
                this.fRv = false;
            } else {
                this.fRn++;
                if (this.fRn == this.fRo) {
                    this.fRp = this.fRq;
                } else {
                    this.fRp = rl(this.fRn);
                }
            }
        }
        if (i == this.fRy) {
            while (this.fRA > 0) {
                a((byte) (this.fRz & 255), outputStream);
                this.fRz >>= 8;
                this.fRA -= 8;
            }
            f(outputStream);
        }
    }
}
