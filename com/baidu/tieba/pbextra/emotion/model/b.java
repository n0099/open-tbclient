package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int fNb;
    private int fNc;
    private byte[] fNd;
    private int fNe;
    private int fNf;
    private int fNg;
    int fNh;
    int fNj;
    int fNq;
    int fNr;
    int fNs;
    int fNw;
    int fNi = 12;
    int fNk = 4096;
    int[] fNl = new int[5003];
    int[] fNm = new int[5003];
    int fNn = 5003;
    int fNo = 0;
    boolean fNp = false;
    int fNt = 0;
    int fNu = 0;
    int[] fNv = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fNx = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fNb = i;
        this.fNc = i2;
        this.fNd = bArr;
        this.fNe = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fNx;
        int i = this.fNw;
        this.fNw = i + 1;
        bArr[i] = b;
        if (this.fNw >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        re(this.fNn);
        this.fNo = this.fNr + 2;
        this.fNp = true;
        b(this.fNr, outputStream);
    }

    void re(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fNl[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fNq = i;
        this.fNp = false;
        this.fNh = this.fNq;
        this.fNj = rf(this.fNh);
        this.fNr = 1 << (i - 1);
        this.fNs = this.fNr + 1;
        this.fNo = this.fNr + 2;
        this.fNw = 0;
        int bid = bid();
        for (int i3 = this.fNn; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fNn;
        re(i5);
        b(this.fNr, outputStream);
        while (true) {
            int bid2 = bid();
            if (bid2 != -1) {
                int i6 = (bid2 << this.fNi) + bid;
                int i7 = (bid2 << i4) ^ bid;
                if (this.fNl[i7] == i6) {
                    bid = this.fNm[i7];
                } else {
                    if (this.fNl[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fNl[i7] == i6) {
                                bid = this.fNm[i7];
                                break;
                            }
                        } while (this.fNl[i7] >= 0);
                    }
                    b(bid, outputStream);
                    if (this.fNo < this.fNk) {
                        int[] iArr = this.fNm;
                        int i9 = this.fNo;
                        this.fNo = i9 + 1;
                        iArr[i7] = i9;
                        this.fNl[i7] = i6;
                        bid = bid2;
                    } else {
                        e(outputStream);
                        bid = bid2;
                    }
                }
            } else {
                b(bid, outputStream);
                b(this.fNs, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fNe);
        this.fNf = this.fNb * this.fNc;
        this.fNg = 0;
        a(this.fNe + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fNw > 0) {
            outputStream.write(this.fNw);
            outputStream.write(this.fNx, 0, this.fNw);
            this.fNw = 0;
        }
    }

    final int rf(int i) {
        return (1 << i) - 1;
    }

    private int bid() {
        if (this.fNf == 0) {
            return -1;
        }
        this.fNf--;
        byte[] bArr = this.fNd;
        int i = this.fNg;
        this.fNg = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fNt &= this.fNv[this.fNu];
        if (this.fNu > 0) {
            this.fNt |= i << this.fNu;
        } else {
            this.fNt = i;
        }
        this.fNu += this.fNh;
        while (this.fNu >= 8) {
            a((byte) (this.fNt & 255), outputStream);
            this.fNt >>= 8;
            this.fNu -= 8;
        }
        if (this.fNo > this.fNj || this.fNp) {
            if (this.fNp) {
                int i2 = this.fNq;
                this.fNh = i2;
                this.fNj = rf(i2);
                this.fNp = false;
            } else {
                this.fNh++;
                if (this.fNh == this.fNi) {
                    this.fNj = this.fNk;
                } else {
                    this.fNj = rf(this.fNh);
                }
            }
        }
        if (i == this.fNs) {
            while (this.fNu > 0) {
                a((byte) (this.fNt & 255), outputStream);
                this.fNt >>= 8;
                this.fNu -= 8;
            }
            f(outputStream);
        }
    }
}
