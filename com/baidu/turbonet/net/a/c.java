package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class c extends f {
    private static int ndZ = 16384;
    private final ByteBuffer mBuffer;
    private final d ndS;
    private final g ndU;
    private final UploadDataProvider ndp = new a();
    private final long nea;
    private long neb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.nea = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.nea, ndZ));
        this.ndS = dVar;
        this.ndU = gVar;
        this.neb = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Ky(1);
        dLu();
        this.mBuffer.put((byte) i);
        this.neb++;
        dLw();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Ky(i2);
        int i3 = i2;
        while (i3 > 0) {
            dLu();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.neb += i2;
        dLw();
    }

    private void dLu() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dLv();
        }
    }

    private void dLw() throws IOException {
        if (this.neb == this.nea) {
            dLv();
        }
    }

    private void dLv() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.ndU.dLJ();
        dLH();
    }

    private void Ky(int i) throws ProtocolException {
        if (this.neb + i > this.nea) {
            throw new ProtocolException("expected " + (this.nea - this.neb) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dLr() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dLs() throws IOException {
        if (this.neb < this.nea) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dLt() {
        return this.ndp;
    }

    /* loaded from: classes10.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.nea;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.xy(false);
                c.this.ndU.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.xy(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
