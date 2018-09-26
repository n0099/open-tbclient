package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int fYA;
    private int fYB;
    private int fYC;
    int fYD;
    int fYF;
    int fYM;
    int fYN;
    int fYO;
    int fYS;
    private int fYx;
    private int fYy;
    private byte[] fYz;
    int fYE = 12;
    int fYG = 4096;
    int[] fYH = new int[5003];
    int[] fYI = new int[5003];
    int fYJ = 5003;
    int fYK = 0;
    boolean fYL = false;
    int fYP = 0;
    int fYQ = 0;
    int[] fYR = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fYT = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fYx = i;
        this.fYy = i2;
        this.fYz = bArr;
        this.fYA = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fYT;
        int i = this.fYS;
        this.fYS = i + 1;
        bArr[i] = b;
        if (this.fYS >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        rH(this.fYJ);
        this.fYK = this.fYN + 2;
        this.fYL = true;
        b(this.fYN, outputStream);
    }

    void rH(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fYH[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fYM = i;
        this.fYL = false;
        this.fYD = this.fYM;
        this.fYF = rI(this.fYD);
        this.fYN = 1 << (i - 1);
        this.fYO = this.fYN + 1;
        this.fYK = this.fYN + 2;
        this.fYS = 0;
        int bjy = bjy();
        for (int i3 = this.fYJ; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fYJ;
        rH(i5);
        b(this.fYN, outputStream);
        while (true) {
            int bjy2 = bjy();
            if (bjy2 != -1) {
                int i6 = (bjy2 << this.fYE) + bjy;
                int i7 = (bjy2 << i4) ^ bjy;
                if (this.fYH[i7] == i6) {
                    bjy = this.fYI[i7];
                } else {
                    if (this.fYH[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fYH[i7] == i6) {
                                bjy = this.fYI[i7];
                                break;
                            }
                        } while (this.fYH[i7] >= 0);
                    }
                    b(bjy, outputStream);
                    if (this.fYK < this.fYG) {
                        int[] iArr = this.fYI;
                        int i9 = this.fYK;
                        this.fYK = i9 + 1;
                        iArr[i7] = i9;
                        this.fYH[i7] = i6;
                        bjy = bjy2;
                    } else {
                        e(outputStream);
                        bjy = bjy2;
                    }
                }
            } else {
                b(bjy, outputStream);
                b(this.fYO, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fYA);
        this.fYB = this.fYx * this.fYy;
        this.fYC = 0;
        a(this.fYA + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fYS > 0) {
            outputStream.write(this.fYS);
            outputStream.write(this.fYT, 0, this.fYS);
            this.fYS = 0;
        }
    }

    final int rI(int i) {
        return (1 << i) - 1;
    }

    private int bjy() {
        if (this.fYB == 0) {
            return -1;
        }
        this.fYB--;
        byte[] bArr = this.fYz;
        int i = this.fYC;
        this.fYC = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fYP &= this.fYR[this.fYQ];
        if (this.fYQ > 0) {
            this.fYP |= i << this.fYQ;
        } else {
            this.fYP = i;
        }
        this.fYQ += this.fYD;
        while (this.fYQ >= 8) {
            a((byte) (this.fYP & 255), outputStream);
            this.fYP >>= 8;
            this.fYQ -= 8;
        }
        if (this.fYK > this.fYF || this.fYL) {
            if (this.fYL) {
                int i2 = this.fYM;
                this.fYD = i2;
                this.fYF = rI(i2);
                this.fYL = false;
            } else {
                this.fYD++;
                if (this.fYD == this.fYE) {
                    this.fYF = this.fYG;
                } else {
                    this.fYF = rI(this.fYD);
                }
            }
        }
        if (i == this.fYO) {
            while (this.fYQ > 0) {
                a((byte) (this.fYP & 255), outputStream);
                this.fYP >>= 8;
                this.fYQ -= 8;
            }
            f(outputStream);
        }
    }
}
