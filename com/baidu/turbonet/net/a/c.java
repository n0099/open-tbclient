package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class c extends f {
    private static int ogo = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider ofE = new a();
    private final d ogh;
    private final g ogj;
    private final long ogp;
    private long ogq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.ogp = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.ogp, ogo));
        this.ogh = dVar;
        this.ogj = gVar;
        this.ogq = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        ML(1);
        dZe();
        this.mBuffer.put((byte) i);
        this.ogq++;
        dZg();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        ML(i2);
        int i3 = i2;
        while (i3 > 0) {
            dZe();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.ogq += i2;
        dZg();
    }

    private void dZe() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dZf();
        }
    }

    private void dZg() throws IOException {
        if (this.ogq == this.ogp) {
            dZf();
        }
    }

    private void dZf() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.ogj.dZt();
        dZr();
    }

    private void ML(int i) throws ProtocolException {
        if (this.ogq + i > this.ogp) {
            throw new ProtocolException("expected " + (this.ogp - this.ogq) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dZb() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dZc() throws IOException {
        if (this.ogq < this.ogp) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dZd() {
        return this.ofE;
    }

    /* loaded from: classes17.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.ogp;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.zg(false);
                c.this.ogj.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.zg(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
