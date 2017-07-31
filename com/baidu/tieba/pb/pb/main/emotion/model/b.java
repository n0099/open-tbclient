package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    private int eRX;
    private int eRY;
    private byte[] eRZ;
    private int eSa;
    private int eSb;
    private int eSc;
    int eSd;
    int eSf;
    int eSm;
    int eSn;
    int eSo;
    int eSs;
    int eSe = 12;
    int eSg = 4096;
    int[] eSh = new int[5003];
    int[] eSi = new int[5003];
    int eSj = 5003;
    int eSk = 0;
    boolean eSl = false;
    int eSp = 0;
    int eSq = 0;
    int[] eSr = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eSt = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eRX = i;
        this.eRY = i2;
        this.eRZ = bArr;
        this.eSa = Math.max(2, i3);
    }

    void b(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eSt;
        int i = this.eSs;
        this.eSs = i + 1;
        bArr[i] = b;
        if (this.eSs >= 254) {
            j(outputStream);
        }
    }

    void i(OutputStream outputStream) throws IOException {
        po(this.eSj);
        this.eSk = this.eSn + 2;
        this.eSl = true;
        d(this.eSn, outputStream);
    }

    void po(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eSh[i2] = -1;
        }
    }

    void c(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eSm = i;
        this.eSl = false;
        this.eSd = this.eSm;
        this.eSf = pp(this.eSd);
        this.eSn = 1 << (i - 1);
        this.eSo = this.eSn + 1;
        this.eSk = this.eSn + 2;
        this.eSs = 0;
        int aUn = aUn();
        for (int i3 = this.eSj; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eSj;
        po(i5);
        d(this.eSn, outputStream);
        while (true) {
            int aUn2 = aUn();
            if (aUn2 != -1) {
                int i6 = (aUn2 << this.eSe) + aUn;
                int i7 = (aUn2 << i4) ^ aUn;
                if (this.eSh[i7] == i6) {
                    aUn = this.eSi[i7];
                } else {
                    if (this.eSh[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eSh[i7] == i6) {
                                aUn = this.eSi[i7];
                                break;
                            }
                        } while (this.eSh[i7] >= 0);
                    }
                    d(aUn, outputStream);
                    if (this.eSk < this.eSg) {
                        int[] iArr = this.eSi;
                        int i9 = this.eSk;
                        this.eSk = i9 + 1;
                        iArr[i7] = i9;
                        this.eSh[i7] = i6;
                        aUn = aUn2;
                    } else {
                        i(outputStream);
                        aUn = aUn2;
                    }
                }
            } else {
                d(aUn, outputStream);
                d(this.eSo, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eSa);
        this.eSb = this.eRX * this.eRY;
        this.eSc = 0;
        c(this.eSa + 1, outputStream);
        outputStream.write(0);
    }

    void j(OutputStream outputStream) throws IOException {
        if (this.eSs > 0) {
            outputStream.write(this.eSs);
            outputStream.write(this.eSt, 0, this.eSs);
            this.eSs = 0;
        }
    }

    final int pp(int i) {
        return (1 << i) - 1;
    }

    private int aUn() {
        if (this.eSb == 0) {
            return -1;
        }
        this.eSb--;
        byte[] bArr = this.eRZ;
        int i = this.eSc;
        this.eSc = i + 1;
        return bArr[i] & 255;
    }

    void d(int i, OutputStream outputStream) throws IOException {
        this.eSp &= this.eSr[this.eSq];
        if (this.eSq > 0) {
            this.eSp |= i << this.eSq;
        } else {
            this.eSp = i;
        }
        this.eSq += this.eSd;
        while (this.eSq >= 8) {
            b((byte) (this.eSp & MotionEventCompat.ACTION_MASK), outputStream);
            this.eSp >>= 8;
            this.eSq -= 8;
        }
        if (this.eSk > this.eSf || this.eSl) {
            if (this.eSl) {
                int i2 = this.eSm;
                this.eSd = i2;
                this.eSf = pp(i2);
                this.eSl = false;
            } else {
                this.eSd++;
                if (this.eSd == this.eSe) {
                    this.eSf = this.eSg;
                } else {
                    this.eSf = pp(this.eSd);
                }
            }
        }
        if (i == this.eSo) {
            while (this.eSq > 0) {
                b((byte) (this.eSp & MotionEventCompat.ACTION_MASK), outputStream);
                this.eSp >>= 8;
                this.eSq -= 8;
            }
            j(outputStream);
        }
    }
}
