package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class h implements s {
    private final s pdn;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdn = sVar;
    }

    public final s emh() {
        return this.pdn;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        return this.pdn.b(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t elW() {
        return this.pdn.elW();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pdn.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pdn.toString() + ")";
    }
}
