package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes14.dex */
public class PipedOutputStreamAndroid25 extends OutputStream {
    private PipedInputStreamAndroid25 oEH;

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.oEH == null) {
            throw new IOException("Pipe not connected");
        }
        this.oEH.Os(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.oEH == null) {
            throw new IOException("Pipe not connected");
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 != 0) {
            this.oEH.v(bArr, i, i2);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.oEH != null) {
            synchronized (this.oEH) {
                this.oEH.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.oEH != null) {
            this.oEH.ehK();
        }
    }
}
