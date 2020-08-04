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
    private static int mLe = 16384;
    private final ByteBuffer mBuffer;
    private final d mKX;
    private final g mKZ;
    private final UploadDataProvider mKu = new a();
    private final long mLf;
    private long mLg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.mLf = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.mLf, mLe));
        this.mKX = dVar;
        this.mKZ = gVar;
        this.mLg = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        HY(1);
        dzH();
        this.mBuffer.put((byte) i);
        this.mLg++;
        dzJ();
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
            dzH();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.mLg += i2;
        dzJ();
    }

    private void dzH() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dzI();
        }
    }

    private void dzJ() throws IOException {
        if (this.mLg == this.mLf) {
            dzI();
        }
    }

    private void dzI() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mKZ.dzW();
        dzU();
    }

    private void HY(int i) throws ProtocolException {
        if (this.mLg + i > this.mLf) {
            throw new ProtocolException("expected " + (this.mLf - this.mLg) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzE() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzF() throws IOException {
        if (this.mLg < this.mLf) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dzG() {
        return this.mKu;
    }

    /* loaded from: classes19.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.mLf;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.wI(false);
                c.this.mKZ.quit();
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
