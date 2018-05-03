package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int fAA;
    private int fAB;
    private byte[] fAC;
    private int fAD;
    private int fAE;
    private int fAF;
    int fAG;
    int fAI;
    int fAP;
    int fAQ;
    int fAR;
    int fAV;
    int fAH = 12;
    int fAJ = 4096;
    int[] fAK = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] fAL = new int[StatusCode.ERROR_NOT_LOGIN];
    int fAM = StatusCode.ERROR_NOT_LOGIN;
    int fAN = 0;
    boolean fAO = false;
    int fAS = 0;
    int fAT = 0;
    int[] fAU = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fAW = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fAA = i;
        this.fAB = i2;
        this.fAC = bArr;
        this.fAD = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fAW;
        int i = this.fAV;
        this.fAV = i + 1;
        bArr[i] = b;
        if (this.fAV >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        qT(this.fAM);
        this.fAN = this.fAQ + 2;
        this.fAO = true;
        b(this.fAQ, outputStream);
    }

    void qT(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fAK[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fAP = i;
        this.fAO = false;
        this.fAG = this.fAP;
        this.fAI = qU(this.fAG);
        this.fAQ = 1 << (i - 1);
        this.fAR = this.fAQ + 1;
        this.fAN = this.fAQ + 2;
        this.fAV = 0;
        int bdd = bdd();
        for (int i3 = this.fAM; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fAM;
        qT(i5);
        b(this.fAQ, outputStream);
        while (true) {
            int bdd2 = bdd();
            if (bdd2 != -1) {
                int i6 = (bdd2 << this.fAH) + bdd;
                int i7 = (bdd2 << i4) ^ bdd;
                if (this.fAK[i7] == i6) {
                    bdd = this.fAL[i7];
                } else {
                    if (this.fAK[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fAK[i7] == i6) {
                                bdd = this.fAL[i7];
                                break;
                            }
                        } while (this.fAK[i7] >= 0);
                    }
                    b(bdd, outputStream);
                    if (this.fAN < this.fAJ) {
                        int[] iArr = this.fAL;
                        int i9 = this.fAN;
                        this.fAN = i9 + 1;
                        iArr[i7] = i9;
                        this.fAK[i7] = i6;
                        bdd = bdd2;
                    } else {
                        e(outputStream);
                        bdd = bdd2;
                    }
                }
            } else {
                b(bdd, outputStream);
                b(this.fAR, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fAD);
        this.fAE = this.fAA * this.fAB;
        this.fAF = 0;
        a(this.fAD + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fAV > 0) {
            outputStream.write(this.fAV);
            outputStream.write(this.fAW, 0, this.fAV);
            this.fAV = 0;
        }
    }

    final int qU(int i) {
        return (1 << i) - 1;
    }

    private int bdd() {
        if (this.fAE == 0) {
            return -1;
        }
        this.fAE--;
        byte[] bArr = this.fAC;
        int i = this.fAF;
        this.fAF = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fAS &= this.fAU[this.fAT];
        if (this.fAT > 0) {
            this.fAS |= i << this.fAT;
        } else {
            this.fAS = i;
        }
        this.fAT += this.fAG;
        while (this.fAT >= 8) {
            a((byte) (this.fAS & 255), outputStream);
            this.fAS >>= 8;
            this.fAT -= 8;
        }
        if (this.fAN > this.fAI || this.fAO) {
            if (this.fAO) {
                int i2 = this.fAP;
                this.fAG = i2;
                this.fAI = qU(i2);
                this.fAO = false;
            } else {
                this.fAG++;
                if (this.fAG == this.fAH) {
                    this.fAI = this.fAJ;
                } else {
                    this.fAI = qU(this.fAG);
                }
            }
        }
        if (i == this.fAR) {
            while (this.fAT > 0) {
                a((byte) (this.fAS & 255), outputStream);
                this.fAS >>= 8;
                this.fAT -= 8;
            }
            f(outputStream);
        }
    }
}
