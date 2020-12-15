package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class b extends f {
    private final ByteBuffer mBuffer;
    private final d oFN;
    private final g oFP;
    private boolean oFR;
    private boolean oFS;
    private final UploadDataProvider oFk = new a();
    private boolean oFQ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, int i, g gVar, boolean z, boolean z2) {
        this.oFR = false;
        this.oFS = false;
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.oFN = dVar;
        this.oFP = gVar;
        this.oFR = z;
        this.oFS = z2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        eir();
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
            eir();
        }
    }

    @Override // com.baidu.turbonet.net.a.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.oFQ) {
            this.oFQ = true;
            this.mBuffer.flip();
            if (this.oFR) {
                this.oFP.OB(this.oFN.getReadTimeout());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eio() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void eip() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider eiq() {
        return this.oFk;
    }

    /* loaded from: classes14.dex */
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
                uploadDataSink.Ac(b.this.oFQ);
                if (!b.this.oFQ) {
                    b.this.oFP.quit();
                    return;
                } else if (b.this.oFR) {
                    b.this.oFP.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.mBuffer.limit();
            b.this.mBuffer.limit(b.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.mBuffer);
            b.this.mBuffer.limit(limit);
            uploadDataSink.Ac(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void eir() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            eis();
        }
    }

    private void eis() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.oFP.OB(this.oFN.getReadTimeout());
        eiE();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.oFS && this.mBuffer.position() > 0) {
            eis();
        }
    }
}
