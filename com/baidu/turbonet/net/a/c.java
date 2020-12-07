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
    private static int oFS = 16384;
    private final ByteBuffer mBuffer;
    private final d oFL;
    private final g oFN;
    private final long oFT;
    private long oFU;
    private final UploadDataProvider oFi = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oFT = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oFT, oFS));
        this.oFL = dVar;
        this.oFN = gVar;
        this.oFU = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Oz(1);
        eiq();
        this.mBuffer.put((byte) i);
        this.oFU++;
        eis();
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
            eiq();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oFU += i2;
        eis();
    }

    private void eiq() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            eir();
        }
    }

    private void eis() throws IOException {
        if (this.oFU == this.oFT) {
            eir();
        }
    }

    private void eir() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oFN.eiF();
        eiD();
    }

    private void Oz(int i) throws ProtocolException {
        if (this.oFU + i > this.oFT) {
            throw new ProtocolException("expected " + (this.oFT - this.oFU) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ein() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eio() throws IOException {
        if (this.oFU < this.oFT) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider eip() {
        return this.oFi;
    }

    /* loaded from: classes14.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oFT;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.Ac(false);
                c.this.oFN.quit();
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
