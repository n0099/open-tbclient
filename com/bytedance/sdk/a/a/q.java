package com.bytedance.sdk.a.a;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class q extends f {
    final transient byte[][] f;
    final transient int[] g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar, int i) {
        super(null);
        u.a(cVar.b, 0L, i);
        o oVar = cVar.pqm;
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            if (oVar.c == oVar.b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += oVar.c - oVar.b;
            i2++;
            oVar = oVar.pqy;
        }
        this.f = new byte[i2];
        this.g = new int[i2 * 2];
        o oVar2 = cVar.pqm;
        int i4 = 0;
        int i5 = 0;
        while (i5 < i) {
            this.f[i4] = oVar2.f3942a;
            int i6 = (oVar2.c - oVar2.b) + i5;
            if (i6 > i) {
                i6 = i;
            }
            this.g[i4] = i6;
            this.g[this.f.length + i4] = oVar2.b;
            oVar2.d = true;
            i4++;
            oVar2 = oVar2.pqy;
            i5 = i6;
        }
    }

    @Override // com.bytedance.sdk.a.a.f
    public String a() {
        return eoX().a();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String b() {
        return eoX().b();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String e() {
        return eoX().e();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f f() {
        return eoX().f();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f c() {
        return eoX().c();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f d() {
        return eoX().d();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f a(int i, int i2) {
        return eoX().a(i, i2);
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte a(int i) {
        u.a(this.g[this.f.length - 1], i, 1L);
        int b = b(i);
        return this.f[b][(i - (b == 0 ? 0 : this.g[b - 1])) + this.g[this.f.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ (-1);
    }

    @Override // com.bytedance.sdk.a.a.f
    public int g() {
        return this.g[this.f.length - 1];
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte[] h() {
        byte[] bArr = new byte[this.g[this.f.length - 1]];
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            System.arraycopy(this.f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.a.a.f
    public void a(c cVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            o oVar = new o(this.f[i], i3, (i3 + i4) - i2, true, false);
            if (cVar.pqm == null) {
                oVar.pqz = oVar;
                oVar.pqy = oVar;
                cVar.pqm = oVar;
            } else {
                cVar.pqm.pqz.a(oVar);
            }
            i++;
            i2 = i4;
        }
        cVar.b += i2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.g[b - 1];
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            if (!fVar.a(i2, this.f[b], (i - i4) + this.g[this.f.length + b], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.g[b - 1];
            int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
            if (!u.a(this.f[b], (i - i4) + this.g[this.f.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private f eoX() {
        return new f(h());
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof f) && ((f) obj).g() == g() && a(0, (f) obj, 0, g());
    }

    @Override // com.bytedance.sdk.a.a.f
    public int hashCode() {
        int i = this.d;
        if (i == 0) {
            i = 1;
            int length = this.f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.f[i2];
                int i4 = this.g[length + i2];
                int i5 = this.g[i2];
                int i6 = i4 + (i5 - i3);
                int i7 = i;
                while (i4 < i6) {
                    i7 = bArr[i4] + (i7 * 31);
                    i4++;
                }
                i2++;
                i3 = i5;
                i = i7;
            }
            this.d = i;
        }
        return i;
    }

    @Override // com.bytedance.sdk.a.a.f
    public String toString() {
        return eoX().toString();
    }
}
