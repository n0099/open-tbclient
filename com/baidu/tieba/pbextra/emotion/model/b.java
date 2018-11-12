package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    private int ghA;
    int ghB;
    int ghD;
    int ghK;
    int ghL;
    int ghM;
    int ghQ;
    private int ghv;
    private int ghw;
    private byte[] ghx;
    private int ghy;
    private int ghz;
    int ghC = 12;
    int ghE = 4096;
    int[] ghF = new int[5003];
    int[] ghG = new int[5003];
    int ghH = 5003;
    int ghI = 0;
    boolean ghJ = false;
    int ghN = 0;
    int ghO = 0;
    int[] ghP = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ghR = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.ghv = i;
        this.ghw = i2;
        this.ghx = bArr;
        this.ghy = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ghR;
        int i = this.ghQ;
        this.ghQ = i + 1;
        bArr[i] = b;
        if (this.ghQ >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        sx(this.ghH);
        this.ghI = this.ghL + 2;
        this.ghJ = true;
        b(this.ghL, outputStream);
    }

    void sx(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ghF[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ghK = i;
        this.ghJ = false;
        this.ghB = this.ghK;
        this.ghD = sy(this.ghB);
        this.ghL = 1 << (i - 1);
        this.ghM = this.ghL + 1;
        this.ghI = this.ghL + 2;
        this.ghQ = 0;
        int bmf = bmf();
        for (int i3 = this.ghH; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ghH;
        sx(i5);
        b(this.ghL, outputStream);
        while (true) {
            int bmf2 = bmf();
            if (bmf2 != -1) {
                int i6 = (bmf2 << this.ghC) + bmf;
                int i7 = (bmf2 << i4) ^ bmf;
                if (this.ghF[i7] == i6) {
                    bmf = this.ghG[i7];
                } else {
                    if (this.ghF[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ghF[i7] == i6) {
                                bmf = this.ghG[i7];
                                break;
                            }
                        } while (this.ghF[i7] >= 0);
                    }
                    b(bmf, outputStream);
                    if (this.ghI < this.ghE) {
                        int[] iArr = this.ghG;
                        int i9 = this.ghI;
                        this.ghI = i9 + 1;
                        iArr[i7] = i9;
                        this.ghF[i7] = i6;
                        bmf = bmf2;
                    } else {
                        f(outputStream);
                        bmf = bmf2;
                    }
                }
            } else {
                b(bmf, outputStream);
                b(this.ghM, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.ghy);
        this.ghz = this.ghv * this.ghw;
        this.ghA = 0;
        a(this.ghy + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.ghQ > 0) {
            outputStream.write(this.ghQ);
            outputStream.write(this.ghR, 0, this.ghQ);
            this.ghQ = 0;
        }
    }

    final int sy(int i) {
        return (1 << i) - 1;
    }

    private int bmf() {
        if (this.ghz == 0) {
            return -1;
        }
        this.ghz--;
        byte[] bArr = this.ghx;
        int i = this.ghA;
        this.ghA = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ghN &= this.ghP[this.ghO];
        if (this.ghO > 0) {
            this.ghN |= i << this.ghO;
        } else {
            this.ghN = i;
        }
        this.ghO += this.ghB;
        while (this.ghO >= 8) {
            a((byte) (this.ghN & 255), outputStream);
            this.ghN >>= 8;
            this.ghO -= 8;
        }
        if (this.ghI > this.ghD || this.ghJ) {
            if (this.ghJ) {
                int i2 = this.ghK;
                this.ghB = i2;
                this.ghD = sy(i2);
                this.ghJ = false;
            } else {
                this.ghB++;
                if (this.ghB == this.ghC) {
                    this.ghD = this.ghE;
                } else {
                    this.ghD = sy(this.ghB);
                }
            }
        }
        if (i == this.ghM) {
            while (this.ghO > 0) {
                a((byte) (this.ghN & 255), outputStream);
                this.ghN >>= 8;
                this.ghO -= 8;
            }
            g(outputStream);
        }
    }
}
