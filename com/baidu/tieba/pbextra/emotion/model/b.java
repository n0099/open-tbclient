package com.baidu.tieba.pbextra.emotion.model;

import android.support.v4.internal.view.SupportMenu;
import com.baidu.baiduarsdk.ArBridge;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
class b {
    int gsD;
    private int gsi;
    private int gsj;
    private byte[] gsk;
    private int gsl;
    private int gsm;
    private int gsn;
    int gso;
    int gsq;
    int gsx;
    int gsy;
    int gsz;
    int gsp = 12;
    int gsr = 4096;
    int[] gss = new int[5003];
    int[] gst = new int[5003];
    int gsu = 5003;
    int gsv = 0;
    boolean gsw = false;
    int gsA = 0;
    int gsB = 0;
    int[] gsC = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, ArBridge.MessageType.MSG_TYPE_VIDEO_PAUSE, 2047, 4095, 8191, 16383, 32767, SupportMenu.USER_MASK};
    byte[] gsE = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, int i2, byte[] bArr, int i3) {
        this.gsi = i;
        this.gsj = i2;
        this.gsk = bArr;
        this.gsl = Math.max(2, i3);
    }

    void a(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.gsE;
        int i = this.gsD;
        this.gsD = i + 1;
        bArr[i] = b;
        if (this.gsD >= 254) {
            g(outputStream);
        }
    }

    void f(OutputStream outputStream) throws IOException {
        ti(this.gsu);
        this.gsv = this.gsy + 2;
        this.gsw = true;
        b(this.gsy, outputStream);
    }

    void ti(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.gss[i2] = -1;
        }
    }

    void a(int i, OutputStream outputStream) throws IOException {
        int i2 = 0;
        this.gsx = i;
        this.gsw = false;
        this.gso = this.gsx;
        this.gsq = tj(this.gso);
        this.gsy = 1 << (i - 1);
        this.gsz = this.gsy + 1;
        this.gsv = this.gsy + 2;
        this.gsD = 0;
        int bps = bps();
        for (int i3 = this.gsu; i3 < 65536; i3 *= 2) {
            i2++;
        }
        int i4 = 8 - i2;
        int i5 = this.gsu;
        ti(i5);
        b(this.gsy, outputStream);
        while (true) {
            int bps2 = bps();
            if (bps2 != -1) {
                int i6 = (bps2 << this.gsp) + bps;
                int i7 = (bps2 << i4) ^ bps;
                if (this.gss[i7] == i6) {
                    bps = this.gst[i7];
                } else {
                    if (this.gss[i7] >= 0) {
                        int i8 = i5 - i7;
                        if (i7 == 0) {
                            i8 = 1;
                        }
                        do {
                            i7 -= i8;
                            if (i7 < 0) {
                                i7 += i5;
                            }
                            if (this.gss[i7] == i6) {
                                bps = this.gst[i7];
                                break;
                            }
                        } while (this.gss[i7] >= 0);
                    }
                    b(bps, outputStream);
                    if (this.gsv < this.gsr) {
                        int[] iArr = this.gst;
                        int i9 = this.gsv;
                        this.gsv = i9 + 1;
                        iArr[i7] = i9;
                        this.gss[i7] = i6;
                        bps = bps2;
                    } else {
                        f(outputStream);
                        bps = bps2;
                    }
                }
            } else {
                b(bps, outputStream);
                b(this.gsz, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void encode(OutputStream outputStream) throws IOException {
        outputStream.write(this.gsl);
        this.gsm = this.gsi * this.gsj;
        this.gsn = 0;
        a(this.gsl + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        if (this.gsD > 0) {
            outputStream.write(this.gsD);
            outputStream.write(this.gsE, 0, this.gsD);
            this.gsD = 0;
        }
    }

    final int tj(int i) {
        return (1 << i) - 1;
    }

    private int bps() {
        if (this.gsm == 0) {
            return -1;
        }
        this.gsm--;
        byte[] bArr = this.gsk;
        int i = this.gsn;
        this.gsn = i + 1;
        return bArr[i] & 255;
    }

    void b(int i, OutputStream outputStream) throws IOException {
        this.gsA &= this.gsC[this.gsB];
        if (this.gsB > 0) {
            this.gsA |= i << this.gsB;
        } else {
            this.gsA = i;
        }
        this.gsB += this.gso;
        while (this.gsB >= 8) {
            a((byte) (this.gsA & 255), outputStream);
            this.gsA >>= 8;
            this.gsB -= 8;
        }
        if (this.gsv > this.gsq || this.gsw) {
            if (this.gsw) {
                int i2 = this.gsx;
                this.gso = i2;
                this.gsq = tj(i2);
                this.gsw = false;
            } else {
                this.gso++;
                if (this.gso == this.gsp) {
                    this.gsq = this.gsr;
                } else {
                    this.gsq = tj(this.gso);
                }
            }
        }
        if (i == this.gsz) {
            while (this.gsB > 0) {
                a((byte) (this.gsA & 255), outputStream);
                this.gsA >>= 8;
                this.gsB -= 8;
            }
            g(outputStream);
        }
    }
}
