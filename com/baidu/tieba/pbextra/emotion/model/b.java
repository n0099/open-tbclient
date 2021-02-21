package com.baidu.tieba.pbextra.emotion.model;

import androidx.core.internal.view.SupportMenu;
import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
class b {
    private byte[] mqA;
    private int mqB;
    private int mqC;
    private int mqD;
    int mqE;
    int mqG;
    int mqN;
    int mqO;
    int mqP;
    int mqT;
    private int mqy;
    private int mqz;
    int mqF = 12;
    int mqH = 4096;
    int[] mqI = new int[5003];
    int[] mqJ = new int[5003];
    int mqK = 5003;
    int mqL = 0;
    boolean mqM = false;
    int mqQ = 0;
    int mqR = 0;
    int[] mqS = {0, 1, 3, 7, 15, 31, 63, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] mqU = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mqy = i;
        this.mqz = i2;
        this.mqA = bArr;
        this.mqB = Math.max(2, i3);
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mqU;
        int i = this.mqT;
        this.mqT = i + 1;
        bArr[i] = b2;
        if (this.mqT >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        GF(this.mqK);
        this.mqL = this.mqO + 2;
        this.mqM = true;
        b(this.mqO, outputStream);
    }

    void GF(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mqI[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mqN = i;
        this.mqM = false;
        this.mqE = this.mqN;
        this.mqG = GG(this.mqE);
        this.mqO = 1 << (i - 1);
        this.mqP = this.mqO + 1;
        this.mqL = this.mqO + 2;
        this.mqT = 0;
        int dvZ = dvZ();
        for (int i3 = this.mqK; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mqK;
        GF(i5);
        b(this.mqO, outputStream);
        while (true) {
            int dvZ2 = dvZ();
            if (dvZ2 != -1) {
                int i6 = (dvZ2 << this.mqF) + dvZ;
                int i7 = (dvZ2 << i4) ^ dvZ;
                if (this.mqI[i7] == i6) {
                    dvZ = this.mqJ[i7];
                } else {
                    if (this.mqI[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mqI[i7] == i6) {
                                dvZ = this.mqJ[i7];
                                break;
                            }
                        } while (this.mqI[i7] >= 0);
                    }
                    b(dvZ, outputStream);
                    if (this.mqL < this.mqH) {
                        int[] iArr = this.mqJ;
                        int i9 = this.mqL;
                        this.mqL = i9 + 1;
                        iArr[i7] = i9;
                        this.mqI[i7] = i6;
                        dvZ = dvZ2;
                    } else {
                        c(outputStream);
                        dvZ = dvZ2;
                    }
                }
            } else {
                b(dvZ, outputStream);
                b(this.mqP, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mqB);
        this.mqC = this.mqy * this.mqz;
        this.mqD = 0;
        a(this.mqB + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mqT > 0) {
            outputStream.write(this.mqT);
            outputStream.write(this.mqU, 0, this.mqT);
            this.mqT = 0;
        }
    }

    final int GG(int i) {
        return (1 << i) - 1;
    }

    private int dvZ() {
        if (this.mqC == 0) {
            return -1;
        }
        this.mqC--;
        byte[] bArr = this.mqA;
        int i = this.mqD;
        this.mqD = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mqQ &= this.mqS[this.mqR];
        if (this.mqR > 0) {
            this.mqQ |= i << this.mqR;
        } else {
            this.mqQ = i;
        }
        this.mqR += this.mqE;
        while (this.mqR >= 8) {
            a((byte) (this.mqQ & 255), outputStream);
            this.mqQ >>= 8;
            this.mqR -= 8;
        }
        if (this.mqL > this.mqG || this.mqM) {
            if (this.mqM) {
                int i2 = this.mqN;
                this.mqE = i2;
                this.mqG = GG(i2);
                this.mqM = false;
            } else {
                this.mqE++;
                if (this.mqE == this.mqF) {
                    this.mqG = this.mqH;
                } else {
                    this.mqG = GG(this.mqE);
                }
            }
        }
        if (i == this.mqP) {
            while (this.mqR > 0) {
                a((byte) (this.mqQ & 255), outputStream);
                this.mqQ >>= 8;
                this.mqR -= 8;
            }
            d(outputStream);
        }
    }
}
