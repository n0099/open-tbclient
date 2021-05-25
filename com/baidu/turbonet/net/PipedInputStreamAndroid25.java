package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes5.dex */
public class PipedInputStreamAndroid25 extends InputStream {

    /* renamed from: h  reason: collision with root package name */
    public Thread f22362h;

    /* renamed from: i  reason: collision with root package name */
    public Thread f22363i;
    public byte[] j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22359e = false;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f22360f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22361g = false;
    public int k = -1;
    public int l = 0;

    public PipedInputStreamAndroid25(PipedOutputStreamAndroid25 pipedOutputStreamAndroid25, int i2) throws IOException {
        q(i2);
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
        this.f22360f = true;
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
        if (this.f22361g) {
            if (!this.f22359e && !this.f22360f) {
                Thread thread = this.f22362h;
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

    public final void q(int i2) {
        if (i2 > 0) {
            this.j = new byte[i2];
            return;
        }
        throw new IllegalArgumentException("Pipe Size <= 0");
    }

    public synchronized void r(int i2) throws IOException {
        o();
        this.f22363i = Thread.currentThread();
        if (this.k == this.l) {
            n();
        }
        if (this.k < 0) {
            this.k = 0;
            this.l = 0;
        }
        byte[] bArr = this.j;
        int i3 = this.k;
        int i4 = i3 + 1;
        this.k = i4;
        bArr[i3] = (byte) (i2 & 255);
        if (i4 >= this.j.length) {
            this.k = 0;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f22361g) {
            if (!this.f22360f) {
                if (this.f22363i != null && !this.f22363i.isAlive() && !this.f22359e && this.k < 0) {
                    throw new IOException("Write end dead");
                }
                this.f22362h = Thread.currentThread();
                int i2 = 2;
                while (this.k < 0) {
                    if (this.f22359e) {
                        return -1;
                    }
                    if (this.f22363i != null && !this.f22363i.isAlive() && i2 - 1 < 0) {
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
                int i3 = this.l;
                int i4 = i3 + 1;
                this.l = i4;
                int i5 = bArr[i3] & 255;
                if (i4 >= this.j.length) {
                    this.l = 0;
                }
                if (this.k == this.l) {
                    this.k = -1;
                }
                return i5;
            }
            throw new IOException("Pipe closed");
        }
        throw new IOException("Pipe not connected");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void s(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int i6;
        int i7;
        o();
        this.f22363i = Thread.currentThread();
        while (i3 > 0) {
            if (this.k == this.l) {
                n();
            }
            if (this.l < this.k) {
                i5 = this.j.length;
                i6 = this.k;
            } else {
                if (this.k >= this.l) {
                    i4 = 0;
                } else if (this.k == -1) {
                    this.l = 0;
                    this.k = 0;
                    i4 = this.j.length - 0;
                } else {
                    i5 = this.l;
                    i6 = this.k;
                }
                if (i4 > i3) {
                    i4 = i3;
                }
                System.arraycopy(bArr, i2, this.j, this.k, i4);
                i3 -= i4;
                i2 += i4;
                i7 = this.k + i4;
                this.k = i7;
                if (i7 < this.j.length) {
                    this.k = 0;
                }
            }
            i4 = i5 - i6;
            if (i4 > i3) {
            }
            System.arraycopy(bArr, i2, this.j, this.k, i4);
            i3 -= i4;
            i2 += i4;
            i7 = this.k + i4;
            this.k = i7;
            if (i7 < this.j.length) {
            }
        }
    }

    public synchronized void t() {
        this.f22359e = true;
        notifyAll();
    }

    public PipedInputStreamAndroid25() {
        q(1024);
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int length;
        if (bArr != null) {
            if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            if (i3 == 0) {
                return 0;
            }
            int read = read();
            if (read < 0) {
                return -1;
            }
            bArr[i2] = (byte) read;
            int i4 = 1;
            while (this.k >= 0 && i3 > 1) {
                if (this.k > this.l) {
                    length = Math.min(this.j.length - this.l, this.k - this.l);
                } else {
                    length = this.j.length - this.l;
                }
                int i5 = i3 - 1;
                if (length > i5) {
                    length = i5;
                }
                System.arraycopy(this.j, this.l, bArr, i2 + i4, length);
                int i6 = this.l + length;
                this.l = i6;
                i4 += length;
                i3 -= length;
                if (i6 >= this.j.length) {
                    this.l = 0;
                }
                if (this.k == this.l) {
                    this.k = -1;
                }
            }
            return i4;
        }
        throw new NullPointerException();
    }
}
