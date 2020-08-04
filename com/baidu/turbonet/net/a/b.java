package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public final class b extends f {
    private final ByteBuffer mBuffer;
    private final d mKX;
    private final g mKZ;
    private final UploadDataProvider mKu = new a();
    private boolean mLa = false;
    private boolean mLb;
    private boolean mLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, int i, g gVar, boolean z, boolean z2) {
        this.mLb = false;
        this.mLc = false;
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.mKX = dVar;
        this.mKZ = gVar;
        this.mLb = z;
        this.mLc = z2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        dzH();
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
            dzH();
        }
    }

    @Override // com.baidu.turbonet.net.a.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.mLa) {
            this.mLa = true;
            this.mBuffer.flip();
            if (this.mLb) {
                this.mKZ.Ia(this.mKX.getReadTimeout());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzE() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dzF() throws IOException {
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
            return -1L;
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= b.this.mBuffer.remaining()) {
                byteBuffer.put(b.this.mBuffer);
                b.this.mBuffer.clear();
                uploadDataSink.wI(b.this.mLa);
                if (!b.this.mLa) {
                    b.this.mKZ.quit();
                    return;
                } else if (b.this.mLb) {
                    b.this.mKZ.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.mBuffer.limit();
            b.this.mBuffer.limit(b.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.mBuffer);
            b.this.mBuffer.limit(limit);
            uploadDataSink.wI(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.v(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void dzH() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dzI();
        }
    }

    private void dzI() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.mKZ.Ia(this.mKX.getReadTimeout());
        dzU();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.mLc && this.mBuffer.position() > 0) {
            dzI();
        }
    }
}
