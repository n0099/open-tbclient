package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class h implements s {
    private final s pob;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pob = sVar;
    }

    public final s eoJ() {
        return this.pob;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        return this.pob.b(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoy() {
        return this.pob.eoy();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pob.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pob.toString() + ")";
    }
}
