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
    private static int nDM = 16384;
    private final ByteBuffer mBuffer;
    private final d nDF;
    private final g nDH;
    private final long nDN;
    private long nDO;
    private final UploadDataProvider nDc = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j, g gVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (j < 0) {
            throw new IllegalArgumentException("Content length must be larger than 0 for non-chunked upload.");
        }
        this.nDN = j;
        this.mBuffer = ByteBuffer.allocate((int) Math.min(this.nDN, nDM));
        this.nDF = dVar;
        this.nDH = gVar;
        this.nDO = 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        checkNotClosed();
        LJ(1);
        dTm();
        this.mBuffer.put((byte) i);
        this.nDO++;
        dTo();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        LJ(i2);
        int i3 = i2;
        while (i3 > 0) {
            dTm();
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
        }
        this.nDO += i2;
        dTo();
    }

    private void dTm() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dTn();
        }
    }

    private void dTo() throws IOException {
        if (this.nDO == this.nDN) {
            dTn();
        }
    }

    private void dTn() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.nDH.dTB();
        dTz();
    }

    private void LJ(int i) throws ProtocolException {
        if (this.nDO + i > this.nDN) {
            throw new ProtocolException("expected " + (this.nDN - this.nDO) + " bytes but received " + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dTj() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dTk() throws IOException {
        if (this.nDO < this.nDN) {
            throw new ProtocolException("Content received is less than Content-Length.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dTl() {
        return this.nDc;
    }

    /* loaded from: classes17.dex */
    private class a extends UploadDataProvider {
        private a() {
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public long getLength() {
            return c.this.nDN;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= c.this.mBuffer.remaining()) {
                byteBuffer.put(c.this.mBuffer);
                c.this.mBuffer.clear();
                uploadDataSink.yq(false);
                c.this.nDH.quit();
                return;
            }
            int limit = c.this.mBuffer.limit();
            c.this.mBuffer.limit(c.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(c.this.mBuffer);
            c.this.mBuffer.limit(limit);
            uploadDataSink.yq(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }
}
