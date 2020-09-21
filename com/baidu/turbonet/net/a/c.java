package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class c extends f {
    private static int noq = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider nnG = new a();
    private final d noj;
    private final g nol;
    private final long nor;
    private long nos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.nor = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.nor, noq));
        this.noj = dVar;
        this.nol = gVar;
        this.nos = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Ld(1);
        dPB();
        this.mBuffer.put((byte) i);
        this.nos++;
        dPD();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Ld(i2);
        int i3 = i2;
        while (i3 > 0) {
            dPB();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.nos += i2;
        dPD();
    }

    private void dPB() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dPC();
        }
    }

    private void dPD() throws IOException {
        if (this.nos == this.nor) {
            dPC();
        }
    }

    private void dPC() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.nol.dPQ();
        dPO();
    }

    private void Ld(int i) throws ProtocolException {
        if (this.nos + i > this.nor) {
            throw new ProtocolException("expected " + (this.nor - this.nos) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dPy() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dPz() throws IOException {
        if (this.nos < this.nor) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dPA() {
        return this.nnG;
    }

    /* loaded from: classes15.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.nor;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.xJ(false);
                c.this.nol.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.xJ(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
