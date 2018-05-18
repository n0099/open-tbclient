package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int fBG;
    private int fBH;
    private byte[] fBI;
    private int fBJ;
    private int fBK;
    private int fBL;
    int fBM;
    int fBO;
    int fBV;
    int fBW;
    int fBX;
    int fCb;
    int fBN = 12;
    int fBP = 4096;
    int[] fBQ = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] fBR = new int[StatusCode.ERROR_NOT_LOGIN];
    int fBS = StatusCode.ERROR_NOT_LOGIN;
    int fBT = 0;
    boolean fBU = false;
    int fBY = 0;
    int fBZ = 0;
    int[] fCa = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] fCc = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.fBG = i;
        this.fBH = i2;
        this.fBI = bArr;
        this.fBJ = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.fCc;
        int i = this.fCb;
        this.fCb = i + 1;
        bArr[i] = b;
        if (this.fCb >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        qS(this.fBS);
        this.fBT = this.fBW + 2;
        this.fBU = true;
        b(this.fBW, outputStream);
    }

    void qS(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.fBQ[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.fBV = i;
        this.fBU = false;
        this.fBM = this.fBV;
        this.fBO = qT(this.fBM);
        this.fBW = 1 << (i - 1);
        this.fBX = this.fBW + 1;
        this.fBT = this.fBW + 2;
        this.fCb = 0;
        int bdd = bdd();
        for (int i3 = this.fBS; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.fBS;
        qS(i5);
        b(this.fBW, outputStream);
        while (true) {
            int bdd2 = bdd();
            if (bdd2 != -1) {
                int i6 = (bdd2 << this.fBN) + bdd;
                int i7 = (bdd2 << i4) ^ bdd;
                if (this.fBQ[i7] == i6) {
                    bdd = this.fBR[i7];
                } else {
                    if (this.fBQ[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.fBQ[i7] == i6) {
                                bdd = this.fBR[i7];
                                break;
                            }
                        } while (this.fBQ[i7] >= 0);
                    }
                    b(bdd, outputStream);
                    if (this.fBT < this.fBP) {
                        int[] iArr = this.fBR;
                        int i9 = this.fBT;
                        this.fBT = i9 + 1;
                        iArr[i7] = i9;
                        this.fBQ[i7] = i6;
                        bdd = bdd2;
                    } else {
                        e(outputStream);
                        bdd = bdd2;
                    }
                }
            } else {
                b(bdd, outputStream);
                b(this.fBX, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.fBJ);
        this.fBK = this.fBG * this.fBH;
        this.fBL = 0;
        a(this.fBJ + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.fCb > 0) {
            outputStream.write(this.fCb);
            outputStream.write(this.fCc, 0, this.fCb);
            this.fCb = 0;
        }
    }

    final int qT(int i) {
        return (1 << i) - 1;
    }

    private int bdd() {
        if (this.fBK == 0) {
            return -1;
        }
        this.fBK--;
        byte[] bArr = this.fBI;
        int i = this.fBL;
        this.fBL = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.fBY &= this.fCa[this.fBZ];
        if (this.fBZ > 0) {
            this.fBY |= i << this.fBZ;
        } else {
            this.fBY = i;
        }
        this.fBZ += this.fBM;
        while (this.fBZ >= 8) {
            a((byte) (this.fBY & 255), outputStream);
            this.fBY >>= 8;
            this.fBZ -= 8;
        }
        if (this.fBT > this.fBO || this.fBU) {
            if (this.fBU) {
                int i2 = this.fBV;
                this.fBM = i2;
                this.fBO = qT(i2);
                this.fBU = false;
            } else {
                this.fBM++;
                if (this.fBM == this.fBN) {
                    this.fBO = this.fBP;
                } else {
                    this.fBO = qT(this.fBM);
                }
            }
        }
        if (i == this.fBX) {
            while (this.fBZ > 0) {
                a((byte) (this.fBY & 255), outputStream);
                this.fBY >>= 8;
                this.fBZ -= 8;
            }
            f(outputStream);
        }
    }
}
