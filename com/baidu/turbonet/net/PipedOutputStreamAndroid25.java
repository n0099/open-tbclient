package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class PipedOutputStreamAndroid25 extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public PipedInputStreamAndroid25 f22435e;

    public synchronized void c(PipedInputStreamAndroid25 pipedInputStreamAndroid25) throws IOException {
        try {
            if (pipedInputStreamAndroid25 != null) {
                if (this.f22435e == null && !pipedInputStreamAndroid25.f22432g) {
                    this.f22435e = pipedInputStreamAndroid25;
                    pipedInputStreamAndroid25.k = -1;
                    pipedInputStreamAndroid25.l = 0;
                    pipedInputStreamAndroid25.f22432g = true;
                } else {
                    throw new IOException("Already connected");
                }
            } else {
                throw new NullPointerException();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f22435e;
        if (pipedInputStreamAndroid25 != null) {
            pipedInputStreamAndroid25.t();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f22435e != null) {
            synchronized (this.f22435e) {
                this.f22435e.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f22435e;
        if (pipedInputStreamAndroid25 != null) {
            pipedInputStreamAndroid25.r(i2);
            return;
        }
        throw new IOException("Pipe not connected");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f22435e;
        if (pipedInputStreamAndroid25 == null) {
            throw new IOException("Pipe not connected");
        }
        if (bArr != null) {
            if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return;
            }
            pipedInputStreamAndroid25.s(bArr, i2, i3);
            return;
        }
        throw null;
    }
}
