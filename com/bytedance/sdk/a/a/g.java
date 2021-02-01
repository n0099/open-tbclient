package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class g implements r {
    private final r pnz;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pnz = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        this.pnz.a(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.pnz.flush();
    }

    @Override // com.bytedance.sdk.a.a.r
    public t eoq() {
        return this.pnz.eoq();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pnz.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pnz.toString() + ")";
    }
}
