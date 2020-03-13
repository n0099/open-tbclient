package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    int jeD;
    private int jei;
    private int jej;
    private byte[] jek;
    private int jel;
    private int jem;
    private int jen;
    int jeo;
    int jeq;
    int jex;
    int jey;
    int jez;
    int jep = 12;
    int jer = 4096;
    int[] jes = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] jet = new int[StatusCode.ERROR_NOT_LOGIN];
    int jeu = StatusCode.ERROR_NOT_LOGIN;
    int jev = 0;
    boolean jew = false;
    int jeA = 0;
    int jeB = 0;
    int[] jeC = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jeE = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jei = i;
        this.jej = i2;
        this.jek = bArr;
        this.jel = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jeE;
        int i = this.jeD;
        this.jeD = i + 1;
        bArr[i] = b;
        if (this.jeD >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zG(this.jeu);
        this.jev = this.jey + 2;
        this.jew = true;
        b(this.jey, outputStream);
    }

    void zG(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jes[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jex = i;
        this.jew = false;
        this.jeo = this.jex;
        this.jeq = zH(this.jeo);
        this.jey = 1 << (i - 1);
        this.jez = this.jey + 1;
        this.jev = this.jey + 2;
        this.jeD = 0;
        int cuD = cuD();
        for (int i3 = this.jeu; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jeu;
        zG(i5);
        b(this.jey, outputStream);
        while (true) {
            int cuD2 = cuD();
            if (cuD2 != -1) {
                int i6 = (cuD2 << this.jep) + cuD;
                int i7 = (cuD2 << i4) ^ cuD;
                if (this.jes[i7] == i6) {
                    cuD = this.jet[i7];
                } else {
                    if (this.jes[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jes[i7] == i6) {
                                cuD = this.jet[i7];
                                break;
                            }
                        } while (this.jes[i7] >= 0);
                    }
                    b(cuD, outputStream);
                    if (this.jev < this.jer) {
                        int[] iArr = this.jet;
                        int i9 = this.jev;
                        this.jev = i9 + 1;
                        iArr[i7] = i9;
                        this.jes[i7] = i6;
                        cuD = cuD2;
                    } else {
                        c(outputStream);
                        cuD = cuD2;
                    }
                }
            } else {
                b(cuD, outputStream);
                b(this.jez, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jel);
        this.jem = this.jei * this.jej;
        this.jen = 0;
        a(this.jel + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jeD > 0) {
            outputStream.write(this.jeD);
            outputStream.write(this.jeE, 0, this.jeD);
            this.jeD = 0;
        }
    }

    final int zH(int i) {
        return (1 << i) - 1;
    }

    private int cuD() {
        if (this.jem == 0) {
            return -1;
        }
        this.jem--;
        byte[] bArr = this.jek;
        int i = this.jen;
        this.jen = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jeA &= this.jeC[this.jeB];
        if (this.jeB > 0) {
            this.jeA |= i << this.jeB;
        } else {
            this.jeA = i;
        }
        this.jeB += this.jeo;
        while (this.jeB >= 8) {
            a((byte) (this.jeA & 255), outputStream);
            this.jeA >>= 8;
            this.jeB -= 8;
        }
        if (this.jev > this.jeq || this.jew) {
            if (this.jew) {
                int i2 = this.jex;
                this.jeo = i2;
                this.jeq = zH(i2);
                this.jew = false;
            } else {
                this.jeo++;
                if (this.jeo == this.jep) {
                    this.jeq = this.jer;
                } else {
                    this.jeq = zH(this.jeo);
                }
            }
        }
        if (i == this.jez) {
            while (this.jeB > 0) {
                a((byte) (this.jeA & 255), outputStream);
                this.jeA >>= 8;
                this.jeB -= 8;
            }
            d(outputStream);
        }
    }
}
