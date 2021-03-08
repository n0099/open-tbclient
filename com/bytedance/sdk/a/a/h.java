package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes6.dex */
public abstract class h implements s {
    private final s pql;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pql = sVar;
    }

    public final s eoQ() {
        return this.pql;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        return this.pql.b(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t eoF() {
        return this.pql.eoF();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pql.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pql.toString() + ")";
    }
}
