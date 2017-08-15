package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    private int eTQ;
    private int eTR;
    private byte[] eTS;
    private int eTT;
    private int eTU;
    private int eTV;
    int eTW;
    int eTY;
    int eUf;
    int eUg;
    int eUh;
    int eUl;
    int eTX = 12;
    int eTZ = 4096;
    int[] eUa = new int[5003];
    int[] eUb = new int[5003];
    int eUc = 5003;
    int eUd = 0;
    boolean eUe = false;
    int eUi = 0;
    int eUj = 0;
    int[] eUk = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eUm = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eTQ = i;
        this.eTR = i2;
        this.eTS = bArr;
        this.eTT = Math.max(2, i3);
    }

    void b(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eUm;
        int i = this.eUl;
        this.eUl = i + 1;
        bArr[i] = b;
        if (this.eUl >= 254) {
            j(outputStream);
        }
    }

    void i(OutputStream outputStream) throws IOException {
        py(this.eUc);
        this.eUd = this.eUg + 2;
        this.eUe = true;
        d(this.eUg, outputStream);
    }

    void py(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eUa[i2] = -1;
        }
    }

    void c(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eUf = i;
        this.eUe = false;
        this.eTW = this.eUf;
        this.eTY = pz(this.eTW);
        this.eUg = 1 << (i - 1);
        this.eUh = this.eUg + 1;
        this.eUd = this.eUg + 2;
        this.eUl = 0;
        int aUU = aUU();
        for (int i3 = this.eUc; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eUc;
        py(i5);
        d(this.eUg, outputStream);
        while (true) {
            int aUU2 = aUU();
            if (aUU2 != -1) {
                int i6 = (aUU2 << this.eTX) + aUU;
                int i7 = (aUU2 << i4) ^ aUU;
                if (this.eUa[i7] == i6) {
                    aUU = this.eUb[i7];
                } else {
                    if (this.eUa[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eUa[i7] == i6) {
                                aUU = this.eUb[i7];
                                break;
                            }
                        } while (this.eUa[i7] >= 0);
                    }
                    d(aUU, outputStream);
                    if (this.eUd < this.eTZ) {
                        int[] iArr = this.eUb;
                        int i9 = this.eUd;
                        this.eUd = i9 + 1;
                        iArr[i7] = i9;
                        this.eUa[i7] = i6;
                        aUU = aUU2;
                    } else {
                        i(outputStream);
                        aUU = aUU2;
                    }
                }
            } else {
                d(aUU, outputStream);
                d(this.eUh, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eTT);
        this.eTU = this.eTQ * this.eTR;
        this.eTV = 0;
        c(this.eTT + 1, outputStream);
        outputStream.write(0);
    }

    void j(OutputStream outputStream) throws IOException {
        if (this.eUl > 0) {
            outputStream.write(this.eUl);
            outputStream.write(this.eUm, 0, this.eUl);
            this.eUl = 0;
        }
    }

    final int pz(int i) {
        return (1 << i) - 1;
    }

    private int aUU() {
        if (this.eTU == 0) {
            return -1;
        }
        this.eTU--;
        byte[] bArr = this.eTS;
        int i = this.eTV;
        this.eTV = i + 1;
        return bArr[i] & 255;
    }

    void d(int i, OutputStream outputStream) throws IOException {
        this.eUi &= this.eUk[this.eUj];
        if (this.eUj > 0) {
            this.eUi |= i << this.eUj;
        } else {
            this.eUi = i;
        }
        this.eUj += this.eTW;
        while (this.eUj >= 8) {
            b((byte) (this.eUi & MotionEventCompat.ACTION_MASK), outputStream);
            this.eUi >>= 8;
            this.eUj -= 8;
        }
        if (this.eUd > this.eTY || this.eUe) {
            if (this.eUe) {
                int i2 = this.eUf;
                this.eTW = i2;
                this.eTY = pz(i2);
                this.eUe = false;
            } else {
                this.eTW++;
                if (this.eTW == this.eTX) {
                    this.eTY = this.eTZ;
                } else {
                    this.eTY = pz(this.eTW);
                }
            }
        }
        if (i == this.eUh) {
            while (this.eUj > 0) {
                b((byte) (this.eUi & MotionEventCompat.ACTION_MASK), outputStream);
                this.eUi >>= 8;
                this.eUj -= 8;
            }
            j(outputStream);
        }
    }
}
