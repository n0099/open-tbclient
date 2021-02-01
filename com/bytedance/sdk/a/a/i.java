package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class i extends t {
    private t pnE;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pnE = tVar;
    }

    public final t eoq() {
        return this.pnE;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pnE = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t c(long j, TimeUnit timeUnit) {
        return this.pnE.c(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eoC() {
        return this.pnE.eoC();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.pnE.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eoD() {
        return this.pnE.eoD();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t ip(long j) {
        return this.pnE.ip(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eoE() {
        return this.pnE.eoE();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eoF() {
        return this.pnE.eoF();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.pnE.g();
    }
}
