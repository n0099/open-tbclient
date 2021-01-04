package com.baidu.turbonet.net;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public abstract class UploadDataProvider implements Closeable {
    public abstract void a(UploadDataSink uploadDataSink) throws IOException;

    public abstract void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) throws IOException;

    public abstract long getLength() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }
}
