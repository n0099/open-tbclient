package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
class b {
    private int jcT;
    private int jcU;
    private byte[] jcV;
    private int jcW;
    private int jcX;
    private int jcY;
    int jcZ;
    int jdb;
    int jdi;
    int jdj;
    int jdk;
    int jdo;
    int jda = 12;
    int jdc = 4096;
    int[] jdd = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] jde = new int[StatusCode.ERROR_NOT_LOGIN];
    int jdf = StatusCode.ERROR_NOT_LOGIN;
    int jdg = 0;
    boolean jdh = false;
    int jdl = 0;
    int jdm = 0;
    int[] jdn = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jdp = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jcT = i;
        this.jcU = i2;
        this.jcV = bArr;
        this.jcW = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jdp;
        int i = this.jdo;
        this.jdo = i + 1;
        bArr[i] = b;
        if (this.jdo >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zz(this.jdf);
        this.jdg = this.jdj + 2;
        this.jdh = true;
        b(this.jdj, outputStream);
    }

    void zz(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jdd[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jdi = i;
        this.jdh = false;
        this.jcZ = this.jdi;
        this.jdb = zA(this.jcZ);
        this.jdj = 1 << (i - 1);
        this.jdk = this.jdj + 1;
        this.jdg = this.jdj + 2;
        this.jdo = 0;
        int ctf = ctf();
        for (int i3 = this.jdf; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jdf;
        zz(i5);
        b(this.jdj, outputStream);
        while (true) {
            int ctf2 = ctf();
            if (ctf2 != -1) {
                int i6 = (ctf2 << this.jda) + ctf;
                int i7 = (ctf2 << i4) ^ ctf;
                if (this.jdd[i7] == i6) {
                    ctf = this.jde[i7];
                } else {
                    if (this.jdd[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jdd[i7] == i6) {
                                ctf = this.jde[i7];
                                break;
                            }
                        } while (this.jdd[i7] >= 0);
                    }
                    b(ctf, outputStream);
                    if (this.jdg < this.jdc) {
                        int[] iArr = this.jde;
                        int i9 = this.jdg;
                        this.jdg = i9 + 1;
                        iArr[i7] = i9;
                        this.jdd[i7] = i6;
                        ctf = ctf2;
                    } else {
                        c(outputStream);
                        ctf = ctf2;
                    }
                }
            } else {
                b(ctf, outputStream);
                b(this.jdk, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jcW);
        this.jcX = this.jcT * this.jcU;
        this.jcY = 0;
        a(this.jcW + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jdo > 0) {
            outputStream.write(this.jdo);
            outputStream.write(this.jdp, 0, this.jdo);
            this.jdo = 0;
        }
    }

    final int zA(int i) {
        return (1 << i) - 1;
    }

    private int ctf() {
        if (this.jcX == 0) {
            return -1;
        }
        this.jcX--;
        byte[] bArr = this.jcV;
        int i = this.jcY;
        this.jcY = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jdl &= this.jdn[this.jdm];
        if (this.jdm > 0) {
            this.jdl |= i << this.jdm;
        } else {
            this.jdl = i;
        }
        this.jdm += this.jcZ;
        while (this.jdm >= 8) {
            a((byte) (this.jdl & 255), outputStream);
            this.jdl >>= 8;
            this.jdm -= 8;
        }
        if (this.jdg > this.jdb || this.jdh) {
            if (this.jdh) {
                int i2 = this.jdi;
                this.jcZ = i2;
                this.jdb = zA(i2);
                this.jdh = false;
            } else {
                this.jcZ++;
                if (this.jcZ == this.jda) {
                    this.jdb = this.jdc;
                } else {
                    this.jdb = zA(this.jcZ);
                }
            }
        }
        if (i == this.jdk) {
            while (this.jdm > 0) {
                a((byte) (this.jdl & 255), outputStream);
                this.jdl >>= 8;
                this.jdm -= 8;
            }
            d(outputStream);
        }
    }
}
