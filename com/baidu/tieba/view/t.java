package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.InputStream;
import java.util.Vector;
/* loaded from: classes.dex */
public class t {
    protected Bitmap A;
    protected int H;
    protected short[] I;
    protected byte[] J;
    protected byte[] K;
    protected byte[] L;
    protected Vector M;
    protected int N;
    private int Q;
    protected InputStream a;
    protected int b;
    protected int c;
    protected int d;
    protected boolean e;
    protected int f;
    protected int[] h;
    protected int[] i;
    protected int[] j;
    protected int k;
    protected int l;
    protected int m;
    protected int n;
    protected boolean o;
    protected boolean p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected Bitmap z;
    protected int g = 1;
    protected byte[] B = new byte[256];
    protected int C = 0;
    protected int D = 0;
    protected int E = 0;
    protected boolean F = false;
    protected int G = 0;
    protected int O = 0;
    private volatile boolean P = false;

    public t(int i) {
        this.Q = 8388608;
        this.Q = i;
    }

    public boolean a() {
        return this.P;
    }

    public int a(int i) {
        this.G = -1;
        if (i >= 0 && i < this.N) {
            this.G = ((u) this.M.elementAt(i)).b;
        }
        return this.G;
    }

    public int b() {
        return this.N;
    }

    protected void c() {
        int i;
        int[] iArr = new int[this.c * this.d];
        if (this.E > 0) {
            if (this.E == 3) {
                int i2 = this.N - 2;
                if (i2 > 0) {
                    this.A = b(i2 - 1);
                } else {
                    this.A = null;
                }
            }
            if (this.A != null) {
                this.A.getPixels(iArr, 0, this.c, 0, 0, this.c, this.d);
                if (this.E == 2) {
                    int i3 = !this.F ? this.m : 0;
                    for (int i4 = 0; i4 < this.y; i4++) {
                        int i5 = ((this.w + i4) * this.c) + this.v;
                        int i6 = this.x + i5;
                        while (i5 < i6) {
                            iArr[i5] = i3;
                            i5++;
                        }
                    }
                }
            }
        }
        int i7 = 8;
        int i8 = 1;
        int i9 = 0;
        for (int i10 = 0; i10 < this.u; i10++) {
            if (this.p) {
                if (i9 >= this.u) {
                    i8++;
                    switch (i8) {
                        case 2:
                            i9 = 4;
                            break;
                        case 3:
                            i9 = 2;
                            i7 = 4;
                            break;
                        case 4:
                            i9 = 1;
                            i7 = 2;
                            break;
                    }
                }
                int i11 = i9;
                i9 += i7;
                i = i11;
            } else {
                i = i10;
            }
            int i12 = i + this.s;
            if (i12 < this.d) {
                int i13 = this.c * i12;
                int i14 = i13 + this.r;
                int i15 = this.t + i14;
                if (this.c + i13 < i15) {
                    i15 = this.c + i13;
                }
                int i16 = this.t * i10;
                int i17 = i14;
                while (i17 < i15) {
                    int i18 = i16 + 1;
                    int i19 = this.j[this.L[i16] & 255];
                    if (i19 != 0) {
                        iArr[i17] = i19;
                    }
                    i17++;
                    i16 = i18;
                }
            }
        }
        this.z = Bitmap.createBitmap(iArr, this.c, this.d, Bitmap.Config.ARGB_4444);
    }

    public Bitmap b(int i) {
        if (this.N <= 0) {
            return null;
        }
        return ((u) this.M.elementAt(i % this.N)).a;
    }

