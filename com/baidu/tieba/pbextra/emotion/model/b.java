package com.baidu.tieba.pbextra.emotion.model;

import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
class b {
    private int msB;
    private int msC;
    private byte[] msD;
    private int msE;
    private int msF;
    private int msG;
    int msH;
    int msJ;
    int msQ;
    int msR;
    int msS;
    int msW;
    int msI = 12;
    int msK = 4096;
    int[] msL = new int[5003];
    int[] msM = new int[5003];
    int msN = 5003;
    int msO = 0;
    boolean msP = false;
    int msT = 0;
    int msU = 0;
    int[] msV = {0, 1, 3, 7, 15, 31, 63, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] msX = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.msB = i;
        this.msC = i2;
        this.msD = bArr;
        this.msE = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.msX;
        int i = this.msW;
        this.msW = i + 1;
        bArr[i] = b;
        if (this.msW >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        GI(this.msN);
        this.msO = this.msR + 2;
        this.msP = true;
        b(this.msR, outputStream);
    }

    void GI(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.msL[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.msQ = i;
        this.msP = false;
        this.msH = this.msQ;
        this.msJ = GJ(this.msH);
        this.msR = 1 << (i - 1);
        this.msS = this.msR + 1;
        this.msO = this.msR + 2;
        this.msW = 0;
        int dwi = dwi();
        for (int i3 = this.msN; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.msN;
        GI(i5);
        b(this.msR, outputStream);
        while (true) {
            int dwi2 = dwi();
            if (dwi2 != -1) {
                int i6 = (dwi2 << this.msI) + dwi;
                int i7 = (dwi2 << i4) ^ dwi;
                if (this.msL[i7] == i6) {
                    dwi = this.msM[i7];
                } else {
                    if (this.msL[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.msL[i7] == i6) {
                                dwi = this.msM[i7];
                                break;
                            }
                        } while (this.msL[i7] >= 0);
                    }
                    b(dwi, outputStream);
                    if (this.msO < this.msK) {
                        int[] iArr = this.msM;
                        int i9 = this.msO;
                        this.msO = i9 + 1;
                        iArr[i7] = i9;
                        this.msL[i7] = i6;
                        dwi = dwi2;
                    } else {
                        c(outputStream);
                        dwi = dwi2;
                    }
                }
            } else {
                b(dwi, outputStream);
                b(this.msS, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.msE);
        this.msF = this.msB * this.msC;
        this.msG = 0;
        a(this.msE + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.msW > 0) {
            outputStream.write(this.msW);
            outputStream.write(this.msX, 0, this.msW);
            this.msW = 0;
        }
    }

    final int GJ(int i) {
        return (1 << i) - 1;
    }

    private int dwi() {
        if (this.msF == 0) {
            return -1;
        }
        this.msF--;
        byte[] bArr = this.msD;
        int i = this.msG;
        this.msG = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.msT &= this.msV[this.msU];
        if (this.msU > 0) {
            this.msT |= i << this.msU;
        } else {
            this.msT = i;
        }
        this.msU += this.msH;
        while (this.msU >= 8) {
            a((byte) (this.msT & 255), outputStream);
            this.msT >>= 8;
            this.msU -= 8;
        }
        if (this.msO > this.msJ || this.msP) {
            if (this.msP) {
                int i2 = this.msQ;
                this.msH = i2;
                this.msJ = GJ(i2);
                this.msP = false;
            } else {
                this.msH++;
                if (this.msH == this.msI) {
                    this.msJ = this.msK;
                } else {
                    this.msJ = GJ(this.msH);
                }
            }
        }
        if (i == this.msS) {
            while (this.msU > 0) {
                a((byte) (this.msT & 255), outputStream);
                this.msT >>= 8;
                this.msU -= 8;
            }
            d(outputStream);
        }
    }
}
