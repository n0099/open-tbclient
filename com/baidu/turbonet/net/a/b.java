package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b extends f {
    private final ByteBuffer mBuffer;
    private final d oHr;
    private final g oHt;
    private boolean oHv;
    private boolean oHw;
    private final UploadDataProvider oHe = new a();
    private boolean oHu = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, int i, g gVar, boolean z, boolean z2) {
        this.oHv = false;
        this.oHw = false;
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.oHr = dVar;
        this.oHt = gVar;
        this.oHv = z;
        this.oHw = z2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        eeK();
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
            eeK();
        }
    }

    @Override // com.baidu.turbonet.net.a.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.oHu) {
            this.oHu = true;
            this.mBuffer.flip();
            if (this.oHv) {
                this.oHt.MJ(this.oHr.getReadTimeout());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eeH() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eeI() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider eeJ() {
        return this.oHe;
    }

    /* loaded from: classes4.dex */
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
                uploadDataSink.onReadSucceeded(b.this.oHu);
                if (!b.this.oHu) {
                    b.this.oHt.quit();
                    return;
                } else if (b.this.oHv) {
                    b.this.oHt.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.mBuffer.limit();
            b.this.mBuffer.limit(b.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.mBuffer);
            b.this.mBuffer.limit(limit);
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void eeK() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            eeL();
        }
    }

    private void eeL() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oHt.MJ(this.oHr.getReadTimeout());
        eeX();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.oHw && this.mBuffer.position() > 0) {
            eeL();
        }
    }
}
