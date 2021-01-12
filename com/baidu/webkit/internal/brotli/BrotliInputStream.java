package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.INoProGuard;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
/* loaded from: classes14.dex */
public class BrotliInputStream extends InputStream implements INoProGuard {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Decoder decoder;

    public BrotliInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 16384);
    }

    public BrotliInputStream(InputStream inputStream, int i) throws IOException {
        this.decoder = new Decoder(Channels.newChannel(inputStream), i);
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.decoder.buffer != null) {
            return this.decoder.buffer.remaining();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.decoder.close();
    }

    public void enableEagerOutput() {
        this.decoder.enableEagerOutput();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int decode;
        if (this.decoder.closed) {
            throw new IOException("read after close");
        }
        do {
            decode = this.decoder.decode();
        } while (decode == 0);
        if (decode == -1) {
            return -1;
        }
        return this.decoder.buffer.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.decoder.closed) {
            throw new IOException("read after close");
        }
        if (this.decoder.decode() == -1) {
            return -1;
        }
        int i3 = 0;
        while (i2 > 0) {
            int min = Math.min(i2, this.decoder.buffer.remaining());
            this.decoder.buffer.get(bArr, i, min);
            i += min;
            i2 -= min;
            i3 += min;
            if (!this.decoder.buffer.hasRemaining() || this.decoder.decode() == -1) {
                return i3;
            }
            while (i2 > 0) {
            }
        }
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.decoder.closed) {
            throw new IOException("read after close");
        }
        long j2 = 0;
        while (j > 0 && this.decoder.decode() != -1) {
            int min = (int) Math.min(j, this.decoder.buffer.remaining());
            this.decoder.discard(min);
            j2 += min;
            j -= min;
        }
        return j2;
    }
}
