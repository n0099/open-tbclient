package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes9.dex */
class b {
    private int jPP;
    private int jPQ;
    private byte[] jPR;
    private int jPS;
    private int jPT;
    private int jPU;
    int jPV;
    int jPX;
    int jQe;
    int jQf;
    int jQg;
    int jQk;
    int jPW = 12;
    int jPY = 4096;
    int[] jPZ = new int[5003];
    int[] jQa = new int[5003];
    int jQb = 5003;
    int jQc = 0;
    boolean jQd = false;
    int jQh = 0;
    int jQi = 0;
    int[] jQj = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] jQl = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.jPP = i;
        this.jPQ = i2;
        this.jPR = bArr;
        this.jPS = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.jQl;
        int i = this.jQk;
        this.jQk = i + 1;
        bArr[i] = b;
        if (this.jQk >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        Ap(this.jQb);
        this.jQc = this.jQf + 2;
        this.jQd = true;
        b(this.jQf, outputStream);
    }

    void Ap(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.jPZ[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.jQe = i;
        this.jQd = false;
        this.jPV = this.jQe;
        this.jPX = Aq(this.jPV);
        this.jQf = 1 << (i - 1);
        this.jQg = this.jQf + 1;
        this.jQc = this.jQf + 2;
        this.jQk = 0;
        int cFD = cFD();
        for (int i3 = this.jQb; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.jQb;
        Ap(i5);
        b(this.jQf, outputStream);
        while (true) {
            int cFD2 = cFD();
            if (cFD2 != -1) {
                int i6 = (cFD2 << this.jPW) + cFD;
                int i7 = (cFD2 << i4) ^ cFD;
                if (this.jPZ[i7] == i6) {
                    cFD = this.jQa[i7];
                } else {
                    if (this.jPZ[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.jPZ[i7] == i6) {
                                cFD = this.jQa[i7];
                                break;
                            }
                        } while (this.jPZ[i7] >= 0);
                    }
                    b(cFD, outputStream);
                    if (this.jQc < this.jPY) {
                        int[] iArr = this.jQa;
                        int i9 = this.jQc;
                        this.jQc = i9 + 1;
                        iArr[i7] = i9;
                        this.jPZ[i7] = i6;
                        cFD = cFD2;
                    } else {
                        c(outputStream);
                        cFD = cFD2;
                    }
                }
            } else {
                b(cFD, outputStream);
                b(this.jQg, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.jPS);
        this.jPT = this.jPP * this.jPQ;
        this.jPU = 0;
        a(this.jPS + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.jQk > 0) {
            outputStream.write(this.jQk);
            outputStream.write(this.jQl, 0, this.jQk);
            this.jQk = 0;
        }
    }

    final int Aq(int i) {
        return (1 << i) - 1;
    }

    private int cFD() {
        if (this.jPT == 0) {
            return -1;
        }
        this.jPT--;
        byte[] bArr = this.jPR;
        int i = this.jPU;
        this.jPU = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.jQh &= this.jQj[this.jQi];
        if (this.jQi > 0) {
            this.jQh |= i << this.jQi;
        } else {
            this.jQh = i;
        }
        this.jQi += this.jPV;
        while (this.jQi >= 8) {
            a((byte) (this.jQh & 255), outputStream);
            this.jQh >>= 8;
            this.jQi -= 8;
        }
        if (this.jQc > this.jPX || this.jQd) {
            if (this.jQd) {
                int i2 = this.jQe;
                this.jPV = i2;
                this.jPX = Aq(i2);
                this.jQd = false;
            } else {
                this.jPV++;
                if (this.jPV == this.jPW) {
                    this.jPX = this.jPY;
                } else {
                    this.jPX = Aq(this.jPV);
                }
            }
        }
        if (i == this.jQg) {
            while (this.jQi > 0) {
                a((byte) (this.jQh & 255), outputStream);
                this.jQh >>= 8;
                this.jQi -= 8;
            }
            d(outputStream);
        }
    }
}
