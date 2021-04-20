package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class PipedOutputStreamAndroid25 extends OutputStream {

    /* renamed from: e  reason: collision with root package name */
    public PipedInputStreamAndroid25 f22485e;

    public synchronized void c(PipedInputStreamAndroid25 pipedInputStreamAndroid25) throws IOException {
        try {
            if (pipedInputStreamAndroid25 != null) {
                if (this.f22485e == null && !pipedInputStreamAndroid25.f22483g) {
                    this.f22485e = pipedInputStreamAndroid25;
                    pipedInputStreamAndroid25.k = -1;
                    pipedInputStreamAndroid25.l = 0;
                    pipedInputStreamAndroid25.f22483g = true;
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
        PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f22485e;
        if (pipedInputStreamAndroid25 != null) {
            pipedInputStreamAndroid25.t();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f22485e != null) {
            synchronized (this.f22485e) {
                this.f22485e.notifyAll();
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f22485e;
        if (pipedInputStreamAndroid25 != null) {
            pipedInputStreamAndroid25.r(i);
            return;
        }
        throw new IOException("Pipe not connected");
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        PipedInputStreamAndroid25 pipedInputStreamAndroid25 = this.f22485e;
        if (pipedInputStreamAndroid25 == null) {
            throw new IOException("Pipe not connected");
        }
        if (bArr != null) {
            if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return;
            }
            pipedInputStreamAndroid25.s(bArr, i, i2);
            return;
        }
        throw null;
    }
}
