package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    int iaC;
    private int iah;
    private int iai;
    private byte[] iaj;
    private int iak;
    private int ial;
    private int iam;
    int ian;
    int iap;
    int iaw;
    int iax;
    int iay;
    int iao = 12;
    int iaq = 4096;
    int[] iar = new int[5003];
    int[] ias = new int[5003];
    int iat = 5003;
    int iau = 0;
    boolean iav = false;
    int iaz = 0;
    int iaA = 0;
    int[] iaB = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] iaD = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.iah = i;
        this.iai = i2;
        this.iaj = bArr;
        this.iak = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.iaD;
        int i = this.iaC;
        this.iaC = i + 1;
        bArr[i] = b;
        if (this.iaC >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        xU(this.iat);
        this.iau = this.iax + 2;
        this.iav = true;
        b(this.iax, outputStream);
    }

    void xU(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.iar[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.iaw = i;
        this.iav = false;
        this.ian = this.iaw;
        this.iap = xV(this.ian);
        this.iax = 1 << (i - 1);
        this.iay = this.iax + 1;
        this.iau = this.iax + 2;
        this.iaC = 0;
        int bXJ = bXJ();
        for (int i3 = this.iat; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.iat;
        xU(i5);
        b(this.iax, outputStream);
        while (true) {
            int bXJ2 = bXJ();
            if (bXJ2 != -1) {
                int i6 = (bXJ2 << this.iao) + bXJ;
                int i7 = (bXJ2 << i4) ^ bXJ;
                if (this.iar[i7] == i6) {
                    bXJ = this.ias[i7];
                } else {
                    if (this.iar[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.iar[i7] == i6) {
                                bXJ = this.ias[i7];
                                break;
                            }
                        } while (this.iar[i7] >= 0);
                    }
                    b(bXJ, outputStream);
                    if (this.iau < this.iaq) {
                        int[] iArr = this.ias;
                        int i9 = this.iau;
                        this.iau = i9 + 1;
                        iArr[i7] = i9;
                        this.iar[i7] = i6;
                        bXJ = bXJ2;
                    } else {
                        e(outputStream);
                        bXJ = bXJ2;
                    }
                }
            } else {
                b(bXJ, outputStream);
                b(this.iay, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.iak);
        this.ial = this.iah * this.iai;
        this.iam = 0;
        a(this.iak + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.iaC > 0) {
            outputStream.write(this.iaC);
            outputStream.write(this.iaD, 0, this.iaC);
            this.iaC = 0;
        }
    }

    final int xV(int i) {
        return (1 << i) - 1;
    }

    private int bXJ() {
        if (this.ial == 0) {
            return -1;
        }
        this.ial--;
        byte[] bArr = this.iaj;
        int i = this.iam;
        this.iam = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.iaz &= this.iaB[this.iaA];
        if (this.iaA > 0) {
            this.iaz |= i << this.iaA;
        } else {
            this.iaz = i;
        }
        this.iaA += this.ian;
        while (this.iaA >= 8) {
            a((byte) (this.iaz & 255), outputStream);
            this.iaz >>= 8;
            this.iaA -= 8;
        }
        if (this.iau > this.iap || this.iav) {
            if (this.iav) {
                int i2 = this.iaw;
                this.ian = i2;
                this.iap = xV(i2);
                this.iav = false;
            } else {
                this.ian++;
                if (this.ian == this.iao) {
                    this.iap = this.iaq;
                } else {
                    this.iap = xV(this.ian);
                }
            }
        }
        if (i == this.iay) {
            while (this.iaA > 0) {
                a((byte) (this.iaz & 255), outputStream);
                this.iaz >>= 8;
                this.iaA -= 8;
            }
            f(outputStream);
        }
    }
}
