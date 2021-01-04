package com.bytedance.sdk.a.a;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
/* loaded from: classes4.dex */
public interface r extends Closeable, Flushable {
    void a(c cVar, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    t epR();

    void flush() throws IOException;
}
