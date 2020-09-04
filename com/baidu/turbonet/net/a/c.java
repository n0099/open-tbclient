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
    private static int ner = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider ndH = new a();
    private final d nek;
    private final g nem;
    private final long nes;
    private long neu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.nes = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.nes, ner));
        this.nek = dVar;
        this.nem = gVar;
        this.neu = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Ky(1);
        dLD();
        this.mBuffer.put((byte) i);
        this.neu++;
        dLF();
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
            dLD();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.neu += i2;
        dLF();
    }

    private void dLD() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dLE();
        }
    }

    private void dLF() throws IOException {
        if (this.neu == this.nes) {
            dLE();
        }
    }

    private void dLE() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.nem.dLS();
        dLQ();
    }

    private void Ky(int i) throws ProtocolException {
        if (this.neu + i > this.nes) {
            throw new ProtocolException("expected " + (this.nes - this.neu) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dLA() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dLB() throws IOException {
        if (this.neu < this.nes) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dLC() {
        return this.ndH;
    }

    /* loaded from: classes10.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.nes;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.xA(false);
                c.this.nem.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.xA(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
