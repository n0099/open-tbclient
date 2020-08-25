package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class b extends f {
    private final ByteBuffer mBuffer;
    private final d ndS;
    private final g ndU;
    private boolean ndW;
    private boolean ndX;
    private final UploadDataProvider ndp = new a();
    private boolean ndV = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, int i, g gVar, boolean z, boolean z2) {
        this.ndW = false;
        this.ndX = false;
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.ndS = dVar;
        this.ndU = gVar;
        this.ndW = z;
        this.ndX = z2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        dLu();
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
            dLu();
        }
    }

    @Override // com.baidu.turbonet.net.a.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.ndV) {
            this.ndV = true;
            this.mBuffer.flip();
            if (this.ndW) {
                this.ndU.KA(this.ndS.getReadTimeout());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dLr() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dLs() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dLt() {
        return this.ndp;
    }

    /* loaded from: classes10.dex */
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
                uploadDataSink.xy(b.this.ndV);
                if (!b.this.ndV) {
                    b.this.ndU.quit();
                    return;
                } else if (b.this.ndW) {
                    b.this.ndU.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.mBuffer.limit();
            b.this.mBuffer.limit(b.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.mBuffer);
            b.this.mBuffer.limit(limit);
            uploadDataSink.xy(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void dLu() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dLv();
        }
    }

    private void dLv() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.ndU.KA(this.ndS.getReadTimeout());
        dLH();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.ndX && this.mBuffer.position() > 0) {
            dLv();
        }
    }
}