    public int a(InputStream inputStream) {
        if (this.P) {
            return 4;
        }
        f();
        if (inputStream != null) {
            this.a = inputStream;
            k();
            if (!e()) {
                i();
                com.baidu.tieba.d.ae.a(getClass().getName(), "read", "gif mem ==" + String.valueOf(this.O / 1024.0f) + "k");
                if (this.O >= this.Q) {
                    return 3;
                }
                if (this.N < 0) {
                    this.b = 1;
                }
            }
        } else {
            this.b = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
        if (this.P) {
            return 4;
        }
        return this.b;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00df */
    /* JADX DEBUG: Multi-variable search result rejected for r6v13, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    protected void d() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        short s;
        int i10 = this.t * this.u;
        if (this.L == null || this.L.length < i10) {
            this.L = new byte[i10];
        }
        if (this.I == null) {
            this.I = new short[4096];
        }
        if (this.J == null) {
            this.J = new byte[4096];
        }
        if (this.K == null) {
            this.K = new byte[4097];
        }
        int g = g();
        int i11 = 1 << g;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = g + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.I[i16] = 0;
            this.J[i16] = (byte) i16;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 0;
        while (i21 < i10) {
            if (i18 != 0) {
                i = i15;
                i2 = i19;
                i3 = i23;
                i4 = i14;
                i5 = i18;
                i6 = i20;
                i7 = i24;
                i8 = i13;
            } else if (i23 < i14) {
                if (i22 == 0) {
                    i22 = h();
                    if (i22 <= 0) {
                        break;
                    }
                    i25 = 0;
                }
                i20 += (this.B[i25] & 255) << i23;
                i23 += 8;
                i25++;
                i22--;
            } else {
                int i26 = i20 & i15;
                i20 >>= i14;
                i23 -= i14;
                if (i26 > i13 || i26 == i12) {
                    break;
                } else if (i26 == i11) {
                    i14 = g + 1;
                    i15 = (1 << i14) - 1;
                    i13 = i11 + 2;
                    i24 = -1;
                } else if (i24 == -1) {
                    this.K[i18] = this.J[i26];
                    i18++;
                    i24 = i26;
                    i19 = i26;
                } else {
                    if (i26 == i13) {
                        i9 = i18 + 1;
                        this.K[i18] = (byte) i19;
                        s = i24;
                    } else {
                        i9 = i18;
                        s = i26;
                    }
                    while (s > i11) {
                        this.K[i9] = this.J[s];
                        s = this.I[s];
                        i9++;
                    }
                    int i27 = this.J[s] & 255;
                    if (i13 >= 4096) {
                        break;
                    }
                    int i28 = i9 + 1;
                    this.K[i9] = (byte) i27;
                    this.I[i13] = (short) i24;
                    this.J[i13] = (byte) i27;
                    i8 = i13 + 1;
                    if ((i8 & i15) == 0 && i8 < 4096) {
                        i14++;
                        i15 += i8;
                    }
                    i6 = i20;
                    i7 = i26;
                    i = i15;
                    i2 = i27;
                    i3 = i23;
                    i4 = i14;
                    i5 = i28;
                }
            }
            int i29 = i5 - 1;
            this.L[i17] = this.K[i29];
            i21++;
            i17++;
            i14 = i4;
            i23 = i3;
            i19 = i2;
            i15 = i;
            int i30 = i7;
            i20 = i6;
            i18 = i29;
            i13 = i8;
            i24 = i30;
        }
        for (int i31 = i17; i31 < i10; i31++) {
            this.L[i31] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        return this.b != 0;
    }

    protected void f() {
        this.b = 0;
        this.N = 0;
        this.M = new Vector();
        this.h = null;
        this.i = null;
    }

    protected int g() {
        try {
            return this.a.read();
        } catch (Exception e) {
            this.b = 1;
            return 0;
        }
    }

    protected int h() {
        this.C = g();
        int i = 0;
        if (this.C > 0) {
            while (i < this.C) {
                try {
                    int read = this.a.read(this.B, i, this.C - i);
                    if (read == -1) {
                        break;
                    }
                    i += read;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i < this.C) {
                this.b = 1;
            }
        }
        return i;
    }

    protected int[] c(int i) {
        int i2;
        int i3 = i * 3;
        int[] iArr = null;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.a.read(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 < i3) {
            this.b = 1;
        } else {
            iArr = new int[256];
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                i4 = i7 + 1;
                iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            }
        }
        return iArr;
    }

    protected void i() {
        boolean z = false;
        while (!z && !e() && !this.P) {
            int g = g();
            if (this.O < this.Q) {
                switch (g) {
                    case 33:
                        switch (g()) {
                            case 1:
                                q();
                                continue;
                            case 249:
                                j();
                                continue;
                            case 254:
                                q();
                                continue;
                            case 255:
                                h();
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i = 0; i < 11; i++) {
                                    stringBuffer.append((char) this.B[i]);
                                }
                                if (stringBuffer.toString().equals("NETSCAPE2.0")) {
                                    n();
                                    break;
                                } else {
                                    q();
                                    continue;
                                }
                            default:
                                q();
                                continue;
                        }
                    case 44:
                        l();
                        break;
                    case 59:
                        z = true;
                        break;
                    default:
                        this.b = 1;
                        break;
                }
            } else {
                return;
            }
        }
    }

    protected void j() {
        g();
        int g = g();
        this.D = (g & 28) >> 2;
        if (this.D == 0) {
            this.D = 1;
        }
        this.F = (g & 1) != 0;
        this.G = o() * 10;
        this.G = this.G < 15 ? 100 : this.G;
        this.H = g();
        g();
    }

    protected void k() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append((char) g());
        }
        if (!stringBuffer.toString().startsWith("GIF")) {
            this.b = 1;
            return;
        }
        m();
        if (this.e && !e()) {
            this.h = c(this.f);
            this.l = this.h[this.k];
        }
    }

    protected void l() {
        int i = 0;
        this.r = o();
        this.s = o();
        this.t = o();
        this.u = o();
        int g = g();
        this.o = (g & DERTags.TAGGED) != 0;
        this.q = (int) Math.pow(2.0d, (g & 7) + 1);
        this.p = (g & 64) != 0;
        if (this.o) {
            this.i = c(this.q);
            this.j = this.i;
        } else {
            this.j = this.h;
            if (this.k == this.H) {
                this.l = 0;
            }
        }
        if (this.F) {
            int i2 = this.j[this.H];
            this.j[this.H] = 0;
            i = i2;
        }
        if (this.j == null) {
            this.b = 1;
        }
        if (!e()) {
            d();
            q();
            if (!e()) {
                this.N++;
                this.z = Bitmap.createBitmap(this.c, this.d, Bitmap.Config.ARGB_4444);
                c();
                this.M.addElement(new u(this.z, this.G));
                this.O += this.c * this.d * 2;
                if (this.F) {
                    this.j[this.H] = i;
                }
                p();
            }
        }
    }

    protected void m() {
        this.c = o();
        this.d = o();
        int g = g();
        this.e = (g & DERTags.TAGGED) != 0;
        this.f = 2 << (g & 7);
        this.k = g();
        this.n = g();
    }

    protected void n() {
        do {
            h();
            if (this.B[0] == 1) {
                this.g = (this.B[1] & 255) | ((this.B[2] & 255) << 8);
            }
            if (this.C <= 0) {
                return;
            }
        } while (!e());
    }

    protected int o() {
        return g() | (g() << 8);
    }

    protected void p() {
        this.E = this.D;
        this.v = this.r;
        this.w = this.s;
        this.x = this.t;
        this.y = this.u;
        this.A = this.z;
        this.m = this.l;
        this.D = 0;
        this.F = false;
        this.G = 0;
        this.i = null;
    }

    protected void q() {
        do {
            h();
            if (this.C <= 0) {
                return;
            }
        } while (!e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        this.P = true;
        if (this.M != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.M.size()) {
                    ((u) this.M.get(i2)).a = null;
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
