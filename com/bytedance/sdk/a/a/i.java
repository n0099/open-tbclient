package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class i extends t {
    private t pqo;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pqo = tVar;
    }

    public final t eoF() {
        return this.pqo;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pqo = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t b(long j, TimeUnit timeUnit) {
        return this.pqo.b(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eoR() {
        return this.pqo.eoR();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.pqo.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eoS() {
        return this.pqo.eoS();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t ip(long j) {
        return this.pqo.ip(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eoT() {
        return this.pqo.eoT();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eoU() {
        return this.pqo.eoU();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.pqo.g();
    }
}
