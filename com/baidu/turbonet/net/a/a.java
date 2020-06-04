package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends f {
    private ByteBuffer mBuffer;
    private final int mgS;
    private final d mgT;
    private final UploadDataProvider mgq = new C0764a();
    private boolean mfu = false;

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
        this.mgT = dVar;
        this.mgS = (int) j;
        this.mBuffer = ByteBuffer.allocate(this.mgS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        this.mgT = dVar;
        this.mgS = -1;
        this.mBuffer = ByteBuffer.allocate(16384);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Gv(1);
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        Gv(i2);
        this.mBuffer.put(bArr, i, i2);
    }

    private void Gv(int i) throws IOException {
        if (this.mgS != -1 && this.mBuffer.position() + i > this.mgS) {
            throw new ProtocolException("exceeded content-length limit of " + this.mgS + " bytes");
        }
        if (this.mfu) {
            throw new IllegalStateException("Cannot write after being connected.");
        }
        if (this.mgS == -1 && this.mBuffer.limit() - this.mBuffer.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.mBuffer.capacity() * 2, this.mBuffer.capacity() + i));
            this.mBuffer.flip();
            allocate.put(this.mBuffer);
            this.mBuffer = allocate;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void drH() throws IOException {
        this.mfu = true;
        if (this.mBuffer.position() < this.mgS) {
            throw new ProtocolException("Content received is less than Content-Length");
        }
        this.mBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void drI() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider drJ() {
        return this.mgq;
    }

    /* renamed from: com.baidu.turbonet.net.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0764a extends UploadDataProvider {
        private C0764a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            if (a.this.mgS == -1) {
                return a.this.mfu ? a.this.mBuffer.limit() : a.this.mBuffer.position();
            }
            return a.this.mgS;
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
            uploadDataSink.vH(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            a.this.mBuffer.position(0);
            uploadDataSink.dqu();
        }
    }
}
