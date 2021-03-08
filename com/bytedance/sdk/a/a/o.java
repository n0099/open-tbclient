package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f3942a;
    int b;
    int c;
    boolean d;
    boolean e;
    o pqy;
    o pqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f3942a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3942a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o eoV() {
        this.d = true;
        return new o(this.f3942a, this.b, this.c, true, false);
    }

    public final o eoW() {
        o oVar = this.pqy != this ? this.pqy : null;
        this.pqz.pqy = this.pqy;
        this.pqy.pqz = this.pqz;
        this.pqy = null;
        this.pqz = null;
        return oVar;
    }

    public final o a(o oVar) {
        oVar.pqz = this;
        oVar.pqy = this.pqy;
        this.pqy.pqz = oVar;
        this.pqy = oVar;
        return oVar;
    }

    public final o OG(int i) {
        o eoV;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            eoV = eoV();
        } else {
            eoV = p.eoV();
            System.arraycopy(this.f3942a, this.b, eoV.f3942a, 0, i);
        }
        eoV.c = eoV.b + i;
        this.b += i;
        this.pqz.a(eoV);
        return eoV;
    }

    public final void c() {
        if (this.pqz == this) {
            throw new IllegalStateException();
        }
        if (this.pqz.e) {
            int i = this.c - this.b;
            if (i <= (this.pqz.d ? 0 : this.pqz.b) + (8192 - this.pqz.c)) {
                a(this.pqz, i);
                eoW();
                p.b(this);
            }
        }
    }

    public final void a(o oVar, int i) {
        if (!oVar.e) {
            throw new IllegalArgumentException();
        }
        if (oVar.c + i > 8192) {
            if (oVar.d) {
                throw new IllegalArgumentException();
            }
            if ((oVar.c + i) - oVar.b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f3942a, oVar.b, oVar.f3942a, 0, oVar.c - oVar.b);
            oVar.c -= oVar.b;
            oVar.b = 0;
        }
        System.arraycopy(this.f3942a, this.b, oVar.f3942a, oVar.c, i);
        oVar.c += i;
        this.b += i;
    }
}
