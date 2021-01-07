package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class i extends t {
    private t phS;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.phS = tVar;
    }

    public final t epS() {
        return this.phS;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.phS = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t c(long j, TimeUnit timeUnit) {
        return this.phS.c(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eqe() {
        return this.phS.eqe();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.phS.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eqf() {
        return this.phS.eqf();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t im(long j) {
        return this.phS.im(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eqg() {
        return this.phS.eqg();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eqh() {
        return this.phS.eqh();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.phS.g();
    }
}
