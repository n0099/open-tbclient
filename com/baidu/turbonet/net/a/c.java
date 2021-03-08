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
    private static int oUm = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider oTS = new a();
    private final d oUf;
    private final g oUh;
    private final long oUn;
    private long oUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.oUn = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.oUn, oUm));
        this.oUf = dVar;
        this.oUh = gVar;
        this.oUo = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Ni(1);
        ehs();
        this.mBuffer.put((byte) i);
        this.oUo++;
        ehu();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Ni(i2);
        int i3 = i2;
        while (i3 > 0) {
            ehs();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.oUo += i2;
        ehu();
    }

    private void ehs() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            eht();
        }
    }

    private void ehu() throws IOException {
        if (this.oUo == this.oUn) {
            eht();
        }
    }

    private void eht() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oUh.ehH();
        ehF();
    }

    private void Ni(int i) throws ProtocolException {
        if (this.oUo + i > this.oUn) {
            throw new ProtocolException("expected " + (this.oUn - this.oUo) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ehp() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ehq() throws IOException {
        if (this.oUo < this.oUn) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider ehr() {
        return this.oTS;
    }

    /* loaded from: classes5.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.oUn;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(false);
                c.this.oUh.quit();
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
