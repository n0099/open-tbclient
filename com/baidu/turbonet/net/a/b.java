package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class b extends f {
    private final ByteBuffer mBuffer;
    private final d noj;
    private final g nol;
    private boolean non;
    private boolean noo;
    private final UploadDataProvider nnG = new a();
    private boolean nom = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, int i, g gVar, boolean z, boolean z2) {
        this.non = false;
        this.noo = false;
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.noj = dVar;
        this.nol = gVar;
        this.non = z;
        this.noo = z2;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        dPB();
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
            dPB();
        }
    }

    @Override // com.baidu.turbonet.net.a.f, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (!this.nom) {
            this.nom = true;
            this.mBuffer.flip();
            if (this.non) {
                this.nol.Lf(this.noj.getReadTimeout());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dPy() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public void dPz() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.turbonet.net.a.f
    public UploadDataProvider dPA() {
        return this.nnG;
    }

    /* loaded from: classes15.dex */
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
                uploadDataSink.xJ(b.this.nom);
                if (!b.this.nom) {
                    b.this.nol.quit();
                    return;
                } else if (b.this.non) {
                    b.this.nol.quit();
                    return;
                } else {
                    return;
                }
            }
            int limit = b.this.mBuffer.limit();
            b.this.mBuffer.limit(b.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(b.this.mBuffer);
            b.this.mBuffer.limit(limit);
            uploadDataSink.xJ(false);
        }

        @Override // com.baidu.turbonet.net.UploadDataProvider
        public void a(UploadDataSink uploadDataSink) {
            uploadDataSink.z(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void dPB() throws IOException {
        if (!this.mBuffer.hasRemaining()) {
            dPC();
        }
    }

    private void dPC() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        this.nol.Lf(this.noj.getReadTimeout());
        dPO();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.noo && this.mBuffer.position() > 0) {
            dPC();
        }
    }
}
