package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class g implements r {
    private final r pqj;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pqj = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        this.pqj.a(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.pqj.flush();
    }

    @Override // com.bytedance.sdk.a.a.r
    public t eoF() {
        return this.pqj.eoF();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pqj.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pqj.toString() + ")";
    }
}
