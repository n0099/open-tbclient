package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    private int eTS;
    private int eTT;
    private byte[] eTU;
    private int eTV;
    private int eTW;
    private int eTX;
    int eTY;
    int eUa;
    int eUh;
    int eUi;
    int eUj;
    int eUn;
    int eTZ = 12;
    int eUb = 4096;
    int[] eUc = new int[5003];
    int[] eUd = new int[5003];
    int eUe = 5003;
    int eUf = 0;
    boolean eUg = false;
    int eUk = 0;
    int eUl = 0;
    int[] eUm = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eUo = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eTS = i;
        this.eTT = i2;
        this.eTU = bArr;
        this.eTV = Math.max(2, i3);
    }

    void b(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eUo;
        int i = this.eUn;
        this.eUn = i + 1;
        bArr[i] = b;
        if (this.eUn >= 254) {
            j(outputStream);
        }
    }

    void i(OutputStream outputStream) throws IOException {
        py(this.eUe);
        this.eUf = this.eUi + 2;
        this.eUg = true;
        d(this.eUi, outputStream);
    }

    void py(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eUc[i2] = -1;
        }
    }

    void c(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eUh = i;
        this.eUg = false;
        this.eTY = this.eUh;
        this.eUa = pz(this.eTY);
        this.eUi = 1 << (i - 1);
        this.eUj = this.eUi + 1;
        this.eUf = this.eUi + 2;
        this.eUn = 0;
        int aUP = aUP();
        for (int i3 = this.eUe; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eUe;
        py(i5);
        d(this.eUi, outputStream);
        while (true) {
            int aUP2 = aUP();
            if (aUP2 != -1) {
                int i6 = (aUP2 << this.eTZ) + aUP;
                int i7 = (aUP2 << i4) ^ aUP;
                if (this.eUc[i7] == i6) {
                    aUP = this.eUd[i7];
                } else {
                    if (this.eUc[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eUc[i7] == i6) {
                                aUP = this.eUd[i7];
                                break;
                            }
                        } while (this.eUc[i7] >= 0);
                    }
                    d(aUP, outputStream);
                    if (this.eUf < this.eUb) {
                        int[] iArr = this.eUd;
                        int i9 = this.eUf;
                        this.eUf = i9 + 1;
                        iArr[i7] = i9;
                        this.eUc[i7] = i6;
                        aUP = aUP2;
                    } else {
                        i(outputStream);
                        aUP = aUP2;
                    }
                }
            } else {
                d(aUP, outputStream);
                d(this.eUj, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eTV);
        this.eTW = this.eTS * this.eTT;
        this.eTX = 0;
        c(this.eTV + 1, outputStream);
        outputStream.write(0);
    }

    void j(OutputStream outputStream) throws IOException {
        if (this.eUn > 0) {
            outputStream.write(this.eUn);
            outputStream.write(this.eUo, 0, this.eUn);
            this.eUn = 0;
        }
    }

    final int pz(int i) {
        return (1 << i) - 1;
    }

    private int aUP() {
        if (this.eTW == 0) {
            return -1;
        }
        this.eTW--;
        byte[] bArr = this.eTU;
        int i = this.eTX;
        this.eTX = i + 1;
        return bArr[i] & 255;
    }

    void d(int i, OutputStream outputStream) throws IOException {
        this.eUk &= this.eUm[this.eUl];
        if (this.eUl > 0) {
            this.eUk |= i << this.eUl;
        } else {
            this.eUk = i;
        }
        this.eUl += this.eTY;
        while (this.eUl >= 8) {
            b((byte) (this.eUk & MotionEventCompat.ACTION_MASK), outputStream);
            this.eUk >>= 8;
            this.eUl -= 8;
        }
        if (this.eUf > this.eUa || this.eUg) {
            if (this.eUg) {
                int i2 = this.eUh;
                this.eTY = i2;
                this.eUa = pz(i2);
                this.eUg = false;
            } else {
                this.eTY++;
                if (this.eTY == this.eTZ) {
                    this.eUa = this.eUb;
                } else {
                    this.eUa = pz(this.eTY);
                }
            }
        }
        if (i == this.eUj) {
            while (this.eUl > 0) {
                b((byte) (this.eUk & MotionEventCompat.ACTION_MASK), outputStream);
                this.eUk >>= 8;
                this.eUl -= 8;
            }
            j(outputStream);
        }
    }
}
