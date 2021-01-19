package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class i extends t {
    private t pdr;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdr = tVar;
    }

    public final t elW() {
        return this.pdr;
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdr = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t c(long j, TimeUnit timeUnit) {
        return this.pdr.c(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public long emi() {
        return this.pdr.emi();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.pdr.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long emj() {
        return this.pdr.emj();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t im(long j) {
        return this.pdr.im(j);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t emk() {
        return this.pdr.emk();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t eml() {
        return this.pdr.eml();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.pdr.g();
    }
}
