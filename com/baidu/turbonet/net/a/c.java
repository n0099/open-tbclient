package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class c extends f {
    private static int oMd = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider oLJ = new a();
    private final d oLW;
    private final g oLY;
    private final long oMe;
    private long oMf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oMe = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oMe, oMd));
        this.oLW = dVar;
        this.oLY = gVar;
        this.oMf = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Oo(1);
        eiC();
        this.mBuffer.put((byte) i);
        this.oMf++;
        eiE();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Oo(i2);
        int i3 = i2;
        while (i3 > 0) {
            eiC();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oMf += i2;
        eiE();
    }

    private void eiC() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            eiD();
        }
    }

    private void eiE() throws IOException {
        if (this.oMf == this.oMe) {
            eiD();
        }
    }

    private void eiD() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oLY.eiR();
        eiP();
    }

    private void Oo(int i) throws ProtocolException {
        if (this.oMf + i > this.oMe) {
            throw new ProtocolException("expected " + (this.oMe - this.oMf) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eiz() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eiA() throws IOException {
        if (this.oMf < this.oMe) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider eiB() {
        return this.oLJ;
    }

    /* loaded from: classes5.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oMe;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(false);
                c.this.oLY.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
