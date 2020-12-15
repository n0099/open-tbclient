package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class c extends f {
    private static int oFU = 16384;
    private final ByteBuffer mBuffer;
    private final d oFN;
    private final g oFP;
    private final long oFV;
    private long oFW;
    private final UploadDataProvider oFk = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oFV = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oFV, oFU));
        this.oFN = dVar;
        this.oFP = gVar;
        this.oFW = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Oz(1);
        eir();
        this.mBuffer.put((byte) i);
        this.oFW++;
        eit();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Oz(i2);
        int i3 = i2;
        while (i3 > 0) {
            eir();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oFW += i2;
        eit();
    }

    private void eir() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            eis();
        }
    }

    private void eit() throws IOException {
        if (this.oFW == this.oFV) {
            eis();
        }
    }

    private void eis() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oFP.eiG();
        eiE();
    }

    private void Oz(int i) throws ProtocolException {
        if (this.oFW + i > this.oFV) {
            throw new ProtocolException("expected " + (this.oFV - this.oFW) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eio() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eip() throws IOException {
        if (this.oFW < this.oFV) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider eiq() {
        return this.oFk;
    }

    /* loaded from: classes14.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oFV;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.Ac(false);
                c.this.oFP.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.Ac(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
