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
    private static int mCV = 16384;
    private final ByteBuffer mBuffer;
    private final d mCO;
    private final g mCQ;
    private final long mCW;
    private long mCX;
    private final UploadDataProvider mCk = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.mCW = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.mCW, mCV));
        this.mCO = dVar;
        this.mCQ = gVar;
        this.mCX = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        HD(1);
        dwt();
        this.mBuffer.put((byte) i);
        this.mCX++;
        dwv();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        HD(i2);
        int i3 = i2;
        while (i3 > 0) {
            dwt();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.mCX += i2;
        dwv();
    }

    private void dwt() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dwu();
        }
    }

    private void dwv() throws IOException {
        if (this.mCX == this.mCW) {
            dwu();
        }
    }

    private void dwu() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mCQ.dwI();
        dwG();
    }

    private void HD(int i) throws ProtocolException {
        if (this.mCX + i > this.mCW) {
            throw new ProtocolException("expected " + (this.mCW - this.mCX) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dwq() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dwr() throws IOException {
        if (this.mCX < this.mCW) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dws() {
        return this.mCk;
    }

    /* loaded from: classes.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.mCW;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.wd(false);
                c.this.mCQ.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.wd(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.v(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
