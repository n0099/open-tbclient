package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes5.dex */
public class PipedInputStreamAndroid25 extends InputStream {

    /* renamed from: h  reason: collision with root package name */
    public Thread f22798h;
    public Thread i;
    public byte[] j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22795e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f22796f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22797g = false;
    public int k = -1;
    public int l = 0;

    public PipedInputStreamAndroid25(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25, int i) throws IOException {
        q(i);
        p(pipedOutputStreamAndroid25);
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        if (this.k < 0) {
            return 0;
        }
        if (this.k == this.l) {
            return this.j.length;
        } else if (this.k > this.l) {
            return this.k - this.l;
        } else {
            return (this.k + this.j.length) - this.l;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22796f = true;
        synchronized (this) {
            this.k = -1;
        }
    }

    public final void n() throws IOException {
        while (this.k == this.l) {
            o();
            notifyAll();
            try {
                wait(1000L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        }
    }

    public final void o() throws IOException {
        if (this.f22797g) {
            if (!this.f22795e && !this.f22796f) {
                Thread thread = this.f22798h;
                if (thread != null && !thread.isAlive()) {
                    throw new IOException("Read end dead");
                }
                return;
            }
            throw new IOException("Pipe closed");
        }
        throw new IOException("Pipe not connected");
    }

    public void p(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25) throws IOException {
        pipedOutputStreamAndroid25.c(this);
    }

    public final void q(int i) {
        if (i > 0) {
            this.j = new byte[i];
            return;
        }
        throw new IllegalArgumentException("Pipe Size <= 0");
    }

    public synchronized void r(int i) throws IOException {
        o();
        this.i = Thread.currentThread();
        if (this.k == this.l) {
            n();
        }
        if (this.k < 0) {
            this.k = 0;
            this.l = 0;
        }
        byte[] bArr = this.j;
        int i2 = this.k;
        int i3 = i2 + 1;
        this.k = i3;
        bArr[i2] = (byte) (i & 255);
        if (i3 >= this.j.length) {
            this.k = 0;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f22797g) {
            if (!this.f22796f) {
                if (this.i != null && !this.i.isAlive() && !this.f22795e && this.k < 0) {
                    throw new IOException("Write end dead");
                }
                this.f22798h = Thread.currentThread();
                int i = 2;
                while (this.k < 0) {
                    if (this.f22795e) {
                        return -1;
                    }
                    if (this.i != null && !this.i.isAlive() && i - 1 < 0) {
                        throw new IOException("Pipe broken");
                    }
                    notifyAll();
                    try {
                        wait(1000L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                byte[] bArr = this.j;
                int i2 = this.l;
                int i3 = i2 + 1;
                this.l = i3;
                int i4 = bArr[i2] & 255;
                if (i3 >= this.j.length) {
                    this.l = 0;
                }
                if (this.k == this.l) {
                    this.k = -1;
                }
                return i4;
            }
            throw new IOException("Pipe closed");
        }
        throw new IOException("Pipe not connected");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void s(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        int i5;
        int i6;
        o();
        this.i = Thread.currentThread();
        while (i2 > 0) {
            if (this.k == this.l) {
                n();
            }
            if (this.l < this.k) {
                i4 = this.j.length;
                i5 = this.k;
            } else {
                if (this.k >= this.l) {
                    i3 = 0;
                } else if (this.k == -1) {
                    this.l = 0;
                    this.k = 0;
                    i3 = this.j.length - 0;
                } else {
                    i4 = this.l;
                    i5 = this.k;
                }
                if (i3 > i2) {
                    i3 = i2;
                }
                System.arraycopy(bArr, i, this.j, this.k, i3);
                i2 -= i3;
                i += i3;
                i6 = this.k + i3;
                this.k = i6;
                if (i6 < this.j.length) {
                    this.k = 0;
                }
            }
            i3 = i4 - i5;
            if (i3 > i2) {
            }
            System.arraycopy(bArr, i, this.j, this.k, i3);
            i2 -= i3;
            i += i3;
            i6 = this.k + i3;
            this.k = i6;
            if (i6 < this.j.length) {
            }
        }
    }

    public synchronized void t() {
        this.f22795e = true;
        notifyAll();
    }

    public PipedInputStreamAndroid25() {
        q(1024);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int length;
        if (bArr != null) {
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            int read = read();
            if (read < 0) {
                return -1;
            }
            bArr[i] = (byte) read;
            int i3 = 1;
            while (this.k >= 0 && i2 > 1) {
                if (this.k > this.l) {
                    length = Math.min(this.j.length - this.l, this.k - this.l);
                } else {
                    length = this.j.length - this.l;
                }
                int i4 = i2 - 1;
                if (length > i4) {
                    length = i4;
                }
                System.arraycopy(this.j, this.l, bArr, i + i3, length);
                int i5 = this.l + length;
                this.l = i5;
                i3 += length;
                i2 -= length;
                if (i5 >= this.j.length) {
                    this.l = 0;
                }
                if (this.k == this.l) {
                    this.k = -1;
                }
            }
            return i3;
        }
        throw new NullPointerException();
    }
}
