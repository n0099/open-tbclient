package com.bytedance.sdk.adnet.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
class e extends ByteArrayOutputStream {
    private final d pvx;

    public e(d dVar, int i) {
        this.pvx = dVar;
        this.buf = this.pvx.a(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.pvx.a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.pvx.a(this.buf);
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            byte[] a2 = this.pvx.a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a2, 0, this.count);
            this.pvx.a(this.buf);
            this.buf = a2;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
