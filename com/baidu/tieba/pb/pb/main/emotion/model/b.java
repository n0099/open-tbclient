package com.baidu.tieba.pb.pb.main.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
class b {
    int eSB;
    int eSI;
    int eSJ;
    int eSK;
    int eSO;
    private int eSt;
    private int eSu;
    private byte[] eSv;
    private int eSw;
    private int eSx;
    private int eSy;
    int eSz;
    int eSA = 12;
    int eSC = 4096;
    int[] eSD = new int[5003];
    int[] eSE = new int[5003];
    int eSF = 5003;
    int eSG = 0;
    boolean eSH = false;
    int eSL = 0;
    int eSM = 0;
    int[] eSN = {0, 1, 3, 7, 15, 31, 63, TransportMediator.KEYCODE_MEDIA_PAUSE, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] eSP = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.eSt = i;
        this.eSu = i2;
        this.eSv = bArr;
        this.eSw = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.eSP;
        int i = this.eSO;
        this.eSO = i + 1;
        bArr[i] = b;
        if (this.eSO >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        pC(this.eSF);
        this.eSG = this.eSJ + 2;
        this.eSH = true;
        b(this.eSJ, outputStream);
    }

    void pC(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.eSD[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.eSI = i;
        this.eSH = false;
        this.eSz = this.eSI;
        this.eSB = pD(this.eSz);
        this.eSJ = 1 << (i - 1);
        this.eSK = this.eSJ + 1;
        this.eSG = this.eSJ + 2;
        this.eSO = 0;
        int aUa = aUa();
        for (int i3 = this.eSF; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.eSF;
        pC(i5);
        b(this.eSJ, outputStream);
        while (true) {
            int aUa2 = aUa();
            if (aUa2 != -1) {
                int i6 = (aUa2 << this.eSA) + aUa;
                int i7 = (aUa2 << i4) ^ aUa;
                if (this.eSD[i7] == i6) {
                    aUa = this.eSE[i7];
                } else {
                    if (this.eSD[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.eSD[i7] == i6) {
                                aUa = this.eSE[i7];
                                break;
                            }
                        } while (this.eSD[i7] >= 0);
                    }
                    b(aUa, outputStream);
                    if (this.eSG < this.eSC) {
                        int[] iArr = this.eSE;
                        int i9 = this.eSG;
                        this.eSG = i9 + 1;
                        iArr[i7] = i9;
                        this.eSD[i7] = i6;
                        aUa = aUa2;
                    } else {
                        f(outputStream);
                        aUa = aUa2;
                    }
                }
            } else {
                b(aUa, outputStream);
                b(this.eSK, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.eSw);
        this.eSx = this.eSt * this.eSu;
        this.eSy = 0;
        a(this.eSw + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.eSO > 0) {
            outputStream.write(this.eSO);
            outputStream.write(this.eSP, 0, this.eSO);
            this.eSO = 0;
        }
    }

    final int pD(int i) {
        return (1 << i) - 1;
    }

    private int aUa() {
        if (this.eSx == 0) {
            return -1;
        }
        this.eSx--;
        byte[] bArr = this.eSv;
        int i = this.eSy;
        this.eSy = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.eSL &= this.eSN[this.eSM];
        if (this.eSM > 0) {
            this.eSL |= i << this.eSM;
        } else {
            this.eSL = i;
        }
        this.eSM += this.eSz;
        while (this.eSM >= 8) {
            a((byte) (this.eSL & MotionEventCompat.ACTION_MASK), outputStream);
            this.eSL >>= 8;
            this.eSM -= 8;
        }
        if (this.eSG > this.eSB || this.eSH) {
            if (this.eSH) {
                int i2 = this.eSI;
                this.eSz = i2;
                this.eSB = pD(i2);
                this.eSH = false;
            } else {
                this.eSz++;
                if (this.eSz == this.eSA) {
                    this.eSB = this.eSC;
                } else {
                    this.eSB = pD(this.eSz);
                }
            }
        }
        if (i == this.eSK) {
            while (this.eSM > 0) {
                a((byte) (this.eSL & MotionEventCompat.ACTION_MASK), outputStream);
                this.eSL >>= 8;
                this.eSM -= 8;
            }
            g(outputStream);
        }
    }
}
