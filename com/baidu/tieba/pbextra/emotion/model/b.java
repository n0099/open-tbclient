package com.baidu.tieba.pbextra.emotion.model;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
class b {
    private int mlN;
    private int mlO;
    private byte[] mlP;
    private int mlQ;
    private int mlR;
    private int mlS;
    int mlT;
    int mlV;
    int mmc;
    int mmd;
    int mme;
    int mmi;
    int mlU = 12;
    int mlW = 4096;
    int[] mlX = new int[5003];
    int[] mlY = new int[5003];
    int mlZ = 5003;
    int mma = 0;
    boolean mmb = false;
    int mmf = 0;
    int mmg = 0;
    int[] mmh = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] mmj = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mlN = i;
        this.mlO = i2;
        this.mlP = bArr;
        this.mlQ = Math.max(2, i3);
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mmj;
        int i = this.mmi;
        this.mmi = i + 1;
        bArr[i] = b2;
        if (this.mmi >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        HT(this.mlZ);
        this.mma = this.mmd + 2;
        this.mmb = true;
        b(this.mmd, outputStream);
    }

    void HT(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mlX[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mmc = i;
        this.mmb = false;
        this.mlT = this.mmc;
        this.mlV = HU(this.mlT);
        this.mmd = 1 << (i - 1);
        this.mme = this.mmd + 1;
        this.mma = this.mmd + 2;
        this.mmi = 0;
        int dxA = dxA();
        for (int i3 = this.mlZ; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mlZ;
        HT(i5);
        b(this.mmd, outputStream);
        while (true) {
            int dxA2 = dxA();
            if (dxA2 != -1) {
                int i6 = (dxA2 << this.mlU) + dxA;
                int i7 = (dxA2 << i4) ^ dxA;
                if (this.mlX[i7] == i6) {
                    dxA = this.mlY[i7];
                } else {
                    if (this.mlX[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mlX[i7] == i6) {
                                dxA = this.mlY[i7];
                                break;
                            }
                        } while (this.mlX[i7] >= 0);
                    }
                    b(dxA, outputStream);
                    if (this.mma < this.mlW) {
                        int[] iArr = this.mlY;
                        int i9 = this.mma;
                        this.mma = i9 + 1;
                        iArr[i7] = i9;
                        this.mlX[i7] = i6;
                        dxA = dxA2;
                    } else {
                        c(outputStream);
                        dxA = dxA2;
                    }
                }
            } else {
                b(dxA, outputStream);
                b(this.mme, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mlQ);
        this.mlR = this.mlN * this.mlO;
        this.mlS = 0;
        a(this.mlQ + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mmi > 0) {
            outputStream.write(this.mmi);
            outputStream.write(this.mmj, 0, this.mmi);
            this.mmi = 0;
        }
    }

    final int HU(int i) {
        return (1 << i) - 1;
    }

    private int dxA() {
        if (this.mlR == 0) {
            return -1;
        }
        this.mlR--;
        byte[] bArr = this.mlP;
        int i = this.mlS;
        this.mlS = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mmf &= this.mmh[this.mmg];
        if (this.mmg > 0) {
            this.mmf |= i << this.mmg;
        } else {
            this.mmf = i;
        }
        this.mmg += this.mlT;
        while (this.mmg >= 8) {
            a((byte) (this.mmf & 255), outputStream);
            this.mmf >>= 8;
            this.mmg -= 8;
        }
        if (this.mma > this.mlV || this.mmb) {
            if (this.mmb) {
                int i2 = this.mmc;
                this.mlT = i2;
                this.mlV = HU(i2);
                this.mmb = false;
            } else {
                this.mlT++;
                if (this.mlT == this.mlU) {
                    this.mlV = this.mlW;
                } else {
                    this.mlV = HU(this.mlT);
                }
            }
        }
        if (i == this.mme) {
            while (this.mmg > 0) {
                a((byte) (this.mmf & 255), outputStream);
                this.mmf >>= 8;
                this.mmg -= 8;
            }
            d(outputStream);
        }
    }
}
