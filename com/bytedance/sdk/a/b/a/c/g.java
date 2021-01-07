package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class g implements x.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<x> f6179a;
    private final int e;
    private final int i;
    private final int j;
    private final int k;
    private int l;
    private final com.bytedance.sdk.a.b.h pjA;
    private final t pjB;
    private final com.bytedance.sdk.a.b.a.b.g pjw;
    private final c pjx;
    private final com.bytedance.sdk.a.b.a.b.c pjy;
    private final ab pjz;

    public g(List<x> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2, int i, ab abVar, com.bytedance.sdk.a.b.h hVar, t tVar, int i2, int i3, int i4) {
        this.f6179a = list;
        this.pjy = cVar2;
        this.pjw = gVar;
        this.pjx = cVar;
        this.e = i;
        this.pjz = abVar;
        this.pjA = hVar;
        this.pjB = tVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public com.bytedance.sdk.a.b.l eqJ() {
        return this.pjy;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public int b() {
        return this.i;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public int c() {
        return this.j;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public int d() {
        return this.k;
    }

    public com.bytedance.sdk.a.b.a.b.g eqK() {
        return this.pjw;
    }

    public c eqL() {
        return this.pjx;
    }

    public com.bytedance.sdk.a.b.h eqM() {
        return this.pjA;
    }

    public t eqN() {
        return this.pjB;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public ab eqO() {
        return this.pjz;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public com.bytedance.sdk.a.b.b b(ab abVar) throws IOException {
        return a(abVar, this.pjw, this.pjx, this.pjy);
    }

    public com.bytedance.sdk.a.b.b a(ab abVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2) throws IOException {
        if (this.e >= this.f6179a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.pjx != null && !this.pjy.a(abVar.eql())) {
            throw new IllegalStateException("network interceptor " + this.f6179a.get(this.e - 1) + " must retain the same host and port");
        }
        if (this.pjx != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f6179a.get(this.e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f6179a, gVar, cVar, cVar2, this.e + 1, abVar, this.pjA, this.pjB, this.i, this.j, this.k);
        x xVar = this.f6179a.get(this.e);
        com.bytedance.sdk.a.b.b a2 = xVar.a(gVar2);
        if (cVar != null && this.e + 1 < this.f6179a.size() && gVar2.l != 1) {
            throw new IllegalStateException("network interceptor " + xVar + " must call proceed() exactly once");
        }
        if (a2 == null) {
            throw new NullPointerException("interceptor " + xVar + " returned null");
        }
        if (a2.erh() == null) {
            throw new IllegalStateException("interceptor " + xVar + " returned a response with no body");
        }
        return a2;
    }
}
