package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    int eNB;
    int eNC;
    int eND;
    int eNH;
    private int eNm;
    private int eNn;
    private byte[] eNo;
    private int eNp;
    private int eNq;
    private int eNr;
    int eNs;
    int eNu;
    int eNt = 12;
    int eNv = 4096;
    int[] eNw = new int[5003];
    int[] eNx = new int[5003];
    int eNy = 5003;
    int eNz = 0;
    boolean eNA = false;
    int eNE = 0;
    int eNF = 0;
    int[] eNG = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eNI = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eNm = i;
        this.eNn = i2;
        this.eNo = bArr;
        this.eNp = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eNI;
        int i = this.eNH;
        this.eNH = i + 1;
        bArr[i] = b;
        if (this.eNH >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        pA(this.eNy);
        this.eNz = this.eNC + 2;
        this.eNA = true;
        b(this.eNC, outputStream);
    }

    void pA(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eNw[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eNB = i;
        this.eNA = false;
        this.eNs = this.eNB;
        this.eNu = pB(this.eNs);
        this.eNC = 1 << (i - 1);
        this.eND = this.eNC + 1;
        this.eNz = this.eNC + 2;
        this.eNH = 0;
        int aSu = aSu();
        for (int i3 = this.eNy; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eNy;
        pA(i5);
        b(this.eNC, outputStream);
        while (true) {
            int aSu2 = aSu();
            if (aSu2 != -1) {
                int i6 = (aSu2 << this.eNt) + aSu;
                int i7 = (aSu2 << i4) ^ aSu;
                if (this.eNw[i7] == i6) {
                    aSu = this.eNx[i7];
                } else {
                    if (this.eNw[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eNw[i7] == i6) {
                                aSu = this.eNx[i7];
                                break;
                            }
                        } while (this.eNw[i7] >= 0);
                    }
                    b(aSu, outputStream);
                    if (this.eNz < this.eNv) {
                        int[] iArr = this.eNx;
                        int i9 = this.eNz;
                        this.eNz = i9 + 1;
                        iArr[i7] = i9;
                        this.eNw[i7] = i6;
                        aSu = aSu2;
                    } else {
                        e(outputStream);
                        aSu = aSu2;
                    }
                }
            } else {
                b(aSu, outputStream);
                b(this.eND, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eNp);
        this.eNq = this.eNm * this.eNn;
        this.eNr = 0;
        a(this.eNp + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.eNH > 0) {
            outputStream.write(this.eNH);
            outputStream.write(this.eNI, 0, this.eNH);
            this.eNH = 0;
        }
    }

    final int pB(int i) {
        return (1 << i) - 1;
    }

    private int aSu() {
        if (this.eNq == 0) {
            return -1;
        }
        this.eNq--;
        byte[] bArr = this.eNo;
        int i = this.eNr;
        this.eNr = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.eNE &= this.eNG[this.eNF];
        if (this.eNF > 0) {
            this.eNE |= i << this.eNF;
        } else {
            this.eNE = i;
        }
        this.eNF += this.eNs;
        while (this.eNF >= 8) {
            a((byte) (this.eNE & MotionEventCompat.ACTION_MASK), outputStream);
            this.eNE >>= 8;
            this.eNF -= 8;
        }
        if (this.eNz > this.eNu || this.eNA) {
            if (this.eNA) {
                int i2 = this.eNB;
                this.eNs = i2;
                this.eNu = pB(i2);
                this.eNA = false;
            } else {
                this.eNs++;
                if (this.eNs == this.eNt) {
                    this.eNu = this.eNv;
                } else {
                    this.eNu = pB(this.eNs);
                }
            }
        }
        if (i == this.eND) {
            while (this.eNF > 0) {
                a((byte) (this.eNE & MotionEventCompat.ACTION_MASK), outputStream);
                this.eNE >>= 8;
                this.eNF -= 8;
            }
            f(outputStream);
        }
    }
}
