package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class f implements Closeable, Flushable {
    final com.bytedance.sdk.a.b.a.a.e pdO;
    final com.bytedance.sdk.a.b.a.a.d pgI;

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.pgI.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pgI.close();
    }
}
