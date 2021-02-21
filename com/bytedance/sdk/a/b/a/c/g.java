package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements x.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<x> f5881a;
    private final int e;
    private final int i;
    private final int j;
    private final int k;
    private int l;
    private final com.bytedance.sdk.a.b.a.b.g ppK;
    private final c ppL;
    private final com.bytedance.sdk.a.b.a.b.c ppM;
    private final ab ppN;
    private final com.bytedance.sdk.a.b.h ppO;
    private final t ppP;

    public g(List<x> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2, int i, ab abVar, com.bytedance.sdk.a.b.h hVar, t tVar, int i2, int i3, int i4) {
        this.f5881a = list;
        this.ppM = cVar2;
        this.ppK = gVar;
        this.ppL = cVar;
        this.e = i;
        this.ppN = abVar;
        this.ppO = hVar;
        this.ppP = tVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public com.bytedance.sdk.a.b.l epp() {
        return this.ppM;
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

    public com.bytedance.sdk.a.b.a.b.g epq() {
        return this.ppK;
    }

    public c epr() {
        return this.ppL;
    }

    public com.bytedance.sdk.a.b.h eps() {
        return this.ppO;
    }

    public t ept() {
        return this.ppP;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public ab epu() {
        return this.ppN;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public com.bytedance.sdk.a.b.b b(ab abVar) throws IOException {
        return a(abVar, this.ppK, this.ppL, this.ppM);
    }

    public com.bytedance.sdk.a.b.b a(ab abVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2) throws IOException {
        if (this.e >= this.f5881a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.ppL != null && !this.ppM.a(abVar.eoR())) {
            throw new IllegalStateException("network interceptor " + this.f5881a.get(this.e - 1) + " must retain the same host and port");
        }
        if (this.ppL != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f5881a.get(this.e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f5881a, gVar, cVar, cVar2, this.e + 1, abVar, this.ppO, this.ppP, this.i, this.j, this.k);
        x xVar = this.f5881a.get(this.e);
        com.bytedance.sdk.a.b.b a2 = xVar.a(gVar2);
        if (cVar != null && this.e + 1 < this.f5881a.size() && gVar2.l != 1) {
            throw new IllegalStateException("network interceptor " + xVar + " must call proceed() exactly once");
        }
        if (a2 == null) {
            throw new NullPointerException("interceptor " + xVar + " returned null");
        }
        if (a2.epN() == null) {
            throw new IllegalStateException("interceptor " + xVar + " returned a response with no body");
        }
        return a2;
    }
}
