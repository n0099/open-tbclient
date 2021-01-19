package com.bytedance.sdk.a.a;

import java.io.IOException;
/* loaded from: classes4.dex */
public abstract class h implements s {
    private final s pdo;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.pdo = sVar;
    }

    public final s emh() {
        return this.pdo;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long b(c cVar, long j) throws IOException {
        return this.pdo.b(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.s
    public t elW() {
        return this.pdo.elW();
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pdo.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.pdo.toString() + ")";
    }
}
