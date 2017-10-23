package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    private int eMY;
    private int eMZ;
    private byte[] eNa;
    private int eNb;
    private int eNc;
    private int eNd;
    int eNe;
    int eNg;
    int eNn;
    int eNo;
    int eNp;
    int eNt;
    int eNf = 12;
    int eNh = 4096;
    int[] eNi = new int[5003];
    int[] eNj = new int[5003];
    int eNk = 5003;
    int eNl = 0;
    boolean eNm = false;
    int eNq = 0;
    int eNr = 0;
    int[] eNs = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eNu = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eMY = i;
        this.eMZ = i2;
        this.eNa = bArr;
        this.eNb = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eNu;
        int i = this.eNt;
        this.eNt = i + 1;
        bArr[i] = b;
        if (this.eNt >= 254) {
            f(outputStream);
        }
    }

    void e(OutputStream outputStream) throws IOException {
        pz(this.eNk);
        this.eNl = this.eNo + 2;
        this.eNm = true;
        b(this.eNo, outputStream);
    }

    void pz(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eNi[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eNn = i;
        this.eNm = false;
        this.eNe = this.eNn;
        this.eNg = pA(this.eNe);
        this.eNo = 1 << (i - 1);
        this.eNp = this.eNo + 1;
        this.eNl = this.eNo + 2;
        this.eNt = 0;
        int aSp = aSp();
        for (int i3 = this.eNk; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eNk;
        pz(i5);
        b(this.eNo, outputStream);
        while (true) {
            int aSp2 = aSp();
            if (aSp2 != -1) {
                int i6 = (aSp2 << this.eNf) + aSp;
                int i7 = (aSp2 << i4) ^ aSp;
                if (this.eNi[i7] == i6) {
                    aSp = this.eNj[i7];
                } else {
                    if (this.eNi[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eNi[i7] == i6) {
                                aSp = this.eNj[i7];
                                break;
                            }
                        } while (this.eNi[i7] >= 0);
                    }
                    b(aSp, outputStream);
                    if (this.eNl < this.eNh) {
                        int[] iArr = this.eNj;
                        int i9 = this.eNl;
                        this.eNl = i9 + 1;
                        iArr[i7] = i9;
                        this.eNi[i7] = i6;
                        aSp = aSp2;
                    } else {
                        e(outputStream);
                        aSp = aSp2;
                    }
                }
            } else {
                b(aSp, outputStream);
                b(this.eNp, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eNb);
        this.eNc = this.eMY * this.eMZ;
        this.eNd = 0;
        a(this.eNb + 1, outputStream);
        outputStream.write(0);
    }

    void f(OutputStream outputStream) throws IOException {
        if (this.eNt > 0) {
            outputStream.write(this.eNt);
            outputStream.write(this.eNu, 0, this.eNt);
            this.eNt = 0;
        }
    }

    final int pA(int i) {
        return (1 << i) - 1;
    }

    private int aSp() {
        if (this.eNc == 0) {
            return -1;
        }
        this.eNc--;
        byte[] bArr = this.eNa;
        int i = this.eNd;
        this.eNd = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.eNq &= this.eNs[this.eNr];
        if (this.eNr > 0) {
            this.eNq |= i << this.eNr;
        } else {
            this.eNq = i;
        }
        this.eNr += this.eNe;
        while (this.eNr >= 8) {
            a((byte) (this.eNq & MotionEventCompat.ACTION_MASK), outputStream);
            this.eNq >>= 8;
            this.eNr -= 8;
        }
        if (this.eNl > this.eNg || this.eNm) {
            if (this.eNm) {
                int i2 = this.eNn;
                this.eNe = i2;
                this.eNg = pA(i2);
                this.eNm = false;
            } else {
                this.eNe++;
                if (this.eNe == this.eNf) {
                    this.eNg = this.eNh;
                } else {
                    this.eNg = pA(this.eNe);
                }
            }
        }
        if (i == this.eNp) {
            while (this.eNr > 0) {
                a((byte) (this.eNq & MotionEventCompat.ACTION_MASK), outputStream);
                this.eNq >>= 8;
                this.eNr -= 8;
            }
            f(outputStream);
        }
    }
}
