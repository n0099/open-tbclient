package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class c extends f {
    private static int mLc = 16384;
    private final ByteBuffer mBuffer;
    private final d mKV;
    private final g mKX;
    private final UploadDataProvider mKs = new a();
    private final long mLd;
    private long mLe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.mLd = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.mLd, mLc));
        this.mKV = dVar;
        this.mKX = gVar;
        this.mLe = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        HY(1);
        dzG();
        this.mBuffer.put((byte) i);
        this.mLe++;
        dzI();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        HY(i2);
        int i3 = i2;
        while (i3 > 0) {
            dzG();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.mLe += i2;
        dzI();
    }

    private void dzG() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dzH();
        }
    }

    private void dzI() throws IOException {
        if (this.mLe == this.mLd) {
            dzH();
        }
    }

    private void dzH() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mKX.dzV();
        dzT();
    }

    private void HY(int i) throws ProtocolException {
        if (this.mLe + i > this.mLd) {
            throw new ProtocolException("expected " + (this.mLd - this.mLe) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzD() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzE() throws IOException {
        if (this.mLe < this.mLd) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dzF() {
        return this.mKs;
    }

    /* loaded from: classes19.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.mLd;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.wI(false);
                c.this.mKX.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.wI(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.v(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
