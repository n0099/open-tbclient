package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class h implements s {
    private final s phP;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.phP = sVar;
    }

    public final s eqd() {
        return this.phP;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        return this.phP.b(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t epS() {
        return this.phP.epS();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.phP.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.phP.toString() + ")";
    }
}
