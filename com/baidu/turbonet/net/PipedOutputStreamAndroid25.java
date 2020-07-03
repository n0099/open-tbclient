package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class PipedOutputStreamAndroid25 extends OutputStream {
    private PipedInputStreamAndroid25 mBE;

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.mBE == null) {
            throw new IOException("Pipe not connected");
        }
        this.mBE.Hw(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.mBE == null) {
            throw new IOException("Pipe not connected");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            this.mBE.r(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.mBE != null) {
            synchronized (this.mBE) {
                this.mBE.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mBE != null) {
            this.mBE.dvI();
        }
    }
}
