package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    private int iae;
    private int iaf;
    private byte[] iag;
    private int iah;
    private int iai;
    private int iaj;
    int iak;
    int iam;
    int iat;
    int iau;
    int iav;
    int iaz;
    int ial = 12;
    int ian = 4096;
    int[] iao = new int[5003];
    int[] iap = new int[5003];
    int iaq = 5003;
    int iar = 0;
    boolean ias = false;
    int iaw = 0;
    int iax = 0;
    int[] iay = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] iaA = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.iae = i;
        this.iaf = i2;
        this.iag = bArr;
        this.iah = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.iaA;
        int i = this.iaz;
        this.iaz = i + 1;
        bArr[i] = b;
        if (this.iaz >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        xU(this.iaq);
        this.iar = this.iau + 2;
        this.ias = true;
        b(this.iau, outputStream);
    }

    void xU(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.iao[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.iat = i;
        this.ias = false;
        this.iak = this.iat;
        this.iam = xV(this.iak);
        this.iau = 1 << (i - 1);
        this.iav = this.iau + 1;
        this.iar = this.iau + 2;
        this.iaz = 0;
        int bXG = bXG();
        for (int i3 = this.iaq; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.iaq;
        xU(i5);
        b(this.iau, outputStream);
        while (true) {
            int bXG2 = bXG();
            if (bXG2 != -1) {
                int i6 = (bXG2 << this.ial) + bXG;
                int i7 = (bXG2 << i4) ^ bXG;
                if (this.iao[i7] == i6) {
                    bXG = this.iap[i7];
                } else {
                    if (this.iao[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.iao[i7] == i6) {
                                bXG = this.iap[i7];
                                break;
                            }
                        } while (this.iao[i7] >= 0);
                    }
                    b(bXG, outputStream);
                    if (this.iar < this.ian) {
                        int[] iArr = this.iap;
                        int i9 = this.iar;
                        this.iar = i9 + 1;
                        iArr[i7] = i9;
                        this.iao[i7] = i6;
                        bXG = bXG2;
                    } else {
                        e(outputStream);
                        bXG = bXG2;
                    }
                }
            } else {
                b(bXG, outputStream);
                b(this.iav, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.iah);
        this.iai = this.iae * this.iaf;
        this.iaj = 0;
        a(this.iah + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.iaz > 0) {
            outputStream.write(this.iaz);
            outputStream.write(this.iaA, 0, this.iaz);
            this.iaz = 0;
        }
    }

    final int xV(int i) {
        return (1 << i) - 1;
    }

    private int bXG() {
        if (this.iai == 0) {
            return -1;
        }
        this.iai--;
        byte[] bArr = this.iag;
        int i = this.iaj;
        this.iaj = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.iaw &= this.iay[this.iax];
        if (this.iax > 0) {
            this.iaw |= i << this.iax;
        } else {
            this.iaw = i;
        }
        this.iax += this.iak;
        while (this.iax >= 8) {
            a((byte) (this.iaw & 255), outputStream);
            this.iaw >>= 8;
            this.iax -= 8;
        }
        if (this.iar > this.iam || this.ias) {
            if (this.ias) {
                int i2 = this.iat;
                this.iak = i2;
                this.iam = xV(i2);
                this.ias = false;
            } else {
                this.iak++;
                if (this.iak == this.ial) {
                    this.iam = this.ian;
                } else {
                    this.iam = xV(this.iak);
                }
            }
        }
        if (i == this.iav) {
            while (this.iax > 0) {
                a((byte) (this.iaw & 255), outputStream);
                this.iaw >>= 8;
                this.iax -= 8;
            }
            f(outputStream);
        }
    }
}
