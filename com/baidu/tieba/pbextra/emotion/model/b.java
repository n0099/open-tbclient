package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes16.dex */
class b {
    private int kLI;
    private int kLJ;
    private byte[] kLK;
    private int kLL;
    private int kLM;
    private int kLN;
    int kLO;
    int kLQ;
    int kLX;
    int kLY;
    int kLZ;
    int kMd;
    int kLP = 12;
    int kLR = 4096;
    int[] kLS = new int[5003];
    int[] kLT = new int[5003];
    int kLU = 5003;
    int kLV = 0;
    boolean kLW = false;
    int kMa = 0;
    int kMb = 0;
    int[] kMc = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] kMe = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.kLI = i;
        this.kLJ = i2;
        this.kLK = bArr;
        this.kLL = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.kMe;
        int i = this.kMd;
        this.kMd = i + 1;
        bArr[i] = b;
        if (this.kMd >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        CE(this.kLU);
        this.kLV = this.kLY + 2;
        this.kLW = true;
        b(this.kLY, outputStream);
    }

    void CE(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.kLS[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.kLX = i;
        this.kLW = false;
        this.kLO = this.kLX;
        this.kLQ = CF(this.kLO);
        this.kLY = 1 << (i - 1);
        this.kLZ = this.kLY + 1;
        this.kLV = this.kLY + 2;
        this.kMd = 0;
        int cUY = cUY();
        for (int i3 = this.kLU; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.kLU;
        CE(i5);
        b(this.kLY, outputStream);
        while (true) {
            int cUY2 = cUY();
            if (cUY2 != -1) {
                int i6 = (cUY2 << this.kLP) + cUY;
                int i7 = (cUY2 << i4) ^ cUY;
                if (this.kLS[i7] == i6) {
                    cUY = this.kLT[i7];
                } else {
                    if (this.kLS[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.kLS[i7] == i6) {
                                cUY = this.kLT[i7];
                                break;
                            }
                        } while (this.kLS[i7] >= 0);
                    }
                    b(cUY, outputStream);
                    if (this.kLV < this.kLR) {
                        int[] iArr = this.kLT;
                        int i9 = this.kLV;
                        this.kLV = i9 + 1;
                        iArr[i7] = i9;
                        this.kLS[i7] = i6;
                        cUY = cUY2;
                    } else {
                        c(outputStream);
                        cUY = cUY2;
                    }
                }
            } else {
                b(cUY, outputStream);
                b(this.kLZ, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.kLL);
        this.kLM = this.kLI * this.kLJ;
        this.kLN = 0;
        a(this.kLL + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.kMd > 0) {
            outputStream.write(this.kMd);
            outputStream.write(this.kMe, 0, this.kMd);
            this.kMd = 0;
        }
    }

    final int CF(int i) {
        return (1 << i) - 1;
    }

    private int cUY() {
        if (this.kLM == 0) {
            return -1;
        }
        this.kLM--;
        byte[] bArr = this.kLK;
        int i = this.kLN;
        this.kLN = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.kMa &= this.kMc[this.kMb];
        if (this.kMb > 0) {
            this.kMa |= i << this.kMb;
        } else {
            this.kMa = i;
        }
        this.kMb += this.kLO;
        while (this.kMb >= 8) {
            a((byte) (this.kMa & 255), outputStream);
            this.kMa >>= 8;
            this.kMb -= 8;
        }
        if (this.kLV > this.kLQ || this.kLW) {
            if (this.kLW) {
                int i2 = this.kLX;
                this.kLO = i2;
                this.kLQ = CF(i2);
                this.kLW = false;
            } else {
                this.kLO++;
                if (this.kLO == this.kLP) {
                    this.kLQ = this.kLR;
                } else {
                    this.kLQ = CF(this.kLO);
                }
            }
        }
        if (i == this.kLZ) {
            while (this.kMb > 0) {
                a((byte) (this.kMa & 255), outputStream);
                this.kMa >>= 8;
                this.kMb -= 8;
            }
            d(outputStream);
        }
    }
}
