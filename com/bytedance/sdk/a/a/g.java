package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class g implements r {
    private final r pdl;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdl = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        this.pdl.a(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.pdl.flush();
    }

    @Override // com.bytedance.sdk.a.a.r
    public t elW() {
        return this.pdl.elW();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pdl.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pdl.toString() + ")";
    }
}
