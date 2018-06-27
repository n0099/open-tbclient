package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int fRe;
    private int fRf;
    private byte[] fRg;
    private int fRh;
    private int fRi;
    private int fRj;
    int fRk;
    int fRm;
    int fRt;
    int fRu;
    int fRv;
    int fRz;
    int fRl = 12;
    int fRn = 4096;
    int[] fRo = new int[5003];
    int[] fRp = new int[5003];
    int fRq = 5003;
    int fRr = 0;
    boolean fRs = false;
    int fRw = 0;
    int fRx = 0;
    int[] fRy = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fRA = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fRe = i;
        this.fRf = i2;
        this.fRg = bArr;
        this.fRh = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fRA;
        int i = this.fRz;
        this.fRz = i + 1;
        bArr[i] = b;
        if (this.fRz >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        rn(this.fRq);
        this.fRr = this.fRu + 2;
        this.fRs = true;
        b(this.fRu, outputStream);
    }

    void rn(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fRo[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fRt = i;
        this.fRs = false;
        this.fRk = this.fRt;
        this.fRm = ro(this.fRk);
        this.fRu = 1 << (i - 1);
        this.fRv = this.fRu + 1;
        this.fRr = this.fRu + 2;
        this.fRz = 0;
        int biJ = biJ();
        for (int i3 = this.fRq; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fRq;
        rn(i5);
        b(this.fRu, outputStream);
        while (true) {
            int biJ2 = biJ();
            if (biJ2 != -1) {
                int i6 = (biJ2 << this.fRl) + biJ;
                int i7 = (biJ2 << i4) ^ biJ;
                if (this.fRo[i7] == i6) {
                    biJ = this.fRp[i7];
                } else {
                    if (this.fRo[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fRo[i7] == i6) {
                                biJ = this.fRp[i7];
                                break;
                            }
                        } while (this.fRo[i7] >= 0);
                    }
                    b(biJ, outputStream);
                    if (this.fRr < this.fRn) {
                        int[] iArr = this.fRp;
                        int i9 = this.fRr;
                        this.fRr = i9 + 1;
                        iArr[i7] = i9;
                        this.fRo[i7] = i6;
                        biJ = biJ2;
                    } else {
                        e(outputStream);
                        biJ = biJ2;
                    }
                }
            } else {
                b(biJ, outputStream);
                b(this.fRv, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fRh);
        this.fRi = this.fRe * this.fRf;
        this.fRj = 0;
        a(this.fRh + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fRz > 0) {
            outputStream.write(this.fRz);
            outputStream.write(this.fRA, 0, this.fRz);
            this.fRz = 0;
        }
    }

    final int ro(int i) {
        return (1 << i) - 1;
    }

    private int biJ() {
        if (this.fRi == 0) {
            return -1;
        }
        this.fRi--;
        byte[] bArr = this.fRg;
        int i = this.fRj;
        this.fRj = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fRw &= this.fRy[this.fRx];
        if (this.fRx > 0) {
            this.fRw |= i << this.fRx;
        } else {
            this.fRw = i;
        }
        this.fRx += this.fRk;
        while (this.fRx >= 8) {
            a((byte) (this.fRw & 255), outputStream);
            this.fRw >>= 8;
            this.fRx -= 8;
        }
        if (this.fRr > this.fRm || this.fRs) {
            if (this.fRs) {
                int i2 = this.fRt;
                this.fRk = i2;
                this.fRm = ro(i2);
                this.fRs = false;
            } else {
                this.fRk++;
                if (this.fRk == this.fRl) {
                    this.fRm = this.fRn;
                } else {
                    this.fRm = ro(this.fRk);
                }
            }
        }
        if (i == this.fRv) {
            while (this.fRx > 0) {
                a((byte) (this.fRw & 255), outputStream);
                this.fRw >>= 8;
                this.fRx -= 8;
            }
            f(outputStream);
        }
    }
}
