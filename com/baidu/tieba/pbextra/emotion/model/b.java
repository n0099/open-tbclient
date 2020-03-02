package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int jdW;
    private int jdX;
    private byte[] jdY;
    private int jdZ;
    private int jea;
    private int jeb;
    int jec;
    int jee;
    int jel;
    int jem;
    int jen;
    int jer;
    int jed = 12;
    int jef = 4096;
    int[] jeg = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] jeh = new int[StatusCode.ERROR_NOT_LOGIN];
    int jei = StatusCode.ERROR_NOT_LOGIN;
    int jej = 0;
    boolean jek = false;
    int jeo = 0;
    int jep = 0;
    int[] jeq = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jes = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jdW = i;
        this.jdX = i2;
        this.jdY = bArr;
        this.jdZ = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jes;
        int i = this.jer;
        this.jer = i + 1;
        bArr[i] = b;
        if (this.jer >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zG(this.jei);
        this.jej = this.jem + 2;
        this.jek = true;
        b(this.jem, outputStream);
    }

    void zG(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jeg[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jel = i;
        this.jek = false;
        this.jec = this.jel;
        this.jee = zH(this.jec);
        this.jem = 1 << (i - 1);
        this.jen = this.jem + 1;
        this.jej = this.jem + 2;
        this.jer = 0;
        int cuC = cuC();
        for (int i3 = this.jei; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jei;
        zG(i5);
        b(this.jem, outputStream);
        while (true) {
            int cuC2 = cuC();
            if (cuC2 != -1) {
                int i6 = (cuC2 << this.jed) + cuC;
                int i7 = (cuC2 << i4) ^ cuC;
                if (this.jeg[i7] == i6) {
                    cuC = this.jeh[i7];
                } else {
                    if (this.jeg[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jeg[i7] == i6) {
                                cuC = this.jeh[i7];
                                break;
                            }
                        } while (this.jeg[i7] >= 0);
                    }
                    b(cuC, outputStream);
                    if (this.jej < this.jef) {
                        int[] iArr = this.jeh;
                        int i9 = this.jej;
                        this.jej = i9 + 1;
                        iArr[i7] = i9;
                        this.jeg[i7] = i6;
                        cuC = cuC2;
                    } else {
                        c(outputStream);
                        cuC = cuC2;
                    }
                }
            } else {
                b(cuC, outputStream);
                b(this.jen, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jdZ);
        this.jea = this.jdW * this.jdX;
        this.jeb = 0;
        a(this.jdZ + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jer > 0) {
            outputStream.write(this.jer);
            outputStream.write(this.jes, 0, this.jer);
            this.jer = 0;
        }
    }

    final int zH(int i) {
        return (1 << i) - 1;
    }

    private int cuC() {
        if (this.jea == 0) {
            return -1;
        }
        this.jea--;
        byte[] bArr = this.jdY;
        int i = this.jeb;
        this.jeb = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jeo &= this.jeq[this.jep];
        if (this.jep > 0) {
            this.jeo |= i << this.jep;
        } else {
            this.jeo = i;
        }
        this.jep += this.jec;
        while (this.jep >= 8) {
            a((byte) (this.jeo & 255), outputStream);
            this.jeo >>= 8;
            this.jep -= 8;
        }
        if (this.jej > this.jee || this.jek) {
            if (this.jek) {
                int i2 = this.jel;
                this.jec = i2;
                this.jee = zH(i2);
                this.jek = false;
            } else {
                this.jec++;
                if (this.jec == this.jed) {
                    this.jee = this.jef;
                } else {
                    this.jee = zH(this.jec);
                }
            }
        }
        if (i == this.jen) {
            while (this.jep > 0) {
                a((byte) (this.jeo & 255), outputStream);
                this.jeo >>= 8;
                this.jep -= 8;
            }
            d(outputStream);
        }
    }
}
