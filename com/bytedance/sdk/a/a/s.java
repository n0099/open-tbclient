package com.bytedance.sdk.a.a;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes4.dex */
public interface s extends Closeable {
    long b(c cVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    t epR();
}
