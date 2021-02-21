package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class c extends f {
    private static int oSh = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider oRN = new a();
    private final d oSa;
    private final g oSc;
    private final long oSi;
    private long oSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oSi = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oSi, oSh));
        this.oSa = dVar;
        this.oSc = gVar;
        this.oSj = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Ne(1);
        ehk();
        this.mBuffer.put((byte) i);
        this.oSj++;
        ehm();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Ne(i2);
        int i3 = i2;
        while (i3 > 0) {
            ehk();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oSj += i2;
        ehm();
    }

    private void ehk() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            ehl();
        }
    }

    private void ehm() throws IOException {
        if (this.oSj == this.oSi) {
            ehl();
        }
    }

    private void ehl() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oSc.ehz();
        ehx();
    }

    private void Ne(int i) throws ProtocolException {
        if (this.oSj + i > this.oSi) {
            throw new ProtocolException("expected " + (this.oSi - this.oSj) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ehh() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ehi() throws IOException {
        if (this.oSj < this.oSi) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider ehj() {
        return this.oRN;
    }

    /* loaded from: classes6.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oSi;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(false);
                c.this.oSc.quit();
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
