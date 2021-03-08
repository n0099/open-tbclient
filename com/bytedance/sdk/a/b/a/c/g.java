package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class g implements x.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<x> f3962a;
    private final int e;
    private final int i;
    private final int j;
    private final int k;
    private int l;
    private final com.bytedance.sdk.a.b.a.b.g prP;
    private final c prQ;
    private final com.bytedance.sdk.a.b.a.b.c prR;
    private final ab prS;
    private final com.bytedance.sdk.a.b.h prT;
    private final t prU;

    public g(List<x> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2, int i, ab abVar, com.bytedance.sdk.a.b.h hVar, t tVar, int i2, int i3, int i4) {
        this.f3962a = list;
        this.prR = cVar2;
        this.prP = gVar;
        this.prQ = cVar;
        this.e = i;
        this.prS = abVar;
        this.prT = hVar;
        this.prU = tVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public com.bytedance.sdk.a.b.l epw() {
        return this.prR;
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

    public com.bytedance.sdk.a.b.a.b.g epx() {
        return this.prP;
    }

    public c epy() {
        return this.prQ;
    }

    public com.bytedance.sdk.a.b.h epz() {
        return this.prT;
    }

    public t epA() {
        return this.prU;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public ab epB() {
        return this.prS;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public com.bytedance.sdk.a.b.b b(ab abVar) throws IOException {
        return a(abVar, this.prP, this.prQ, this.prR);
    }

    public com.bytedance.sdk.a.b.b a(ab abVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2) throws IOException {
        if (this.e >= this.f3962a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.prQ != null && !this.prR.a(abVar.eoY())) {
            throw new IllegalStateException("network interceptor " + this.f3962a.get(this.e - 1) + " must retain the same host and port");
        }
        if (this.prQ != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f3962a.get(this.e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f3962a, gVar, cVar, cVar2, this.e + 1, abVar, this.prT, this.prU, this.i, this.j, this.k);
        x xVar = this.f3962a.get(this.e);
        com.bytedance.sdk.a.b.b a2 = xVar.a(gVar2);
        if (cVar != null && this.e + 1 < this.f3962a.size() && gVar2.l != 1) {
            throw new IllegalStateException("network interceptor " + xVar + " must call proceed() exactly once");
        }
        if (a2 == null) {
            throw new NullPointerException("interceptor " + xVar + " returned null");
        }
        if (a2.epU() == null) {
            throw new IllegalStateException("interceptor " + xVar + " returned a response with no body");
        }
        return a2;
    }
}
