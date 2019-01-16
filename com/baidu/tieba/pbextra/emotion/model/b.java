package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    int gsC;
    private int gsh;
    private int gsi;
    private byte[] gsj;
    private int gsk;
    private int gsl;
    private int gsm;
    int gsn;
    int gsp;
    int gsw;
    int gsx;
    int gsy;
    int gso = 12;
    int gsq = 4096;
    int[] gsr = new int[5003];
    int[] gss = new int[5003];
    int gst = 5003;
    int gsu = 0;
    boolean gsv = false;
    int gsz = 0;
    int gsA = 0;
    int[] gsB = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] gsD = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.gsh = i;
        this.gsi = i2;
        this.gsj = bArr;
        this.gsk = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.gsD;
        int i = this.gsC;
        this.gsC = i + 1;
        bArr[i] = b;
        if (this.gsC >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        ti(this.gst);
        this.gsu = this.gsx + 2;
        this.gsv = true;
        b(this.gsx, outputStream);
    }

    void ti(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.gsr[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.gsw = i;
        this.gsv = false;
        this.gsn = this.gsw;
        this.gsp = tj(this.gsn);
        this.gsx = 1 << (i - 1);
        this.gsy = this.gsx + 1;
        this.gsu = this.gsx + 2;
        this.gsC = 0;
        int bps = bps();
        for (int i3 = this.gst; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.gst;
        ti(i5);
        b(this.gsx, outputStream);
        while (true) {
            int bps2 = bps();
            if (bps2 != -1) {
                int i6 = (bps2 << this.gso) + bps;
                int i7 = (bps2 << i4) ^ bps;
                if (this.gsr[i7] == i6) {
                    bps = this.gss[i7];
                } else {
                    if (this.gsr[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.gsr[i7] == i6) {
                                bps = this.gss[i7];
                                break;
                            }
                        } while (this.gsr[i7] >= 0);
                    }
                    b(bps, outputStream);
                    if (this.gsu < this.gsq) {
                        int[] iArr = this.gss;
                        int i9 = this.gsu;
                        this.gsu = i9 + 1;
                        iArr[i7] = i9;
                        this.gsr[i7] = i6;
                        bps = bps2;
                    } else {
                        f(outputStream);
                        bps = bps2;
                    }
                }
            } else {
                b(bps, outputStream);
                b(this.gsy, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.gsk);
        this.gsl = this.gsh * this.gsi;
        this.gsm = 0;
        a(this.gsk + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.gsC > 0) {
            outputStream.write(this.gsC);
            outputStream.write(this.gsD, 0, this.gsC);
            this.gsC = 0;
        }
    }

    final int tj(int i) {
        return (1 << i) - 1;
    }

    private int bps() {
        if (this.gsl == 0) {
            return -1;
        }
        this.gsl--;
        byte[] bArr = this.gsj;
        int i = this.gsm;
        this.gsm = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.gsz &= this.gsB[this.gsA];
        if (this.gsA > 0) {
            this.gsz |= i << this.gsA;
        } else {
            this.gsz = i;
        }
        this.gsA += this.gsn;
        while (this.gsA >= 8) {
            a((byte) (this.gsz & 255), outputStream);
            this.gsz >>= 8;
            this.gsA -= 8;
        }
        if (this.gsu > this.gsp || this.gsv) {
            if (this.gsv) {
                int i2 = this.gsw;
                this.gsn = i2;
                this.gsp = tj(i2);
                this.gsv = false;
            } else {
                this.gsn++;
                if (this.gsn == this.gso) {
                    this.gsp = this.gsq;
                } else {
                    this.gsp = tj(this.gsn);
                }
            }
        }
        if (i == this.gsy) {
            while (this.gsA > 0) {
                a((byte) (this.gsz & 255), outputStream);
                this.gsz >>= 8;
                this.gsA -= 8;
            }
            g(outputStream);
        }
    }
}
