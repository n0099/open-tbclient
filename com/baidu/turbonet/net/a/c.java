package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends f {
    private static int lMx = 16384;
    private final UploadDataProvider lLN = new a();
    private final d lMq;
    private final g lMs;
    private final long lMy;
    private long lMz;
    private final ByteBuffer mBuffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.lMy = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.lMy, lMx));
        this.lMq = dVar;
        this.lMs = gVar;
        this.lMz = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        FH(1);
        dki();
        this.mBuffer.put((byte) i);
        this.lMz++;
        dkk();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        FH(i2);
        int i3 = i2;
        while (i3 > 0) {
            dki();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.lMz += i2;
        dkk();
    }

    private void dki() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dkj();
        }
    }

    private void dkk() throws IOException {
        if (this.lMz == this.lMy) {
            dkj();
        }
    }

    private void dkj() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.lMs.dkx();
        dkv();
    }

    private void FH(int i) throws ProtocolException {
        if (this.lMz + i > this.lMy) {
            throw new ProtocolException("expected " + (this.lMy - this.lMz) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dkf() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dkg() throws IOException {
        if (this.lMz < this.lMy) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dkh() {
        return this.lLN;
    }

    /* loaded from: classes.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.lMy;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.vh(false);
                c.this.lMs.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.vh(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.n(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
