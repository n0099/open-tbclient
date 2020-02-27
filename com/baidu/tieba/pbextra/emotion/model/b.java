package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int jdU;
    private int jdV;
    private byte[] jdW;
    private int jdX;
    private int jdY;
    private int jdZ;
    int jea;
    int jec;
    int jej;
    int jek;
    int jel;
    int jep;
    int jeb = 12;
    int jed = 4096;
    int[] jee = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] jef = new int[StatusCode.ERROR_NOT_LOGIN];
    int jeg = StatusCode.ERROR_NOT_LOGIN;
    int jeh = 0;
    boolean jei = false;
    int jem = 0;
    int jen = 0;
    int[] jeo = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jeq = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jdU = i;
        this.jdV = i2;
        this.jdW = bArr;
        this.jdX = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jeq;
        int i = this.jep;
        this.jep = i + 1;
        bArr[i] = b;
        if (this.jep >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zG(this.jeg);
        this.jeh = this.jek + 2;
        this.jei = true;
        b(this.jek, outputStream);
    }

    void zG(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jee[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jej = i;
        this.jei = false;
        this.jea = this.jej;
        this.jec = zH(this.jea);
        this.jek = 1 << (i - 1);
        this.jel = this.jek + 1;
        this.jeh = this.jek + 2;
        this.jep = 0;
        int cuA = cuA();
        for (int i3 = this.jeg; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jeg;
        zG(i5);
        b(this.jek, outputStream);
        while (true) {
            int cuA2 = cuA();
            if (cuA2 != -1) {
                int i6 = (cuA2 << this.jeb) + cuA;
                int i7 = (cuA2 << i4) ^ cuA;
                if (this.jee[i7] == i6) {
                    cuA = this.jef[i7];
                } else {
                    if (this.jee[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jee[i7] == i6) {
                                cuA = this.jef[i7];
                                break;
                            }
                        } while (this.jee[i7] >= 0);
                    }
                    b(cuA, outputStream);
                    if (this.jeh < this.jed) {
                        int[] iArr = this.jef;
                        int i9 = this.jeh;
                        this.jeh = i9 + 1;
                        iArr[i7] = i9;
                        this.jee[i7] = i6;
                        cuA = cuA2;
                    } else {
                        c(outputStream);
                        cuA = cuA2;
                    }
                }
            } else {
                b(cuA, outputStream);
                b(this.jel, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jdX);
        this.jdY = this.jdU * this.jdV;
        this.jdZ = 0;
        a(this.jdX + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jep > 0) {
            outputStream.write(this.jep);
            outputStream.write(this.jeq, 0, this.jep);
            this.jep = 0;
        }
    }

    final int zH(int i) {
        return (1 << i) - 1;
    }

    private int cuA() {
        if (this.jdY == 0) {
            return -1;
        }
        this.jdY--;
        byte[] bArr = this.jdW;
        int i = this.jdZ;
        this.jdZ = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jem &= this.jeo[this.jen];
        if (this.jen > 0) {
            this.jem |= i << this.jen;
        } else {
            this.jem = i;
        }
        this.jen += this.jea;
        while (this.jen >= 8) {
            a((byte) (this.jem & 255), outputStream);
            this.jem >>= 8;
            this.jen -= 8;
        }
        if (this.jeh > this.jec || this.jei) {
            if (this.jei) {
                int i2 = this.jej;
                this.jea = i2;
                this.jec = zH(i2);
                this.jei = false;
            } else {
                this.jea++;
                if (this.jea == this.jeb) {
                    this.jec = this.jed;
                } else {
                    this.jec = zH(this.jea);
                }
            }
        }
        if (i == this.jel) {
            while (this.jen > 0) {
                a((byte) (this.jem & 255), outputStream);
                this.jem >>= 8;
                this.jen -= 8;
            }
            d(outputStream);
        }
    }
}
