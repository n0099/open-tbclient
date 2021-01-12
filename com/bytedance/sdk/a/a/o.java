package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f5848a;

    /* renamed from: b  reason: collision with root package name */
    int f5849b;
    int c;
    boolean d;
    boolean e;
    o pdA;
    o pdB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f5848a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f5848a = bArr;
        this.f5849b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o emm() {
        this.d = true;
        return new o(this.f5848a, this.f5849b, this.c, true, false);
    }

    public final o emn() {
        o oVar = this.pdA != this ? this.pdA : null;
        this.pdB.pdA = this.pdA;
        this.pdA.pdB = this.pdB;
        this.pdA = null;
        this.pdB = null;
        return oVar;
    }

    public final o a(o oVar) {
        oVar.pdB = this;
        oVar.pdA = this.pdA;
        this.pdA.pdB = oVar;
        this.pdA = oVar;
        return oVar;
    }

    public final o Og(int i) {
        o emm;
        if (i <= 0 || i > this.c - this.f5849b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            emm = emm();
        } else {
            emm = p.emm();
            System.arraycopy(this.f5848a, this.f5849b, emm.f5848a, 0, i);
        }
        emm.c = emm.f5849b + i;
        this.f5849b += i;
        this.pdB.a(emm);
        return emm;
    }

    public final void c() {
        if (this.pdB == this) {
            throw new IllegalStateException();
        }
        if (this.pdB.e) {
            int i = this.c - this.f5849b;
            if (i <= (this.pdB.d ? 0 : this.pdB.f5849b) + (8192 - this.pdB.c)) {
                a(this.pdB, i);
                emn();
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
            if ((oVar.c + i) - oVar.f5849b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f5848a, oVar.f5849b, oVar.f5848a, 0, oVar.c - oVar.f5849b);
            oVar.c -= oVar.f5849b;
            oVar.f5849b = 0;
        }
        System.arraycopy(this.f5848a, this.f5849b, oVar.f5848a, oVar.c, i);
        oVar.c += i;
        this.f5849b += i;
    }
}
