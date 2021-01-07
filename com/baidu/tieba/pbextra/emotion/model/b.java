package com.baidu.tieba.pbextra.emotion.model;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
class b {
    private int mlM;
    private int mlN;
    private byte[] mlO;
    private int mlP;
    private int mlQ;
    private int mlR;
    int mlS;
    int mlU;
    int mmb;
    int mmc;
    int mmd;
    int mmh;
    int mlT = 12;
    int mlV = 4096;
    int[] mlW = new int[5003];
    int[] mlX = new int[5003];
    int mlY = 5003;
    int mlZ = 0;
    boolean mma = false;
    int mme = 0;
    int mmf = 0;
    int[] mmg = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] mmi = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mlM = i;
        this.mlN = i2;
        this.mlO = bArr;
        this.mlP = Math.max(2, i3);
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mmi;
        int i = this.mmh;
        this.mmh = i + 1;
        bArr[i] = b2;
        if (this.mmh >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        HT(this.mlY);
        this.mlZ = this.mmc + 2;
        this.mma = true;
        b(this.mmc, outputStream);
    }

    void HT(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mlW[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mmb = i;
        this.mma = false;
        this.mlS = this.mmb;
        this.mlU = HU(this.mlS);
        this.mmc = 1 << (i - 1);
        this.mmd = this.mmc + 1;
        this.mlZ = this.mmc + 2;
        this.mmh = 0;
        int dxB = dxB();
        for (int i3 = this.mlY; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mlY;
        HT(i5);
        b(this.mmc, outputStream);
        while (true) {
            int dxB2 = dxB();
            if (dxB2 != -1) {
                int i6 = (dxB2 << this.mlT) + dxB;
                int i7 = (dxB2 << i4) ^ dxB;
                if (this.mlW[i7] == i6) {
                    dxB = this.mlX[i7];
                } else {
                    if (this.mlW[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mlW[i7] == i6) {
                                dxB = this.mlX[i7];
                                break;
                            }
                        } while (this.mlW[i7] >= 0);
                    }
                    b(dxB, outputStream);
                    if (this.mlZ < this.mlV) {
                        int[] iArr = this.mlX;
                        int i9 = this.mlZ;
                        this.mlZ = i9 + 1;
                        iArr[i7] = i9;
                        this.mlW[i7] = i6;
                        dxB = dxB2;
                    } else {
                        c(outputStream);
                        dxB = dxB2;
                    }
                }
            } else {
                b(dxB, outputStream);
                b(this.mmd, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mlP);
        this.mlQ = this.mlM * this.mlN;
        this.mlR = 0;
        a(this.mlP + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mmh > 0) {
            outputStream.write(this.mmh);
            outputStream.write(this.mmi, 0, this.mmh);
            this.mmh = 0;
        }
    }

    final int HU(int i) {
        return (1 << i) - 1;
    }

    private int dxB() {
        if (this.mlQ == 0) {
            return -1;
        }
        this.mlQ--;
        byte[] bArr = this.mlO;
        int i = this.mlR;
        this.mlR = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mme &= this.mmg[this.mmf];
        if (this.mmf > 0) {
            this.mme |= i << this.mmf;
        } else {
            this.mme = i;
        }
        this.mmf += this.mlS;
        while (this.mmf >= 8) {
            a((byte) (this.mme & 255), outputStream);
            this.mme >>= 8;
            this.mmf -= 8;
        }
        if (this.mlZ > this.mlU || this.mma) {
            if (this.mma) {
                int i2 = this.mmb;
                this.mlS = i2;
                this.mlU = HU(i2);
                this.mma = false;
            } else {
                this.mlS++;
                if (this.mlS == this.mlT) {
                    this.mlU = this.mlV;
                } else {
                    this.mlU = HU(this.mlS);
                }
            }
        }
        if (i == this.mmd) {
            while (this.mmf > 0) {
                a((byte) (this.mme & 255), outputStream);
                this.mme >>= 8;
                this.mmf -= 8;
            }
            d(outputStream);
        }
    }
}
