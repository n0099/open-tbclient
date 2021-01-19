package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.x;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class g implements x.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<x> f5879a;
    private final int e;
    private final int i;
    private final int j;
    private final int k;
    private int l;
    private final com.bytedance.sdk.a.b.a.b.g peS;
    private final c peT;
    private final com.bytedance.sdk.a.b.a.b.c peU;
    private final ab peV;
    private final com.bytedance.sdk.a.b.h peW;
    private final t peX;

    public g(List<x> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2, int i, ab abVar, com.bytedance.sdk.a.b.h hVar, t tVar, int i2, int i3, int i4) {
        this.f5879a = list;
        this.peU = cVar2;
        this.peS = gVar;
        this.peT = cVar;
        this.e = i;
        this.peV = abVar;
        this.peW = hVar;
        this.peX = tVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    public com.bytedance.sdk.a.b.l emN() {
        return this.peU;
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

    public com.bytedance.sdk.a.b.a.b.g emO() {
        return this.peS;
    }

    public c emP() {
        return this.peT;
    }

    public com.bytedance.sdk.a.b.h emQ() {
        return this.peW;
    }

    public t emR() {
        return this.peX;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public ab emS() {
        return this.peV;
    }

    @Override // com.bytedance.sdk.a.b.x.a
    public com.bytedance.sdk.a.b.b b(ab abVar) throws IOException {
        return a(abVar, this.peS, this.peT, this.peU);
    }

    public com.bytedance.sdk.a.b.b a(ab abVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2) throws IOException {
        if (this.e >= this.f5879a.size()) {
            throw new AssertionError();
        }
        this.l++;
        if (this.peT != null && !this.peU.a(abVar.emp())) {
            throw new IllegalStateException("network interceptor " + this.f5879a.get(this.e - 1) + " must retain the same host and port");
        }
        if (this.peT != null && this.l > 1) {
            throw new IllegalStateException("network interceptor " + this.f5879a.get(this.e - 1) + " must call proceed() exactly once");
        }
        g gVar2 = new g(this.f5879a, gVar, cVar, cVar2, this.e + 1, abVar, this.peW, this.peX, this.i, this.j, this.k);
        x xVar = this.f5879a.get(this.e);
        com.bytedance.sdk.a.b.b a2 = xVar.a(gVar2);
        if (cVar != null && this.e + 1 < this.f5879a.size() && gVar2.l != 1) {
            throw new IllegalStateException("network interceptor " + xVar + " must call proceed() exactly once");
        }
        if (a2 == null) {
            throw new NullPointerException("interceptor " + xVar + " returned null");
        }
        if (a2.enm() == null) {
            throw new IllegalStateException("interceptor " + xVar + " returned a response with no body");
        }
        return a2;
    }
}
