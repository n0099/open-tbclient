package com.baidu.tieba.pbextra.emotion.model;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
class b {
    int mhB;
    private int mhg;
    private int mhh;
    private byte[] mhi;
    private int mhj;
    private int mhk;
    private int mhl;
    int mhm;
    int mho;
    int mhv;
    int mhw;
    int mhx;
    int mhn = 12;
    int mhp = 4096;
    int[] mhq = new int[5003];
    int[] mhr = new int[5003];
    int mhs = 5003;
    int mht = 0;
    boolean mhu = false;
    int mhy = 0;
    int mhz = 0;
    int[] mhA = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] mhC = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mhg = i;
        this.mhh = i2;
        this.mhi = bArr;
        this.mhj = Math.max(2, i3);
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mhC;
        int i = this.mhB;
        this.mhB = i + 1;
        bArr[i] = b2;
        if (this.mhB >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Gn(this.mhs);
        this.mht = this.mhw + 2;
        this.mhu = true;
        b(this.mhw, outputStream);
    }

    void Gn(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mhq[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mhv = i;
        this.mhu = false;
        this.mhm = this.mhv;
        this.mho = Go(this.mhm);
        this.mhw = 1 << (i - 1);
        this.mhx = this.mhw + 1;
        this.mht = this.mhw + 2;
        this.mhB = 0;
        int dtJ = dtJ();
        for (int i3 = this.mhs; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mhs;
        Gn(i5);
        b(this.mhw, outputStream);
        while (true) {
            int dtJ2 = dtJ();
            if (dtJ2 != -1) {
                int i6 = (dtJ2 << this.mhn) + dtJ;
                int i7 = (dtJ2 << i4) ^ dtJ;
                if (this.mhq[i7] == i6) {
                    dtJ = this.mhr[i7];
                } else {
                    if (this.mhq[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mhq[i7] == i6) {
                                dtJ = this.mhr[i7];
                                break;
                            }
                        } while (this.mhq[i7] >= 0);
                    }
                    b(dtJ, outputStream);
                    if (this.mht < this.mhp) {
                        int[] iArr = this.mhr;
                        int i9 = this.mht;
                        this.mht = i9 + 1;
                        iArr[i7] = i9;
                        this.mhq[i7] = i6;
                        dtJ = dtJ2;
                    } else {
                        c(outputStream);
                        dtJ = dtJ2;
                    }
                }
            } else {
                b(dtJ, outputStream);
                b(this.mhx, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mhj);
        this.mhk = this.mhg * this.mhh;
        this.mhl = 0;
        a(this.mhj + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mhB > 0) {
            outputStream.write(this.mhB);
            outputStream.write(this.mhC, 0, this.mhB);
            this.mhB = 0;
        }
    }

    final int Go(int i) {
        return (1 << i) - 1;
    }

    private int dtJ() {
        if (this.mhk == 0) {
            return -1;
        }
        this.mhk--;
        byte[] bArr = this.mhi;
        int i = this.mhl;
        this.mhl = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mhy &= this.mhA[this.mhz];
        if (this.mhz > 0) {
            this.mhy |= i << this.mhz;
        } else {
            this.mhy = i;
        }
        this.mhz += this.mhm;
        while (this.mhz >= 8) {
            a((byte) (this.mhy & 255), outputStream);
            this.mhy >>= 8;
            this.mhz -= 8;
        }
        if (this.mht > this.mho || this.mhu) {
            if (this.mhu) {
                int i2 = this.mhv;
                this.mhm = i2;
                this.mho = Go(i2);
                this.mhu = false;
            } else {
                this.mhm++;
                if (this.mhm == this.mhn) {
                    this.mho = this.mhp;
                } else {
                    this.mho = Go(this.mhm);
                }
            }
        }
        if (i == this.mhx) {
            while (this.mhz > 0) {
                a((byte) (this.mhy & 255), outputStream);
                this.mhy >>= 8;
                this.mhz -= 8;
            }
            d(outputStream);
        }
    }
}
