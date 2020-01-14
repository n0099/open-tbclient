package com.baidu.tieba.pbextra.emotion.model;

import com.baidu.android.imsdk.ResponseCode;
import com.baidu.fsg.base.restnet.beans.StatusCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
class b {
    private int jcY;
    private int jcZ;
    private byte[] jda;
    private int jdb;
    private int jdc;
    private int jdd;
    int jde;
    int jdg;
    int jdn;
    int jdo;
    int jdp;
    int jdt;
    int jdf = 12;
    int jdh = 4096;
    int[] jdi = new int[StatusCode.ERROR_NOT_LOGIN];
    int[] jdj = new int[StatusCode.ERROR_NOT_LOGIN];
    int jdk = StatusCode.ERROR_NOT_LOGIN;
    int jdl = 0;
    boolean jdm = false;
    int jdq = 0;
    int jdr = 0;
    int[] jds = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jdu = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jcY = i;
        this.jcZ = i2;
        this.jda = bArr;
        this.jdb = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jdu;
        int i = this.jdt;
        this.jdt = i + 1;
        bArr[i] = b;
        if (this.jdt >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        zz(this.jdk);
        this.jdl = this.jdo + 2;
        this.jdm = true;
        b(this.jdo, outputStream);
    }

    void zz(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jdi[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jdn = i;
        this.jdm = false;
        this.jde = this.jdn;
        this.jdg = zA(this.jde);
        this.jdo = 1 << (i - 1);
        this.jdp = this.jdo + 1;
        this.jdl = this.jdo + 2;
        this.jdt = 0;
        int cth = cth();
        for (int i3 = this.jdk; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jdk;
        zz(i5);
        b(this.jdo, outputStream);
        while (true) {
            int cth2 = cth();
            if (cth2 != -1) {
                int i6 = (cth2 << this.jdf) + cth;
                int i7 = (cth2 << i4) ^ cth;
                if (this.jdi[i7] == i6) {
                    cth = this.jdj[i7];
                } else {
                    if (this.jdi[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jdi[i7] == i6) {
                                cth = this.jdj[i7];
                                break;
                            }
                        } while (this.jdi[i7] >= 0);
                    }
                    b(cth, outputStream);
                    if (this.jdl < this.jdh) {
                        int[] iArr = this.jdj;
                        int i9 = this.jdl;
                        this.jdl = i9 + 1;
                        iArr[i7] = i9;
                        this.jdi[i7] = i6;
                        cth = cth2;
                    } else {
                        c(outputStream);
                        cth = cth2;
                    }
                }
            } else {
                b(cth, outputStream);
                b(this.jdp, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jdb);
        this.jdc = this.jcY * this.jcZ;
        this.jdd = 0;
        a(this.jdb + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jdt > 0) {
            outputStream.write(this.jdt);
            outputStream.write(this.jdu, 0, this.jdt);
            this.jdt = 0;
        }
    }

    final int zA(int i) {
        return (1 << i) - 1;
    }

    private int cth() {
        if (this.jdc == 0) {
            return -1;
        }
        this.jdc--;
        byte[] bArr = this.jda;
        int i = this.jdd;
        this.jdd = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jdq &= this.jds[this.jdr];
        if (this.jdr > 0) {
            this.jdq |= i << this.jdr;
        } else {
            this.jdq = i;
        }
        this.jdr += this.jde;
        while (this.jdr >= 8) {
            a((byte) (this.jdq & 255), outputStream);
            this.jdq >>= 8;
            this.jdr -= 8;
        }
        if (this.jdl > this.jdg || this.jdm) {
            if (this.jdm) {
                int i2 = this.jdn;
                this.jde = i2;
                this.jdg = zA(i2);
                this.jdm = false;
            } else {
                this.jde++;
                if (this.jde == this.jdf) {
                    this.jdg = this.jdh;
                } else {
                    this.jdg = zA(this.jde);
                }
            }
        }
        if (i == this.jdp) {
            while (this.jdr > 0) {
                a((byte) (this.jdq & 255), outputStream);
                this.jdq >>= 8;
                this.jdr -= 8;
            }
            d(outputStream);
        }
    }
}
