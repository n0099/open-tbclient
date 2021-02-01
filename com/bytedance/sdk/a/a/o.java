package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f5850a;

    /* renamed from: b  reason: collision with root package name */
    int f5851b;
    int c;
    boolean d;
    boolean e;
    o pnO;
    o pnP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.f5850a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f5850a = bArr;
        this.f5851b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o eoG() {
        this.d = true;
        return new o(this.f5850a, this.f5851b, this.c, true, false);
    }

    public final o eoH() {
        o oVar = this.pnO != this ? this.pnO : null;
        this.pnP.pnO = this.pnO;
        this.pnO.pnP = this.pnP;
        this.pnO = null;
        this.pnP = null;
        return oVar;
    }

    public final o a(o oVar) {
        oVar.pnP = this;
        oVar.pnO = this.pnO;
        this.pnO.pnP = oVar;
        this.pnO = oVar;
        return oVar;
    }

    public final o OB(int i) {
        o eoG;
        if (i <= 0 || i > this.c - this.f5851b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            eoG = eoG();
        } else {
            eoG = p.eoG();
            System.arraycopy(this.f5850a, this.f5851b, eoG.f5850a, 0, i);
        }
        eoG.c = eoG.f5851b + i;
        this.f5851b += i;
        this.pnP.a(eoG);
        return eoG;
    }

    public final void c() {
        if (this.pnP == this) {
            throw new IllegalStateException();
        }
        if (this.pnP.e) {
            int i = this.c - this.f5851b;
            if (i <= (this.pnP.d ? 0 : this.pnP.f5851b) + (8192 - this.pnP.c)) {
                a(this.pnP, i);
                eoH();
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
            if ((oVar.c + i) - oVar.f5851b > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(oVar.f5850a, oVar.f5851b, oVar.f5850a, 0, oVar.c - oVar.f5851b);
            oVar.c -= oVar.f5851b;
            oVar.f5851b = 0;
        }
        System.arraycopy(this.f5850a, this.f5851b, oVar.f5850a, oVar.c, i);
        oVar.c += i;
        this.f5851b += i;
    }
}
