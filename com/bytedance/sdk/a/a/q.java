package com.bytedance.sdk.a.a;

import d.b.c.a.a.c;
import d.b.c.a.a.n;
import d.b.c.a.a.s;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class q extends f {

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f26847f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f26848g;

    public q(c cVar, int i2) {
        super(null);
        s.c(cVar.f65162f, 0L, i2);
        n nVar = cVar.f65161e;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = nVar.f65190c;
            int i7 = nVar.f65189b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                nVar = nVar.f65193f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f26847f = new byte[i5];
        this.f26848g = new int[i5 * 2];
        n nVar2 = cVar.f65161e;
        int i8 = 0;
        while (i3 < i2) {
            this.f26847f[i8] = nVar2.f65188a;
            i3 += nVar2.f65190c - nVar2.f65189b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f26848g;
            iArr[i8] = i3;
            iArr[this.f26847f.length + i8] = nVar2.f65189b;
            nVar2.f65191d = true;
            i8++;
            nVar2 = nVar2.f65193f;
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
        return this.f26848g[this.f26847f.length - 1];
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte[] h() {
        int[] iArr = this.f26848g;
        byte[][] bArr = this.f26847f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f26848g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f26847f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public int hashCode() {
        int i2 = this.f26845d;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f26847f.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f26847f[i3];
            int[] iArr = this.f26848g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f26845d = i5;
        return i5;
    }

    public final int i(int i2) {
        int binarySearch = Arrays.binarySearch(this.f26848g, 0, this.f26847f.length, i2 + 1);
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
    public f a(int i2, int i3) {
        return j().a(i2, i3);
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte a(int i2) {
        s.c(this.f26848g[this.f26847f.length - 1], i2, 1L);
        int i3 = i(i2);
        int i4 = i3 == 0 ? 0 : this.f26848g[i3 - 1];
        int[] iArr = this.f26848g;
        byte[][] bArr = this.f26847f;
        return bArr[i3][(i2 - i4) + iArr[bArr.length + i3]];
    }

    @Override // com.bytedance.sdk.a.a.f
    public void a(c cVar) {
        int length = this.f26847f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f26848g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            n nVar = new n(this.f26847f[i2], i4, (i4 + i5) - i3, true, false);
            n nVar2 = cVar.f65161e;
            if (nVar2 == null) {
                nVar.f65194g = nVar;
                nVar.f65193f = nVar;
                cVar.f65161e = nVar;
            } else {
                nVar2.f65194g.c(nVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f65162f += i3;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > g() - i4) {
            return false;
        }
        int i5 = i(i2);
        while (i4 > 0) {
            int i6 = i5 == 0 ? 0 : this.f26848g[i5 - 1];
            int min = Math.min(i4, ((this.f26848g[i5] - i6) + i6) - i2);
            int[] iArr = this.f26848g;
            byte[][] bArr = this.f26847f;
            if (!fVar.a(i3, bArr[i5], (i2 - i6) + iArr[bArr.length + i5], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            i5++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > g() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i(i2);
        while (i4 > 0) {
            int i6 = i5 == 0 ? 0 : this.f26848g[i5 - 1];
            int min = Math.min(i4, ((this.f26848g[i5] - i6) + i6) - i2);
            int[] iArr = this.f26848g;
            byte[][] bArr2 = this.f26847f;
            if (!s.e(bArr2[i5], (i2 - i6) + iArr[bArr2.length + i5], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            i5++;
        }
        return true;
    }
}
