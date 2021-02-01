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
    private static int oRH = 16384;
    private final ByteBuffer mBuffer;
    private final d oRA;
    private final g oRC;
    private final long oRI;
    private long oRJ;
    private final UploadDataProvider oRn = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oRI = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oRI, oRH));
        this.oRA = dVar;
        this.oRC = gVar;
        this.oRJ = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Nd(1);
        ehc();
        this.mBuffer.put((byte) i);
        this.oRJ++;
        ehe();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Nd(i2);
        int i3 = i2;
        while (i3 > 0) {
            ehc();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oRJ += i2;
        ehe();
    }

    private void ehc() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            ehd();
        }
    }

    private void ehe() throws IOException {
        if (this.oRJ == this.oRI) {
            ehd();
        }
    }

    private void ehd() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oRC.ehr();
        ehp();
    }

    private void Nd(int i) throws ProtocolException {
        if (this.oRJ + i > this.oRI) {
            throw new ProtocolException("expected " + (this.oRI - this.oRJ) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void egZ() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eha() throws IOException {
        if (this.oRJ < this.oRI) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider ehb() {
        return this.oRn;
    }

    /* loaded from: classes6.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oRI;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(false);
                c.this.oRC.quit();
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
