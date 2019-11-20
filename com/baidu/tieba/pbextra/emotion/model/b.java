package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.android.imsdk.ResponseCode;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
class b {
    int ihA;
    int ihC;
    int ihJ;
    int ihK;
    int ihL;
    int ihP;
    private int ihu;
    private int ihv;
    private byte[] ihw;
    private int ihx;
    private int ihy;
    private int ihz;
    int ihB = 12;
    int ihD = 4096;
    int[] ihE = new int[5003];
    int[] ihF = new int[5003];
    int ihG = 5003;
    int ihH = 0;
    boolean ihI = false;
    int ihM = 0;
    int ihN = 0;
    int[] ihO = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ResponseCode.PROTOCOL_EXP, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] ihQ = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.ihu = i;
        this.ihv = i2;
        this.ihw = bArr;
        this.ihx = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.ihQ;
        int i = this.ihP;
        this.ihP = i + 1;
        bArr[i] = b;
        if (this.ihP >= 254) {
            e(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        xi(this.ihG);
        this.ihH = this.ihK + 2;
        this.ihI = true;
        b(this.ihK, outputStream);
    }

    void xi(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.ihE[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.ihJ = i;
        this.ihI = false;
        this.ihA = this.ihJ;
        this.ihC = xj(this.ihA);
        this.ihK = 1 << (i - 1);
        this.ihL = this.ihK + 1;
        this.ihH = this.ihK + 2;
        this.ihP = 0;
        int bYF = bYF();
        for (int i3 = this.ihG; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.ihG;
        xi(i5);
        b(this.ihK, outputStream);
        while (true) {
            int bYF2 = bYF();
            if (bYF2 != -1) {
                int i6 = (bYF2 << this.ihB) + bYF;
                int i7 = (bYF2 << i4) ^ bYF;
                if (this.ihE[i7] == i6) {
                    bYF = this.ihF[i7];
                } else {
                    if (this.ihE[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.ihE[i7] == i6) {
                                bYF = this.ihF[i7];
                                break;
                            }
                        } while (this.ihE[i7] >= 0);
                    }
                    b(bYF, outputStream);
                    if (this.ihH < this.ihD) {
                        int[] iArr = this.ihF;
                        int i9 = this.ihH;
                        this.ihH = i9 + 1;
                        iArr[i7] = i9;
                        this.ihE[i7] = i6;
                        bYF = bYF2;
                    } else {
                        c(outputStream);
                        bYF = bYF2;
                    }
                }
            } else {
                b(bYF, outputStream);
                b(this.ihL, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(OutputStream outputStream) throws IOException {
        outputStream.write(this.ihx);
        this.ihy = this.ihu * this.ihv;
        this.ihz = 0;
        a(this.ihx + 1, outputStream);
        outputStream.write(0);
    }

    void e(OutputStream outputStream) throws IOException {
        if (this.ihP > 0) {
            outputStream.write(this.ihP);
            outputStream.write(this.ihQ, 0, this.ihP);
            this.ihP = 0;
        }
    }

    final int xj(int i) {
        return (1 << i) - 1;
    }

    private int bYF() {
        if (this.ihy == 0) {
            return -1;
        }
        this.ihy--;
        byte[] bArr = this.ihw;
        int i = this.ihz;
        this.ihz = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.ihM &= this.ihO[this.ihN];
        if (this.ihN > 0) {
            this.ihM |= i << this.ihN;
        } else {
            this.ihM = i;
        }
        this.ihN += this.ihA;
        while (this.ihN >= 8) {
            a((byte) (this.ihM & 255), outputStream);
            this.ihM >>= 8;
            this.ihN -= 8;
        }
        if (this.ihH > this.ihC || this.ihI) {
            if (this.ihI) {
                int i2 = this.ihJ;
                this.ihA = i2;
                this.ihC = xj(i2);
                this.ihI = false;
            } else {
                this.ihA++;
                if (this.ihA == this.ihB) {
                    this.ihC = this.ihD;
                } else {
                    this.ihC = xj(this.ihA);
                }
            }
        }
        if (i == this.ihL) {
            while (this.ihN > 0) {
                a((byte) (this.ihM & 255), outputStream);
                this.ihM >>= 8;
                this.ihN -= 8;
            }
            e(outputStream);
        }
    }
}
