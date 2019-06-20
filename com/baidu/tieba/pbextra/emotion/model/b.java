package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    int iaD;
    private int iai;
    private int iaj;
    private byte[] iak;
    private int ial;
    private int iam;
    private int ian;
    int iao;
    int iaq;
    int iax;
    int iay;
    int iaz;
    int iap = 12;
    int iar = 4096;
    int[] ias = new int[5003];
    int[] iat = new int[5003];
    int iau = 5003;
    int iav = 0;
    boolean iaw = false;
    int iaA = 0;
    int iaB = 0;
    int[] iaC = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] iaE = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.iai = i;
        this.iaj = i2;
        this.iak = bArr;
        this.ial = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.iaE;
        int i = this.iaD;
        this.iaD = i + 1;
        bArr[i] = b;
        if (this.iaD >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        xU(this.iau);
        this.iav = this.iay + 2;
        this.iaw = true;
        b(this.iay, outputStream);
    }

    void xU(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ias[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.iax = i;
        this.iaw = false;
        this.iao = this.iax;
        this.iaq = xV(this.iao);
        this.iay = 1 << (i - 1);
        this.iaz = this.iay + 1;
        this.iav = this.iay + 2;
        this.iaD = 0;
        int bXK = bXK();
        for (int i3 = this.iau; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.iau;
        xU(i5);
        b(this.iay, outputStream);
        while (true) {
            int bXK2 = bXK();
            if (bXK2 != -1) {
                int i6 = (bXK2 << this.iap) + bXK;
                int i7 = (bXK2 << i4) ^ bXK;
                if (this.ias[i7] == i6) {
                    bXK = this.iat[i7];
                } else {
                    if (this.ias[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ias[i7] == i6) {
                                bXK = this.iat[i7];
                                break;
                            }
                        } while (this.ias[i7] >= 0);
                    }
                    b(bXK, outputStream);
                    if (this.iav < this.iar) {
                        int[] iArr = this.iat;
                        int i9 = this.iav;
                        this.iav = i9 + 1;
                        iArr[i7] = i9;
                        this.ias[i7] = i6;
                        bXK = bXK2;
                    } else {
                        e(outputStream);
                        bXK = bXK2;
                    }
                }
            } else {
                b(bXK, outputStream);
                b(this.iaz, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.ial);
        this.iam = this.iai * this.iaj;
        this.ian = 0;
        a(this.ial + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.iaD > 0) {
            outputStream.write(this.iaD);
            outputStream.write(this.iaE, 0, this.iaD);
            this.iaD = 0;
        }
    }

    final int xV(int i) {
        return (1 << i) - 1;
    }

    private int bXK() {
        if (this.iam == 0) {
            return -1;
        }
        this.iam--;
        byte[] bArr = this.iak;
        int i = this.ian;
        this.ian = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.iaA &= this.iaC[this.iaB];
        if (this.iaB > 0) {
            this.iaA |= i << this.iaB;
        } else {
            this.iaA = i;
        }
        this.iaB += this.iao;
        while (this.iaB >= 8) {
            a((byte) (this.iaA & 255), outputStream);
            this.iaA >>= 8;
            this.iaB -= 8;
        }
        if (this.iav > this.iaq || this.iaw) {
            if (this.iaw) {
                int i2 = this.iax;
                this.iao = i2;
                this.iaq = xV(i2);
                this.iaw = false;
            } else {
                this.iao++;
                if (this.iao == this.iap) {
                    this.iaq = this.iar;
                } else {
                    this.iaq = xV(this.iao);
                }
            }
        }
        if (i == this.iaz) {
            while (this.iaB > 0) {
                a((byte) (this.iaA & 255), outputStream);
                this.iaA >>= 8;
                this.iaB -= 8;
            }
            f(outputStream);
        }
    }
}
