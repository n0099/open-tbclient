package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f6147a;

    /* renamed from: b  reason: collision with root package name */
    int f6148b;
    int c;
    boolean d;
    boolean e;
    o pie;
    o pif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f6147a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f6147a = bArr;
        this.f6148b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o eqh() {
        this.d = true;
        return new o(this.f6147a, this.f6148b, this.c, true, false);
    }

    public final o eqi() {
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
        o eqh;
        if (i <= 0 || i > this.c - this.f6148b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            eqh = eqh();
        } else {
            eqh = p.eqh();
            System.arraycopy(this.f6147a, this.f6148b, eqh.f6147a, 0, i);
        }
        eqh.c = eqh.f6148b + i;
        this.f6148b += i;
        this.pif.a(eqh);
        return eqh;
    }

    public final void c() {
        if (this.pif == this) {
            throw new IllegalStateException();
        }
        if (this.pif.e) {
            int i = this.c - this.f6148b;
            if (i <= (this.pif.d ? 0 : this.pif.f6148b) + (8192 - this.pif.c)) {
                a(this.pif, i);
                eqi();
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
            if ((oVar.c + i) - oVar.f6148b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f6147a, oVar.f6148b, oVar.f6147a, 0, oVar.c - oVar.f6148b);
            oVar.c -= oVar.f6148b;
            oVar.f6148b = 0;
        }
        System.arraycopy(this.f6147a, this.f6148b, oVar.f6147a, oVar.c, i);
        oVar.c += i;
        this.f6148b += i;
    }
}
