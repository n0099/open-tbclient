package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public class PipedOutputStreamAndroid25 extends OutputStream {
    private PipedInputStreamAndroid25 ncM;

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.ncM == null) {
            throw new IOException("Pipe not connected");
        }
        this.ncM.Kr(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.ncM == null) {
            throw new IOException("Pipe not connected");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            this.ncM.t(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.ncM != null) {
            synchronized (this.ncM) {
                this.ncM.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.ncM != null) {
            this.ncM.dKN();
        }
    }
}
