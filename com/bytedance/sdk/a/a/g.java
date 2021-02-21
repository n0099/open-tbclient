package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class g implements r {
    private final r pnZ;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pnZ = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        this.pnZ.a(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.pnZ.flush();
    }

    @Override // com.bytedance.sdk.a.a.r
    public t eoy() {
        return this.pnZ.eoy();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pnZ.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pnZ.toString() + ")";
    }
}
