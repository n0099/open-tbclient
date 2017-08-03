package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    private int eQK;
    private int eQL;
    private byte[] eQM;
    private int eQN;
    private int eQO;
    private int eQP;
    int eQQ;
    int eQS;
    int eQZ;
    int eRa;
    int eRb;
    int eRf;
    int eQR = 12;
    int eQT = 4096;
    int[] eQU = new int[5003];
    int[] eQV = new int[5003];
    int eQW = 5003;
    int eQX = 0;
    boolean eQY = false;
    int eRc = 0;
    int eRd = 0;
    int[] eRe = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eRg = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eQK = i;
        this.eQL = i2;
        this.eQM = bArr;
        this.eQN = Math.max(2, i3);
    }

    void b(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eRg;
        int i = this.eRf;
        this.eRf = i + 1;
        bArr[i] = b;
        if (this.eRf >= 254) {
            i(outputStream);
        }
    }

    void h(OutputStream outputStream) throws IOException {
        po(this.eQW);
        this.eQX = this.eRa + 2;
        this.eQY = true;
        d(this.eRa, outputStream);
    }

    void po(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eQU[i2] = -1;
        }
    }

    void c(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eQZ = i;
        this.eQY = false;
        this.eQQ = this.eQZ;
        this.eQS = pp(this.eQQ);
        this.eRa = 1 << (i - 1);
        this.eRb = this.eRa + 1;
        this.eQX = this.eRa + 2;
        this.eRf = 0;
        int aUc = aUc();
        for (int i3 = this.eQW; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eQW;
        po(i5);
        d(this.eRa, outputStream);
        while (true) {
            int aUc2 = aUc();
            if (aUc2 != -1) {
                int i6 = (aUc2 << this.eQR) + aUc;
                int i7 = (aUc2 << i4) ^ aUc;
                if (this.eQU[i7] == i6) {
                    aUc = this.eQV[i7];
                } else {
                    if (this.eQU[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eQU[i7] == i6) {
                                aUc = this.eQV[i7];
                                break;
                            }
                        } while (this.eQU[i7] >= 0);
                    }
                    d(aUc, outputStream);
                    if (this.eQX < this.eQT) {
                        int[] iArr = this.eQV;
                        int i9 = this.eQX;
                        this.eQX = i9 + 1;
                        iArr[i7] = i9;
                        this.eQU[i7] = i6;
                        aUc = aUc2;
                    } else {
                        h(outputStream);
                        aUc = aUc2;
                    }
                }
            } else {
                d(aUc, outputStream);
                d(this.eRb, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eQN);
        this.eQO = this.eQK * this.eQL;
        this.eQP = 0;
        c(this.eQN + 1, outputStream);
        outputStream.write(0);
    }

    void i(OutputStream outputStream) throws IOException {
        if (this.eRf > 0) {
            outputStream.write(this.eRf);
            outputStream.write(this.eRg, 0, this.eRf);
            this.eRf = 0;
        }
    }

    final int pp(int i) {
        return (1 << i) - 1;
    }

    private int aUc() {
        if (this.eQO == 0) {
            return -1;
        }
        this.eQO--;
        byte[] bArr = this.eQM;
        int i = this.eQP;
        this.eQP = i + 1;
        return bArr[i] & 255;
    }

    void d(int i, OutputStream outputStream) throws IOException {
        this.eRc &= this.eRe[this.eRd];
        if (this.eRd > 0) {
            this.eRc |= i << this.eRd;
        } else {
            this.eRc = i;
        }
        this.eRd += this.eQQ;
        while (this.eRd >= 8) {
            b((byte) (this.eRc & MotionEventCompat.ACTION_MASK), outputStream);
            this.eRc >>= 8;
            this.eRd -= 8;
        }
        if (this.eQX > this.eQS || this.eQY) {
            if (this.eQY) {
                int i2 = this.eQZ;
                this.eQQ = i2;
                this.eQS = pp(i2);
                this.eQY = false;
            } else {
                this.eQQ++;
                if (this.eQQ == this.eQR) {
                    this.eQS = this.eQT;
                } else {
                    this.eQS = pp(this.eQQ);
                }
            }
        }
        if (i == this.eRb) {
            while (this.eRd > 0) {
                b((byte) (this.eRc & MotionEventCompat.ACTION_MASK), outputStream);
                this.eRc >>= 8;
                this.eRd -= 8;
            }
            i(outputStream);
        }
    }
}
