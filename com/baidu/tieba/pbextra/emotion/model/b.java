package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.android.imsdk.ResponseCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    int iiA;
    int iiB;
    int iiC;
    int iiG;
    private int iil;
    private int iim;
    private byte[] iin;
    private int iio;
    private int iip;
    private int iiq;
    int iir;
    int iit;
    int iis = 12;
    int iiu = 4096;
    int[] iiv = new int[5003];
    int[] iiw = new int[5003];
    int iix = 5003;
    int iiy = 0;
    boolean iiz = false;
    int iiD = 0;
    int iiE = 0;
    int[] iiF = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] iiH = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.iil = i;
        this.iim = i2;
        this.iin = bArr;
        this.iio = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.iiH;
        int i = this.iiG;
        this.iiG = i + 1;
        bArr[i] = b;
        if (this.iiG >= 254) {
            e(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        xj(this.iix);
        this.iiy = this.iiB + 2;
        this.iiz = true;
        b(this.iiB, outputStream);
    }

    void xj(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.iiv[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.iiA = i;
        this.iiz = false;
        this.iir = this.iiA;
        this.iit = xk(this.iir);
        this.iiB = 1 << (i - 1);
        this.iiC = this.iiB + 1;
        this.iiy = this.iiB + 2;
        this.iiG = 0;
        int bYH = bYH();
        for (int i3 = this.iix; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.iix;
        xj(i5);
        b(this.iiB, outputStream);
        while (true) {
            int bYH2 = bYH();
            if (bYH2 != -1) {
                int i6 = (bYH2 << this.iis) + bYH;
                int i7 = (bYH2 << i4) ^ bYH;
                if (this.iiv[i7] == i6) {
                    bYH = this.iiw[i7];
                } else {
                    if (this.iiv[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.iiv[i7] == i6) {
                                bYH = this.iiw[i7];
                                break;
                            }
                        } while (this.iiv[i7] >= 0);
                    }
                    b(bYH, outputStream);
                    if (this.iiy < this.iiu) {
                        int[] iArr = this.iiw;
                        int i9 = this.iiy;
                        this.iiy = i9 + 1;
                        iArr[i7] = i9;
                        this.iiv[i7] = i6;
                        bYH = bYH2;
                    } else {
                        c(outputStream);
                        bYH = bYH2;
                    }
                }
            } else {
                b(bYH, outputStream);
                b(this.iiC, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(OutputStream outputStream) throws IOException {
        outputStream.write(this.iio);
        this.iip = this.iil * this.iim;
        this.iiq = 0;
        a(this.iio + 1, outputStream);
        outputStream.write(0);
    }

    void e(OutputStream outputStream) throws IOException {
        if (this.iiG > 0) {
            outputStream.write(this.iiG);
            outputStream.write(this.iiH, 0, this.iiG);
            this.iiG = 0;
        }
    }

    final int xk(int i) {
        return (1 << i) - 1;
    }

    private int bYH() {
        if (this.iip == 0) {
            return -1;
        }
        this.iip--;
        byte[] bArr = this.iin;
        int i = this.iiq;
        this.iiq = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.iiD &= this.iiF[this.iiE];
        if (this.iiE > 0) {
            this.iiD |= i << this.iiE;
        } else {
            this.iiD = i;
        }
        this.iiE += this.iir;
        while (this.iiE >= 8) {
            a((byte) (this.iiD & 255), outputStream);
            this.iiD >>= 8;
            this.iiE -= 8;
        }
        if (this.iiy > this.iit || this.iiz) {
            if (this.iiz) {
                int i2 = this.iiA;
                this.iir = i2;
                this.iit = xk(i2);
                this.iiz = false;
            } else {
                this.iir++;
                if (this.iir == this.iis) {
                    this.iit = this.iiu;
                } else {
                    this.iit = xk(this.iir);
                }
            }
        }
        if (i == this.iiC) {
            while (this.iiE > 0) {
                a((byte) (this.iiD & 255), outputStream);
                this.iiD >>= 8;
                this.iiE -= 8;
            }
            e(outputStream);
        }
    }
}
