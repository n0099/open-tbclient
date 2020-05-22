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
    private static int mfQ = 16384;
    private final ByteBuffer mBuffer;
    private final d mfJ;
    private final g mfL;
    private final long mfR;
    private long mfS;
    private final UploadDataProvider mfg = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.mfR = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.mfR, mfQ));
        this.mfJ = dVar;
        this.mfL = gVar;
        this.mfS = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Gu(1);
        drw();
        this.mBuffer.put((byte) i);
        this.mfS++;
        dry();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Gu(i2);
        int i3 = i2;
        while (i3 > 0) {
            drw();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.mfS += i2;
        dry();
    }

    private void drw() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            drx();
        }
    }

    private void dry() throws IOException {
        if (this.mfS == this.mfR) {
            drx();
        }
    }

    private void drx() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mfL.drL();
        drJ();
    }

    private void Gu(int i) throws ProtocolException {
        if (this.mfS + i > this.mfR) {
            throw new ProtocolException("expected " + (this.mfR - this.mfS) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void drt() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dru() throws IOException {
        if (this.mfS < this.mfR) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider drv() {
        return this.mfg;
    }

    /* loaded from: classes.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.mfR;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.vF(false);
                c.this.mfL.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.vF(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.v(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
