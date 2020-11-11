package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class b extends f {
    private final ByteBuffer mBuffer;
    private final d opl;
    private final g opn;
    private boolean opp;
    private boolean opq;
    private final UploadDataProvider ooI = new a();
    private boolean opo = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, int i, g gVar, boolean z, boolean z2) {
        this.opp = false;
        this.opq = false;
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.opl = dVar;
        this.opn = gVar;
        this.opp = z;
        this.opq = z2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        ecM();
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
            ecM();
        }
    }

    @Override // com.baidu.turbonet.net.a.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.opo) {
            this.opo = true;
            this.mBuffer.flip();
            if (this.opp) {
                this.opn.Ng(this.opl.getReadTimeout());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ecJ() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void ecK() throws IOException {
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
            return -1L;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= b.this.mBuffer.remaining()) {
                byteBuffer.put(b.this.mBuffer);
                b.this.mBuffer.clear();
                uploadDataSink.zr(b.this.opo);
                if (!b.this.opo) {
                    b.this.opn.quit();
                    return;
                } else if (b.this.opp) {
                    b.this.opn.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.mBuffer.limit();
            b.this.mBuffer.limit(b.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.mBuffer);
            b.this.mBuffer.limit(limit);
            uploadDataSink.zr(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void ecM() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            ecN();
        }
    }

    private void ecN() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.opn.Ng(this.opl.getReadTimeout());
        ecZ();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.opq && this.mBuffer.position() > 0) {
            ecN();
        }
    }
}
