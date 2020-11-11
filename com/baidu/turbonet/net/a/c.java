package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class c extends f {
    private static int ops = 16384;
    private final ByteBuffer mBuffer;
    private final UploadDataProvider ooI = new a();
    private final d opl;
    private final g opn;
    private final long opu;
    private long opv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.opu = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.opu, ops));
        this.opl = dVar;
        this.opn = gVar;
        this.opv = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        Ne(1);
        ecM();
        this.mBuffer.put((byte) i);
        this.opv++;
        ecO();
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
            ecM();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.opv += i2;
        ecO();
    }

    private void ecM() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            ecN();
        }
    }

    private void ecO() throws IOException {
        if (this.opv == this.opu) {
            ecN();
        }
    }

    private void ecN() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.opn.edb();
        ecZ();
    }

    private void Ne(int i) throws ProtocolException {
        if (this.opv + i > this.opu) {
            throw new ProtocolException("expected " + (this.opu - this.opv) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ecJ() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ecK() throws IOException {
        if (this.opv < this.opu) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider ecL() {
        return this.ooI;
    }

    /* loaded from: classes17.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.opu;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.zr(false);
                c.this.opn.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.zr(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
