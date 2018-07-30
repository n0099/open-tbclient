package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    int fRE;
    int fRF;
    int fRG;
    int fRK;
    private int fRp;
    private int fRq;
    private byte[] fRr;
    private int fRs;
    private int fRt;
    private int fRu;
    int fRv;
    int fRx;
    int fRw = 12;
    int fRy = 4096;
    int[] fRz = new int[5003];
    int[] fRA = new int[5003];
    int fRB = 5003;
    int fRC = 0;
    boolean fRD = false;
    int fRH = 0;
    int fRI = 0;
    int[] fRJ = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fRL = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fRp = i;
        this.fRq = i2;
        this.fRr = bArr;
        this.fRs = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fRL;
        int i = this.fRK;
        this.fRK = i + 1;
        bArr[i] = b;
        if (this.fRK >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        rk(this.fRB);
        this.fRC = this.fRF + 2;
        this.fRD = true;
        b(this.fRF, outputStream);
    }

    void rk(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fRz[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fRE = i;
        this.fRD = false;
        this.fRv = this.fRE;
        this.fRx = rl(this.fRv);
        this.fRF = 1 << (i - 1);
        this.fRG = this.fRF + 1;
        this.fRC = this.fRF + 2;
        this.fRK = 0;
        int bhc = bhc();
        for (int i3 = this.fRB; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fRB;
        rk(i5);
        b(this.fRF, outputStream);
        while (true) {
            int bhc2 = bhc();
            if (bhc2 != -1) {
                int i6 = (bhc2 << this.fRw) + bhc;
                int i7 = (bhc2 << i4) ^ bhc;
                if (this.fRz[i7] == i6) {
                    bhc = this.fRA[i7];
                } else {
                    if (this.fRz[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fRz[i7] == i6) {
                                bhc = this.fRA[i7];
                                break;
                            }
                        } while (this.fRz[i7] >= 0);
                    }
                    b(bhc, outputStream);
                    if (this.fRC < this.fRy) {
                        int[] iArr = this.fRA;
                        int i9 = this.fRC;
                        this.fRC = i9 + 1;
                        iArr[i7] = i9;
                        this.fRz[i7] = i6;
                        bhc = bhc2;
                    } else {
                        e(outputStream);
                        bhc = bhc2;
                    }
                }
            } else {
                b(bhc, outputStream);
                b(this.fRG, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fRs);
        this.fRt = this.fRp * this.fRq;
        this.fRu = 0;
        a(this.fRs + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fRK > 0) {
            outputStream.write(this.fRK);
            outputStream.write(this.fRL, 0, this.fRK);
            this.fRK = 0;
        }
    }

    final int rl(int i) {
        return (1 << i) - 1;
    }

    private int bhc() {
        if (this.fRt == 0) {
            return -1;
        }
        this.fRt--;
        byte[] bArr = this.fRr;
        int i = this.fRu;
        this.fRu = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fRH &= this.fRJ[this.fRI];
        if (this.fRI > 0) {
            this.fRH |= i << this.fRI;
        } else {
            this.fRH = i;
        }
        this.fRI += this.fRv;
        while (this.fRI >= 8) {
            a((byte) (this.fRH & 255), outputStream);
            this.fRH >>= 8;
            this.fRI -= 8;
        }
        if (this.fRC > this.fRx || this.fRD) {
            if (this.fRD) {
                int i2 = this.fRE;
                this.fRv = i2;
                this.fRx = rl(i2);
                this.fRD = false;
            } else {
                this.fRv++;
                if (this.fRv == this.fRw) {
                    this.fRx = this.fRy;
                } else {
                    this.fRx = rl(this.fRv);
                }
            }
        }
        if (i == this.fRG) {
            while (this.fRI > 0) {
                a((byte) (this.fRH & 255), outputStream);
                this.fRH >>= 8;
                this.fRI -= 8;
            }
            f(outputStream);
        }
    }
}
