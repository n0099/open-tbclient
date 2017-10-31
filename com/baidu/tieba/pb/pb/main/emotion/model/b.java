package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    private int eVS;
    private int eVT;
    private byte[] eVU;
    private int eVV;
    private int eVW;
    private int eVX;
    int eVY;
    int eWa;
    int eWh;
    int eWi;
    int eWj;
    int eWn;
    int eVZ = 12;
    int eWb = 4096;
    int[] eWc = new int[5003];
    int[] eWd = new int[5003];
    int eWe = 5003;
    int eWf = 0;
    boolean eWg = false;
    int eWk = 0;
    int eWl = 0;
    int[] eWm = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eWo = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eVS = i;
        this.eVT = i2;
        this.eVU = bArr;
        this.eVV = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eWo;
        int i = this.eWn;
        this.eWn = i + 1;
        bArr[i] = b;
        if (this.eWn >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        pT(this.eWe);
        this.eWf = this.eWi + 2;
        this.eWg = true;
        b(this.eWi, outputStream);
    }

    void pT(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eWc[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eWh = i;
        this.eWg = false;
        this.eVY = this.eWh;
        this.eWa = pU(this.eVY);
        this.eWi = 1 << (i - 1);
        this.eWj = this.eWi + 1;
        this.eWf = this.eWi + 2;
        this.eWn = 0;
        int aVD = aVD();
        for (int i3 = this.eWe; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eWe;
        pT(i5);
        b(this.eWi, outputStream);
        while (true) {
            int aVD2 = aVD();
            if (aVD2 != -1) {
                int i6 = (aVD2 << this.eVZ) + aVD;
                int i7 = (aVD2 << i4) ^ aVD;
                if (this.eWc[i7] == i6) {
                    aVD = this.eWd[i7];
                } else {
                    if (this.eWc[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eWc[i7] == i6) {
                                aVD = this.eWd[i7];
                                break;
                            }
                        } while (this.eWc[i7] >= 0);
                    }
                    b(aVD, outputStream);
                    if (this.eWf < this.eWb) {
                        int[] iArr = this.eWd;
                        int i9 = this.eWf;
                        this.eWf = i9 + 1;
                        iArr[i7] = i9;
                        this.eWc[i7] = i6;
                        aVD = aVD2;
                    } else {
                        e(outputStream);
                        aVD = aVD2;
                    }
                }
            } else {
                b(aVD, outputStream);
                b(this.eWj, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eVV);
        this.eVW = this.eVS * this.eVT;
        this.eVX = 0;
        a(this.eVV + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.eWn > 0) {
            outputStream.write(this.eWn);
            outputStream.write(this.eWo, 0, this.eWn);
            this.eWn = 0;
        }
    }

    final int pU(int i) {
        return (1 << i) - 1;
    }

    private int aVD() {
        if (this.eVW == 0) {
            return -1;
        }
        this.eVW--;
        byte[] bArr = this.eVU;
        int i = this.eVX;
        this.eVX = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.eWk &= this.eWm[this.eWl];
        if (this.eWl > 0) {
            this.eWk |= i << this.eWl;
        } else {
            this.eWk = i;
        }
        this.eWl += this.eVY;
        while (this.eWl >= 8) {
            a((byte) (this.eWk & MotionEventCompat.ACTION_MASK), outputStream);
            this.eWk >>= 8;
            this.eWl -= 8;
        }
        if (this.eWf > this.eWa || this.eWg) {
            if (this.eWg) {
                int i2 = this.eWh;
                this.eVY = i2;
                this.eWa = pU(i2);
                this.eWg = false;
            } else {
                this.eVY++;
                if (this.eVY == this.eVZ) {
                    this.eWa = this.eWb;
                } else {
                    this.eWa = pU(this.eVY);
                }
            }
        }
        if (i == this.eWj) {
            while (this.eWl > 0) {
                a((byte) (this.eWk & MotionEventCompat.ACTION_MASK), outputStream);
                this.eWk >>= 8;
                this.eWl -= 8;
            }
            f(outputStream);
        }
    }
}
