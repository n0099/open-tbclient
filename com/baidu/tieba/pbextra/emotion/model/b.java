package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int kiS;
    private int kiT;
    private byte[] kiU;
    private int kiV;
    private int kiW;
    private int kiX;
    int kiY;
    int kja;
    int kjh;
    int kji;
    int kjj;
    int kjn;
    int kiZ = 12;
    int kjb = 4096;
    int[] kjc = new int[5003];
    int[] kjd = new int[5003];
    int kje = 5003;
    int kjf = 0;
    boolean kjg = false;
    int kjk = 0;
    int kjl = 0;
    int[] kjm = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] kjo = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.kiS = i;
        this.kiT = i2;
        this.kiU = bArr;
        this.kiV = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.kjo;
        int i = this.kjn;
        this.kjn = i + 1;
        bArr[i] = b;
        if (this.kjn >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Bc(this.kje);
        this.kjf = this.kji + 2;
        this.kjg = true;
        b(this.kji, outputStream);
    }

    void Bc(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.kjc[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.kjh = i;
        this.kjg = false;
        this.kiY = this.kjh;
        this.kja = Bd(this.kiY);
        this.kji = 1 << (i - 1);
        this.kjj = this.kji + 1;
        this.kjf = this.kji + 2;
        this.kjn = 0;
        int cMQ = cMQ();
        for (int i3 = this.kje; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.kje;
        Bc(i5);
        b(this.kji, outputStream);
        while (true) {
            int cMQ2 = cMQ();
            if (cMQ2 != -1) {
                int i6 = (cMQ2 << this.kiZ) + cMQ;
                int i7 = (cMQ2 << i4) ^ cMQ;
                if (this.kjc[i7] == i6) {
                    cMQ = this.kjd[i7];
                } else {
                    if (this.kjc[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.kjc[i7] == i6) {
                                cMQ = this.kjd[i7];
                                break;
                            }
                        } while (this.kjc[i7] >= 0);
                    }
                    b(cMQ, outputStream);
                    if (this.kjf < this.kjb) {
                        int[] iArr = this.kjd;
                        int i9 = this.kjf;
                        this.kjf = i9 + 1;
                        iArr[i7] = i9;
                        this.kjc[i7] = i6;
                        cMQ = cMQ2;
                    } else {
                        c(outputStream);
                        cMQ = cMQ2;
                    }
                }
            } else {
                b(cMQ, outputStream);
                b(this.kjj, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.kiV);
        this.kiW = this.kiS * this.kiT;
        this.kiX = 0;
        a(this.kiV + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.kjn > 0) {
            outputStream.write(this.kjn);
            outputStream.write(this.kjo, 0, this.kjn);
            this.kjn = 0;
        }
    }

    final int Bd(int i) {
        return (1 << i) - 1;
    }

    private int cMQ() {
        if (this.kiW == 0) {
            return -1;
        }
        this.kiW--;
        byte[] bArr = this.kiU;
        int i = this.kiX;
        this.kiX = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.kjk &= this.kjm[this.kjl];
        if (this.kjl > 0) {
            this.kjk |= i << this.kjl;
        } else {
            this.kjk = i;
        }
        this.kjl += this.kiY;
        while (this.kjl >= 8) {
            a((byte) (this.kjk & 255), outputStream);
            this.kjk >>= 8;
            this.kjl -= 8;
        }
        if (this.kjf > this.kja || this.kjg) {
            if (this.kjg) {
                int i2 = this.kjh;
                this.kiY = i2;
                this.kja = Bd(i2);
                this.kjg = false;
            } else {
                this.kiY++;
                if (this.kiY == this.kiZ) {
                    this.kja = this.kjb;
                } else {
                    this.kja = Bd(this.kiY);
                }
            }
        }
        if (i == this.kjj) {
            while (this.kjl > 0) {
                a((byte) (this.kjk & 255), outputStream);
                this.kjk >>= 8;
                this.kjl -= 8;
            }
            d(outputStream);
        }
    }
}
