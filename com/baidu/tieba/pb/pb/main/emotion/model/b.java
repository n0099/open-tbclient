package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    int eWC;
    int eWD;
    int eWE;
    int eWI;
    private int eWn;
    private int eWo;
    private byte[] eWp;
    private int eWq;
    private int eWr;
    private int eWs;
    int eWt;
    int eWv;
    int eWu = 12;
    int eWw = 4096;
    int[] eWx = new int[5003];
    int[] eWy = new int[5003];
    int eWz = 5003;
    int eWA = 0;
    boolean eWB = false;
    int eWF = 0;
    int eWG = 0;
    int[] eWH = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eWJ = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eWn = i;
        this.eWo = i2;
        this.eWp = bArr;
        this.eWq = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eWJ;
        int i = this.eWI;
        this.eWI = i + 1;
        bArr[i] = b;
        if (this.eWI >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        pU(this.eWz);
        this.eWA = this.eWD + 2;
        this.eWB = true;
        b(this.eWD, outputStream);
    }

    void pU(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eWx[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eWC = i;
        this.eWB = false;
        this.eWt = this.eWC;
        this.eWv = pV(this.eWt);
        this.eWD = 1 << (i - 1);
        this.eWE = this.eWD + 1;
        this.eWA = this.eWD + 2;
        this.eWI = 0;
        int aVL = aVL();
        for (int i3 = this.eWz; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eWz;
        pU(i5);
        b(this.eWD, outputStream);
        while (true) {
            int aVL2 = aVL();
            if (aVL2 != -1) {
                int i6 = (aVL2 << this.eWu) + aVL;
                int i7 = (aVL2 << i4) ^ aVL;
                if (this.eWx[i7] == i6) {
                    aVL = this.eWy[i7];
                } else {
                    if (this.eWx[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eWx[i7] == i6) {
                                aVL = this.eWy[i7];
                                break;
                            }
                        } while (this.eWx[i7] >= 0);
                    }
                    b(aVL, outputStream);
                    if (this.eWA < this.eWw) {
                        int[] iArr = this.eWy;
                        int i9 = this.eWA;
                        this.eWA = i9 + 1;
                        iArr[i7] = i9;
                        this.eWx[i7] = i6;
                        aVL = aVL2;
                    } else {
                        e(outputStream);
                        aVL = aVL2;
                    }
                }
            } else {
                b(aVL, outputStream);
                b(this.eWE, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eWq);
        this.eWr = this.eWn * this.eWo;
        this.eWs = 0;
        a(this.eWq + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.eWI > 0) {
            outputStream.write(this.eWI);
            outputStream.write(this.eWJ, 0, this.eWI);
            this.eWI = 0;
        }
    }

    final int pV(int i) {
        return (1 << i) - 1;
    }

    private int aVL() {
        if (this.eWr == 0) {
            return -1;
        }
        this.eWr--;
        byte[] bArr = this.eWp;
        int i = this.eWs;
        this.eWs = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.eWF &= this.eWH[this.eWG];
        if (this.eWG > 0) {
            this.eWF |= i << this.eWG;
        } else {
            this.eWF = i;
        }
        this.eWG += this.eWt;
        while (this.eWG >= 8) {
            a((byte) (this.eWF & MotionEventCompat.ACTION_MASK), outputStream);
            this.eWF >>= 8;
            this.eWG -= 8;
        }
        if (this.eWA > this.eWv || this.eWB) {
            if (this.eWB) {
                int i2 = this.eWC;
                this.eWt = i2;
                this.eWv = pV(i2);
                this.eWB = false;
            } else {
                this.eWt++;
                if (this.eWt == this.eWu) {
                    this.eWv = this.eWw;
                } else {
                    this.eWv = pV(this.eWt);
                }
            }
        }
        if (i == this.eWE) {
            while (this.eWG > 0) {
                a((byte) (this.eWF & MotionEventCompat.ACTION_MASK), outputStream);
                this.eWF >>= 8;
                this.eWG -= 8;
            }
            f(outputStream);
        }
    }
}
