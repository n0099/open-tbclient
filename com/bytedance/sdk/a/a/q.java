package com.bytedance.sdk.a.a;

import d.c.c.a.a.c;
import d.c.c.a.a.n;
import d.c.c.a.a.s;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class q extends f {

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f26851f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f26852g;

    public q(c cVar, int i) {
        super(null);
        s.c(cVar.f65975f, 0L, i);
        n nVar = cVar.f65974e;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = nVar.f66002c;
            int i6 = nVar.f66001b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                nVar = nVar.f66005f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f26851f = new byte[i4];
        this.f26852g = new int[i4 * 2];
        n nVar2 = cVar.f65974e;
        int i7 = 0;
        while (i2 < i) {
            this.f26851f[i7] = nVar2.f66000a;
            i2 += nVar2.f66002c - nVar2.f66001b;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f26852g;
            iArr[i7] = i2;
            iArr[this.f26851f.length + i7] = nVar2.f66001b;
            nVar2.f66003d = true;
            i7++;
            nVar2 = nVar2.f66005f;
        }
    }

    @Override // com.bytedance.sdk.a.a.f
    public String a() {
        return j().a();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String b() {
        return j().b();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f c() {
        return j().c();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f d() {
        return j().d();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String e() {
        return j().e();
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.g() == g() && a(0, fVar, 0, g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.a.a.f
    public f f() {
        return j().f();
    }

    @Override // com.bytedance.sdk.a.a.f
    public int g() {
        return this.f26852g[this.f26851f.length - 1];
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte[] h() {
        int[] iArr = this.f26852g;
        byte[][] bArr = this.f26851f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f26852g;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f26851f[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public int hashCode() {
        int i = this.f26849d;
        if (i != 0) {
            return i;
        }
        int length = this.f26851f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f26851f[i2];
            int[] iArr = this.f26852g;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f26849d = i4;
        return i4;
    }

    public final int i(int i) {
        int binarySearch = Arrays.binarySearch(this.f26852g, 0, this.f26851f.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public final f j() {
        return new f(h());
    }

    @Override // com.bytedance.sdk.a.a.f
    public String toString() {
        return j().toString();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f a(int i, int i2) {
        return j().a(i, i2);
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte a(int i) {
        s.c(this.f26852g[this.f26851f.length - 1], i, 1L);
        int i2 = i(i);
        int i3 = i2 == 0 ? 0 : this.f26852g[i2 - 1];
        int[] iArr = this.f26852g;
        byte[][] bArr = this.f26851f;
        return bArr[i2][(i - i3) + iArr[bArr.length + i2]];
    }

    @Override // com.bytedance.sdk.a.a.f
    public void a(c cVar) {
        int length = this.f26851f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f26852g;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            n nVar = new n(this.f26851f[i], i3, (i3 + i4) - i2, true, false);
            n nVar2 = cVar.f65974e;
            if (nVar2 == null) {
                nVar.f66006g = nVar;
                nVar.f66005f = nVar;
                cVar.f65974e = nVar;
            } else {
                nVar2.f66006g.c(nVar);
            }
            i++;
            i2 = i4;
        }
        cVar.f65975f += i2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, f fVar, int i2, int i3) {
        if (i < 0 || i > g() - i3) {
            return false;
        }
        int i4 = i(i);
        while (i3 > 0) {
            int i5 = i4 == 0 ? 0 : this.f26852g[i4 - 1];
            int min = Math.min(i3, ((this.f26852g[i4] - i5) + i5) - i);
            int[] iArr = this.f26852g;
            byte[][] bArr = this.f26851f;
            if (!fVar.a(i2, bArr[i4], (i - i5) + iArr[bArr.length + i4], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            i4++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > g() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i(i);
        while (i3 > 0) {
            int i5 = i4 == 0 ? 0 : this.f26852g[i4 - 1];
            int min = Math.min(i3, ((this.f26852g[i4] - i5) + i5) - i);
            int[] iArr = this.f26852g;
            byte[][] bArr2 = this.f26851f;
            if (!s.e(bArr2[i4], (i - i5) + iArr[bArr2.length + i4], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            i4++;
        }
        return true;
    }
}
