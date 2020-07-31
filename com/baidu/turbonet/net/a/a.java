package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class a extends f {
    private ByteBuffer mBuffer;
    private final int mKU;
    private final d mKV;
    private final UploadDataProvider mKs = new C0794a();
    private boolean mJv = false;

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
        this.mKV = dVar;
        this.mKU = (int) j;
        this.mBuffer = ByteBuffer.allocate(this.mKU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        this.mKV = dVar;
        this.mKU = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        HX(1);
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        HX(i2);
        this.mBuffer.put(bArr, i, i2);
    }

    private void HX(int i) throws IOException {
        if (this.mKU != -1 && this.mBuffer.position() + i > this.mKU) {
            throw new ProtocolException("exceeded content-length limit of " + this.mKU + " bytes");
        }
        if (this.mJv) {
            throw new IllegalStateException("Cannot write after being connected.");
        }
        if (this.mKU == -1 && this.mBuffer.limit() - this.mBuffer.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + i));
            this.mBuffer.flip();
            allocate.put(this.mBuffer);
            this.mBuffer = allocate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzD() throws IOException {
        this.mJv = true;
        if (this.mBuffer.position() < this.mKU) {
            throw new ProtocolException("Content received is less than Content-Length");
        }
        this.mBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzE() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dzF() {
        return this.mKs;
    }

    /* renamed from: com.baidu.turbonet.net.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private class C0794a extends UploadDataProvider {
        private C0794a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            if (a.this.mKU == -1) {
                return a.this.mJv ? a.this.mBuffer.limit() : a.this.mBuffer.position();
            }
            return a.this.mKU;
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
            uploadDataSink.wI(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            a.this.mBuffer.position(0);
            uploadDataSink.dyq();
        }
    }
}
