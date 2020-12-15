package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class a extends f {
    private ByteBuffer mBuffer;
    private final int oFM;
    private final d oFN;
    private final UploadDataProvider oFk = new C0948a();
    private boolean oEp = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar, long j) {
        if (dVar == null) {
            throw new NullPointerException("Argument connection cannot be null.");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2GB.");
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length < 0.");
        }
        this.oFN = dVar;
        this.oFM = (int) j;
        this.mBuffer = ByteBuffer.allocate(this.oFM);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        this.oFN = dVar;
        this.oFM = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Oy(1);
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        Oy(i2);
        this.mBuffer.put(bArr, i, i2);
    }

    private void Oy(int i) throws IOException {
        if (this.oFM != -1 && this.mBuffer.position() + i > this.oFM) {
            throw new ProtocolException("exceeded content-length limit of " + this.oFM + " bytes");
        }
        if (this.oEp) {
            throw new IllegalStateException("Cannot write after being connected.");
        }
        if (this.oFM == -1 && this.mBuffer.limit() - this.mBuffer.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + i));
            this.mBuffer.flip();
            allocate.put(this.mBuffer);
            this.mBuffer = allocate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eio() throws IOException {
        this.oEp = true;
        if (this.mBuffer.position() < this.oFM) {
            throw new ProtocolException("Content received is less than Content-Length");
        }
        this.mBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eip() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider eiq() {
        return this.oFk;
    }

    /* renamed from: com.baidu.turbonet.net.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private class C0948a extends UploadDataProvider {
        private C0948a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            if (a.this.oFM == -1) {
                return a.this.oEp ? a.this.mBuffer.limit() : a.this.mBuffer.position();
            }
            return a.this.oFM;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (remaining < a.this.mBuffer.remaining()) {
                byteBuffer.put(a.this.mBuffer.array(), a.this.mBuffer.position(), remaining);
                a.this.mBuffer.position(remaining + a.this.mBuffer.position());
            } else {
                byteBuffer.put(a.this.mBuffer);
            }
            uploadDataSink.Ac(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            a.this.mBuffer.position(0);
            uploadDataSink.ehc();
        }
    }
}
