package com.bytedance.sdk.component.b.a;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes9.dex */
public interface s extends Closeable {
    long a(c cVar, long j2) throws IOException;

    t a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
