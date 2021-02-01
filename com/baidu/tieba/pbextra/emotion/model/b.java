package com.baidu.tieba.pbextra.emotion.model;

import androidx.core.internal.view.SupportMenu;
import com.thunder.livesdk.system.ThunderNetStateService;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes2.dex */
class b {
    int mqA;
    int mqE;
    private int mqj;
    private int mqk;
    private byte[] mql;
    private int mqm;
    private int mqn;
    private int mqo;
    int mqp;
    int mqr;
    int mqy;
    int mqz;
    int mqq = 12;
    int mqs = 4096;
    int[] mqt = new int[5003];
    int[] mqu = new int[5003];
    int mqv = 5003;
    int mqw = 0;
    boolean mqx = false;
    int mqB = 0;
    int mqC = 0;
    int[] mqD = {0, 1, 3, 7, 15, 31, 63, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] mqF = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.mqj = i;
        this.mqk = i2;
        this.mql = bArr;
        this.mqm = Math.max(2, i3);
    }

    void a(byte b2, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mqF;
        int i = this.mqE;
        this.mqE = i + 1;
        bArr[i] = b2;
        if (this.mqE >= 254) {
            d(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        GF(this.mqv);
        this.mqw = this.mqz + 2;
        this.mqx = true;
        b(this.mqz, outputStream);
    }

    void GF(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mqt[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.mqy = i;
        this.mqx = false;
        this.mqp = this.mqy;
        this.mqr = GG(this.mqp);
        this.mqz = 1 << (i - 1);
        this.mqA = this.mqz + 1;
        this.mqw = this.mqz + 2;
        this.mqE = 0;
        int dvS = dvS();
        for (int i3 = this.mqv; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.mqv;
        GF(i5);
        b(this.mqz, outputStream);
        while (true) {
            int dvS2 = dvS();
            if (dvS2 != -1) {
                int i6 = (dvS2 << this.mqq) + dvS;
                int i7 = (dvS2 << i4) ^ dvS;
                if (this.mqt[i7] == i6) {
                    dvS = this.mqu[i7];
                } else {
                    if (this.mqt[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.mqt[i7] == i6) {
                                dvS = this.mqu[i7];
                                break;
                            }
                        } while (this.mqt[i7] >= 0);
                    }
                    b(dvS, outputStream);
                    if (this.mqw < this.mqs) {
                        int[] iArr = this.mqu;
                        int i9 = this.mqw;
                        this.mqw = i9 + 1;
                        iArr[i7] = i9;
                        this.mqt[i7] = i6;
                        dvS = dvS2;
                    } else {
                        c(outputStream);
                        dvS = dvS2;
                    }
                }
            } else {
                b(dvS, outputStream);
                b(this.mqA, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.mqm);
        this.mqn = this.mqj * this.mqk;
        this.mqo = 0;
        a(this.mqm + 1, outputStream);
        outputStream.write(0);
    }

    void d(OutputStream outputStream) throws IOException {
        if (this.mqE > 0) {
            outputStream.write(this.mqE);
            outputStream.write(this.mqF, 0, this.mqE);
            this.mqE = 0;
        }
    }

    final int GG(int i) {
        return (1 << i) - 1;
    }

    private int dvS() {
        if (this.mqn == 0) {
            return -1;
        }
        this.mqn--;
        byte[] bArr = this.mql;
        int i = this.mqo;
        this.mqo = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.mqB &= this.mqD[this.mqC];
        if (this.mqC > 0) {
            this.mqB |= i << this.mqC;
        } else {
            this.mqB = i;
        }
        this.mqC += this.mqp;
        while (this.mqC >= 8) {
            a((byte) (this.mqB & 255), outputStream);
            this.mqB >>= 8;
            this.mqC -= 8;
        }
        if (this.mqw > this.mqr || this.mqx) {
            if (this.mqx) {
                int i2 = this.mqy;
                this.mqp = i2;
                this.mqr = GG(i2);
                this.mqx = false;
            } else {
                this.mqp++;
                if (this.mqp == this.mqq) {
                    this.mqr = this.mqs;
                } else {
                    this.mqr = GG(this.mqp);
                }
            }
        }
        if (i == this.mqA) {
            while (this.mqC > 0) {
                a((byte) (this.mqB & 255), outputStream);
                this.mqB >>= 8;
                this.mqC -= 8;
            }
            d(outputStream);
        }
    }
}
