package com.baidu.tieba.pbextra.emotion.model;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes16.dex */
class b {
    private int kLG;
    private int kLH;
    private byte[] kLI;
    private int kLJ;
    private int kLK;
    private int kLL;
    int kLM;
    int kLO;
    int kLV;
    int kLW;
    int kLX;
    int kMb;
    int kLN = 12;
    int kLP = 4096;
    int[] kLQ = new int[5003];
    int[] kLR = new int[5003];
    int kLS = 5003;
    int kLT = 0;
    boolean kLU = false;
    int kLY = 0;
    int kLZ = 0;
    int[] kMa = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] kMc = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.kLG = i;
        this.kLH = i2;
        this.kLI = bArr;
        this.kLJ = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.kMc;
        int i = this.kMb;
        this.kMb = i + 1;
        bArr[i] = b;
        if (this.kMb >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        CE(this.kLS);
        this.kLT = this.kLW + 2;
        this.kLU = true;
        b(this.kLW, outputStream);
    }

    void CE(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.kLQ[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.kLV = i;
        this.kLU = false;
        this.kLM = this.kLV;
        this.kLO = CF(this.kLM);
        this.kLW = 1 << (i - 1);
        this.kLX = this.kLW + 1;
        this.kLT = this.kLW + 2;
        this.kMb = 0;
        int cUY = cUY();
        for (int i3 = this.kLS; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.kLS;
        CE(i5);
        b(this.kLW, outputStream);
        while (true) {
            int cUY2 = cUY();
            if (cUY2 != -1) {
                int i6 = (cUY2 << this.kLN) + cUY;
                int i7 = (cUY2 << i4) ^ cUY;
                if (this.kLQ[i7] == i6) {
                    cUY = this.kLR[i7];
                } else {
                    if (this.kLQ[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.kLQ[i7] == i6) {
                                cUY = this.kLR[i7];
                                break;
                            }
                        } while (this.kLQ[i7] >= 0);
                    }
                    b(cUY, outputStream);
                    if (this.kLT < this.kLP) {
                        int[] iArr = this.kLR;
                        int i9 = this.kLT;
                        this.kLT = i9 + 1;
                        iArr[i7] = i9;
                        this.kLQ[i7] = i6;
                        cUY = cUY2;
                    } else {
                        c(outputStream);
                        cUY = cUY2;
                    }
                }
            } else {
                b(cUY, outputStream);
                b(this.kLX, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.kLJ);
        this.kLK = this.kLG * this.kLH;
        this.kLL = 0;
        a(this.kLJ + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.kMb > 0) {
            outputStream.write(this.kMb);
            outputStream.write(this.kMc, 0, this.kMb);
            this.kMb = 0;
        }
    }

    final int CF(int i) {
        return (1 << i) - 1;
    }

    private int cUY() {
        if (this.kLK == 0) {
            return -1;
        }
        this.kLK--;
        byte[] bArr = this.kLI;
        int i = this.kLL;
        this.kLL = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.kLY &= this.kMa[this.kLZ];
        if (this.kLZ > 0) {
            this.kLY |= i << this.kLZ;
        } else {
            this.kLY = i;
        }
        this.kLZ += this.kLM;
        while (this.kLZ >= 8) {
            a((byte) (this.kLY & 255), outputStream);
            this.kLY >>= 8;
            this.kLZ -= 8;
        }
        if (this.kLT > this.kLO || this.kLU) {
            if (this.kLU) {
                int i2 = this.kLV;
                this.kLM = i2;
                this.kLO = CF(i2);
                this.kLU = false;
            } else {
                this.kLM++;
                if (this.kLM == this.kLN) {
                    this.kLO = this.kLP;
                } else {
                    this.kLO = CF(this.kLM);
                }
            }
        }
        if (i == this.kLX) {
            while (this.kLZ > 0) {
                a((byte) (this.kLY & 255), outputStream);
                this.kLY >>= 8;
                this.kLZ -= 8;
            }
            d(outputStream);
        }
    }
}
