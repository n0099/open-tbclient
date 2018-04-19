package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int fAD;
    private int fAE;
    private byte[] fAF;
    private int fAG;
    private int fAH;
    private int fAI;
    int fAJ;
    int fAL;
    int fAS;
    int fAT;
    int fAU;
    int fAY;
    int fAK = 12;
    int fAM = 4096;
    int[] fAN = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] fAO = new int[StatusCode.ERROR_NOT_LOGIN];
    int fAP = StatusCode.ERROR_NOT_LOGIN;
    int fAQ = 0;
    boolean fAR = false;
    int fAV = 0;
    int fAW = 0;
    int[] fAX = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fAZ = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fAD = i;
        this.fAE = i2;
        this.fAF = bArr;
        this.fAG = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fAZ;
        int i = this.fAY;
        this.fAY = i + 1;
        bArr[i] = b;
        if (this.fAY >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        qT(this.fAP);
        this.fAQ = this.fAT + 2;
        this.fAR = true;
        b(this.fAT, outputStream);
    }

    void qT(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fAN[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fAS = i;
        this.fAR = false;
        this.fAJ = this.fAS;
        this.fAL = qU(this.fAJ);
        this.fAT = 1 << (i - 1);
        this.fAU = this.fAT + 1;
        this.fAQ = this.fAT + 2;
        this.fAY = 0;
        int bdd = bdd();
        for (int i3 = this.fAP; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fAP;
        qT(i5);
        b(this.fAT, outputStream);
        while (true) {
            int bdd2 = bdd();
            if (bdd2 != -1) {
                int i6 = (bdd2 << this.fAK) + bdd;
                int i7 = (bdd2 << i4) ^ bdd;
                if (this.fAN[i7] == i6) {
                    bdd = this.fAO[i7];
                } else {
                    if (this.fAN[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fAN[i7] == i6) {
                                bdd = this.fAO[i7];
                                break;
                            }
                        } while (this.fAN[i7] >= 0);
                    }
                    b(bdd, outputStream);
                    if (this.fAQ < this.fAM) {
                        int[] iArr = this.fAO;
                        int i9 = this.fAQ;
                        this.fAQ = i9 + 1;
                        iArr[i7] = i9;
                        this.fAN[i7] = i6;
                        bdd = bdd2;
                    } else {
                        e(outputStream);
                        bdd = bdd2;
                    }
                }
            } else {
                b(bdd, outputStream);
                b(this.fAU, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fAG);
        this.fAH = this.fAD * this.fAE;
        this.fAI = 0;
        a(this.fAG + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fAY > 0) {
            outputStream.write(this.fAY);
            outputStream.write(this.fAZ, 0, this.fAY);
            this.fAY = 0;
        }
    }

    final int qU(int i) {
        return (1 << i) - 1;
    }

    private int bdd() {
        if (this.fAH == 0) {
            return -1;
        }
        this.fAH--;
        byte[] bArr = this.fAF;
        int i = this.fAI;
        this.fAI = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fAV &= this.fAX[this.fAW];
        if (this.fAW > 0) {
            this.fAV |= i << this.fAW;
        } else {
            this.fAV = i;
        }
        this.fAW += this.fAJ;
        while (this.fAW >= 8) {
            a((byte) (this.fAV & 255), outputStream);
            this.fAV >>= 8;
            this.fAW -= 8;
        }
        if (this.fAQ > this.fAL || this.fAR) {
            if (this.fAR) {
                int i2 = this.fAS;
                this.fAJ = i2;
                this.fAL = qU(i2);
                this.fAR = false;
            } else {
                this.fAJ++;
                if (this.fAJ == this.fAK) {
                    this.fAL = this.fAM;
                } else {
                    this.fAL = qU(this.fAJ);
                }
            }
        }
        if (i == this.fAU) {
            while (this.fAW > 0) {
                a((byte) (this.fAV & 255), outputStream);
                this.fAV >>= 8;
                this.fAW -= 8;
            }
            f(outputStream);
        }
    }
}
