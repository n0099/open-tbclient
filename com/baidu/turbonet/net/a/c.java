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
    private static int mha = 16384;
    private final ByteBuffer mBuffer;
    private final d mgT;
    private final g mgV;
    private final UploadDataProvider mgq = new a();
    private final long mhb;
    private long mhc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.mhb = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.mhb, mha));
        this.mgT = dVar;
        this.mgV = gVar;
        this.mhc = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Gw(1);
        drK();
        this.mBuffer.put((byte) i);
        this.mhc++;
        drM();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Gw(i2);
        int i3 = i2;
        while (i3 > 0) {
            drK();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.mhc += i2;
        drM();
    }

    private void drK() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            drL();
        }
    }

    private void drM() throws IOException {
        if (this.mhc == this.mhb) {
            drL();
        }
    }

    private void drL() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mgV.drZ();
        drX();
    }

    private void Gw(int i) throws ProtocolException {
        if (this.mhc + i > this.mhb) {
            throw new ProtocolException("expected " + (this.mhb - this.mhc) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void drH() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void drI() throws IOException {
        if (this.mhc < this.mhb) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider drJ() {
        return this.mgq;
    }

    /* loaded from: classes.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.mhb;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.vH(false);
                c.this.mgV.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.vH(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.v(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
