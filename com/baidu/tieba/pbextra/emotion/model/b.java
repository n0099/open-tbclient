package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int jPT;
    private int jPU;
    private byte[] jPV;
    private int jPW;
    private int jPX;
    private int jPY;
    int jPZ;
    int jQb;
    int jQi;
    int jQj;
    int jQk;
    int jQo;
    int jQa = 12;
    int jQc = 4096;
    int[] jQd = new int[5003];
    int[] jQe = new int[5003];
    int jQf = 5003;
    int jQg = 0;
    boolean jQh = false;
    int jQl = 0;
    int jQm = 0;
    int[] jQn = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jQp = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jPT = i;
        this.jPU = i2;
        this.jPV = bArr;
        this.jPW = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jQp;
        int i = this.jQo;
        this.jQo = i + 1;
        bArr[i] = b;
        if (this.jQo >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Ap(this.jQf);
        this.jQg = this.jQj + 2;
        this.jQh = true;
        b(this.jQj, outputStream);
    }

    void Ap(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jQd[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jQi = i;
        this.jQh = false;
        this.jPZ = this.jQi;
        this.jQb = Aq(this.jPZ);
        this.jQj = 1 << (i - 1);
        this.jQk = this.jQj + 1;
        this.jQg = this.jQj + 2;
        this.jQo = 0;
        int cFB = cFB();
        for (int i3 = this.jQf; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jQf;
        Ap(i5);
        b(this.jQj, outputStream);
        while (true) {
            int cFB2 = cFB();
            if (cFB2 != -1) {
                int i6 = (cFB2 << this.jQa) + cFB;
                int i7 = (cFB2 << i4) ^ cFB;
                if (this.jQd[i7] == i6) {
                    cFB = this.jQe[i7];
                } else {
                    if (this.jQd[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jQd[i7] == i6) {
                                cFB = this.jQe[i7];
                                break;
                            }
                        } while (this.jQd[i7] >= 0);
                    }
                    b(cFB, outputStream);
                    if (this.jQg < this.jQc) {
                        int[] iArr = this.jQe;
                        int i9 = this.jQg;
                        this.jQg = i9 + 1;
                        iArr[i7] = i9;
                        this.jQd[i7] = i6;
                        cFB = cFB2;
                    } else {
                        c(outputStream);
                        cFB = cFB2;
                    }
                }
            } else {
                b(cFB, outputStream);
                b(this.jQk, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jPW);
        this.jPX = this.jPT * this.jPU;
        this.jPY = 0;
        a(this.jPW + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jQo > 0) {
            outputStream.write(this.jQo);
            outputStream.write(this.jQp, 0, this.jQo);
            this.jQo = 0;
        }
    }

    final int Aq(int i) {
        return (1 << i) - 1;
    }

    private int cFB() {
        if (this.jPX == 0) {
            return -1;
        }
        this.jPX--;
        byte[] bArr = this.jPV;
        int i = this.jPY;
        this.jPY = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jQl &= this.jQn[this.jQm];
        if (this.jQm > 0) {
            this.jQl |= i << this.jQm;
        } else {
            this.jQl = i;
        }
        this.jQm += this.jPZ;
        while (this.jQm >= 8) {
            a((byte) (this.jQl & 255), outputStream);
            this.jQl >>= 8;
            this.jQm -= 8;
        }
        if (this.jQg > this.jQb || this.jQh) {
            if (this.jQh) {
                int i2 = this.jQi;
                this.jPZ = i2;
                this.jQb = Aq(i2);
                this.jQh = false;
            } else {
                this.jPZ++;
                if (this.jPZ == this.jQa) {
                    this.jQb = this.jQc;
                } else {
                    this.jQb = Aq(this.jPZ);
                }
            }
        }
        if (i == this.jQk) {
            while (this.jQm > 0) {
                a((byte) (this.jQl & 255), outputStream);
                this.jQl >>= 8;
                this.jQm -= 8;
            }
            d(outputStream);
        }
    }
}
