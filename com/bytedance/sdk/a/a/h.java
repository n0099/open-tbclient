package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class h implements s {
    private final s pnB;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pnB = sVar;
    }

    public final s eoB() {
        return this.pnB;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        return this.pnB.b(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoq() {
        return this.pnB.eoq();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pnB.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pnB.toString() + ")";
    }
}
