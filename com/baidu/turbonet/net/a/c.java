package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class c extends f {
    private static int oqW = 16384;
    private final ByteBuffer mBuffer;
    private final d oqP;
    private final g oqR;
    private final long oqX;
    private long oqY;
    private final UploadDataProvider oqm = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oqX = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oqX, oqW));
        this.oqP = dVar;
        this.oqR = gVar;
        this.oqY = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        NH(1);
        ecL();
        this.mBuffer.put((byte) i);
        this.oqY++;
        ecN();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        NH(i2);
        int i3 = i2;
        while (i3 > 0) {
            ecL();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oqY += i2;
        ecN();
    }

    private void ecL() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            ecM();
        }
    }

    private void ecN() throws IOException {
        if (this.oqY == this.oqX) {
            ecM();
        }
    }

    private void ecM() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oqR.eda();
        ecY();
    }

    private void NH(int i) throws ProtocolException {
        if (this.oqY + i > this.oqX) {
            throw new ProtocolException("expected " + (this.oqX - this.oqY) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ecI() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ecJ() throws IOException {
        if (this.oqY < this.oqX) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider ecK() {
        return this.oqm;
    }

    /* loaded from: classes12.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oqX;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.zy(false);
                c.this.oqR.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.zy(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
