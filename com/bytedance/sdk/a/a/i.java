package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class i extends t {
    private t pdq;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdq = tVar;
    }

    public final t elW() {
        return this.pdq;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdq = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t c(long j, TimeUnit timeUnit) {
        return this.pdq.c(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long emi() {
        return this.pdq.emi();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.pdq.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long emj() {
        return this.pdq.emj();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t im(long j) {
        return this.pdq.im(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t emk() {
        return this.pdq.emk();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eml() {
        return this.pdq.eml();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.pdq.g();
    }
}
