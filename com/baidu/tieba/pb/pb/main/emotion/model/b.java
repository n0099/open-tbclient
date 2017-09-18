package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    int eTC;
    int eTD;
    int eTE;
    int eTI;
    private int eTn;
    private int eTo;
    private byte[] eTp;
    private int eTq;
    private int eTr;
    private int eTs;
    int eTt;
    int eTv;
    int eTu = 12;
    int eTw = 4096;
    int[] eTx = new int[5003];
    int[] eTy = new int[5003];
    int eTz = 5003;
    int eTA = 0;
    boolean eTB = false;
    int eTF = 0;
    int eTG = 0;
    int[] eTH = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eTJ = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eTn = i;
        this.eTo = i2;
        this.eTp = bArr;
        this.eTq = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eTJ;
        int i = this.eTI;
        this.eTI = i + 1;
        bArr[i] = b;
        if (this.eTI >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        pE(this.eTz);
        this.eTA = this.eTD + 2;
        this.eTB = true;
        b(this.eTD, outputStream);
    }

    void pE(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eTx[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eTC = i;
        this.eTB = false;
        this.eTt = this.eTC;
        this.eTv = pF(this.eTt);
        this.eTD = 1 << (i - 1);
        this.eTE = this.eTD + 1;
        this.eTA = this.eTD + 2;
        this.eTI = 0;
        int aUl = aUl();
        for (int i3 = this.eTz; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eTz;
        pE(i5);
        b(this.eTD, outputStream);
        while (true) {
            int aUl2 = aUl();
            if (aUl2 != -1) {
                int i6 = (aUl2 << this.eTu) + aUl;
                int i7 = (aUl2 << i4) ^ aUl;
                if (this.eTx[i7] == i6) {
                    aUl = this.eTy[i7];
                } else {
                    if (this.eTx[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eTx[i7] == i6) {
                                aUl = this.eTy[i7];
                                break;
                            }
                        } while (this.eTx[i7] >= 0);
                    }
                    b(aUl, outputStream);
                    if (this.eTA < this.eTw) {
                        int[] iArr = this.eTy;
                        int i9 = this.eTA;
                        this.eTA = i9 + 1;
                        iArr[i7] = i9;
                        this.eTx[i7] = i6;
                        aUl = aUl2;
                    } else {
                        f(outputStream);
                        aUl = aUl2;
                    }
                }
            } else {
                b(aUl, outputStream);
                b(this.eTE, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eTq);
        this.eTr = this.eTn * this.eTo;
        this.eTs = 0;
        a(this.eTq + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.eTI > 0) {
            outputStream.write(this.eTI);
            outputStream.write(this.eTJ, 0, this.eTI);
            this.eTI = 0;
        }
    }

    final int pF(int i) {
        return (1 << i) - 1;
    }

    private int aUl() {
        if (this.eTr == 0) {
            return -1;
        }
        this.eTr--;
        byte[] bArr = this.eTp;
        int i = this.eTs;
        this.eTs = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.eTF &= this.eTH[this.eTG];
        if (this.eTG > 0) {
            this.eTF |= i << this.eTG;
        } else {
            this.eTF = i;
        }
        this.eTG += this.eTt;
        while (this.eTG >= 8) {
            a((byte) (this.eTF & MotionEventCompat.ACTION_MASK), outputStream);
            this.eTF >>= 8;
            this.eTG -= 8;
        }
        if (this.eTA > this.eTv || this.eTB) {
            if (this.eTB) {
                int i2 = this.eTC;
                this.eTt = i2;
                this.eTv = pF(i2);
                this.eTB = false;
            } else {
                this.eTt++;
                if (this.eTt == this.eTu) {
                    this.eTv = this.eTw;
                } else {
                    this.eTv = pF(this.eTt);
                }
            }
        }
        if (i == this.eTE) {
            while (this.eTG > 0) {
                a((byte) (this.eTF & MotionEventCompat.ACTION_MASK), outputStream);
                this.eTF >>= 8;
                this.eTG -= 8;
            }
            g(outputStream);
        }
    }
}
