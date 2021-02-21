package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class i extends t {
    private t poe;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.poe = tVar;
    }

    public final t eoy() {
        return this.poe;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.poe = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t c(long j, TimeUnit timeUnit) {
        return this.poe.c(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eoK() {
        return this.poe.eoK();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.poe.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long eoL() {
        return this.poe.eoL();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t ip(long j) {
        return this.poe.ip(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eoM() {
        return this.poe.eoM();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eoN() {
        return this.poe.eoN();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.poe.g();
    }
}
