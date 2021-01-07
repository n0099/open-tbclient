package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class g implements r {
    private final r phN;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.phN = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a(c cVar, long j) throws IOException {
        this.phN.a(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.phN.flush();
    }

    @Override // com.bytedance.sdk.a.a.r
    public t epS() {
        return this.phN.epS();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.phN.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.phN.toString() + ")";
    }
}
