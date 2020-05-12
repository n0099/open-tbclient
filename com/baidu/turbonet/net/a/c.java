package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends f {
    private static int lMB = 16384;
    private final UploadDataProvider lLR = new a();
    private final long lMC;
    private long lMD;
    private final d lMu;
    private final g lMw;
    private final ByteBuffer mBuffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.lMC = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.lMC, lMB));
        this.lMu = dVar;
        this.lMw = gVar;
        this.lMD = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        FH(1);
        dkg();
        this.mBuffer.put((byte) i);
        this.lMD++;
        dki();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        FH(i2);
        int i3 = i2;
        while (i3 > 0) {
            dkg();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.lMD += i2;
        dki();
    }

    private void dkg() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dkh();
        }
    }

    private void dki() throws IOException {
        if (this.lMD == this.lMC) {
            dkh();
        }
    }

    private void dkh() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.lMw.dkv();
        dkt();
    }

    private void FH(int i) throws ProtocolException {
        if (this.lMD + i > this.lMC) {
            throw new ProtocolException("expected " + (this.lMC - this.lMD) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dkd() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dke() throws IOException {
        if (this.lMD < this.lMC) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dkf() {
        return this.lLR;
    }

    /* loaded from: classes.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.lMC;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.vh(false);
                c.this.lMw.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.vh(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.o(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
