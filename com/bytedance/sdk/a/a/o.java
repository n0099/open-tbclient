package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f6148a;

    /* renamed from: b  reason: collision with root package name */
    int f6149b;
    int c;
    boolean d;
    boolean e;
    o pie;
    o pif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f6148a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f6148a = bArr;
        this.f6149b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o eqi() {
        this.d = true;
        return new o(this.f6148a, this.f6149b, this.c, true, false);
    }

    public final o eqj() {
        o oVar = this.pie != this ? this.pie : null;
        this.pif.pie = this.pie;
        this.pie.pif = this.pif;
        this.pie = null;
        this.pif = null;
        return oVar;
    }

    public final o a(o oVar) {
        oVar.pif = this;
        oVar.pie = this.pie;
        this.pie.pif = oVar;
        this.pie = oVar;
        return oVar;
    }

    public final o PN(int i) {
        o eqi;
        if (i <= 0 || i > this.c - this.f6149b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            eqi = eqi();
        } else {
            eqi = p.eqi();
            System.arraycopy(this.f6148a, this.f6149b, eqi.f6148a, 0, i);
        }
        eqi.c = eqi.f6149b + i;
        this.f6149b += i;
        this.pif.a(eqi);
        return eqi;
    }

    public final void c() {
        if (this.pif == this) {
            throw new IllegalStateException();
        }
        if (this.pif.e) {
            int i = this.c - this.f6149b;
            if (i <= (this.pif.d ? 0 : this.pif.f6149b) + (8192 - this.pif.c)) {
                a(this.pif, i);
                eqj();
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
            if ((oVar.c + i) - oVar.f6149b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f6148a, oVar.f6149b, oVar.f6148a, 0, oVar.c - oVar.f6149b);
            oVar.c -= oVar.f6149b;
            oVar.f6149b = 0;
        }
        System.arraycopy(this.f6148a, this.f6149b, oVar.f6148a, oVar.c, i);
        oVar.c += i;
        this.f6149b += i;
    }
}
