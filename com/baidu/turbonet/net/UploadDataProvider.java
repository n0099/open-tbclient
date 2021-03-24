package com.baidu.turbonet.net;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public abstract class UploadDataProvider implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public abstract long n() throws IOException;

    public abstract void o(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException;

    public abstract void p(UploadDataSink uploadDataSink) throws IOException;
}
