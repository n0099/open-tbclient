package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread lLl;
    Thread lLm;
    boolean lLi = false;
    volatile boolean lLj = false;
    boolean lLk = false;
    protected int in = -1;
    protected int lLn = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        Fz(1024);
    }

    private void Fz(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void FA(int i) throws IOException {
        djw();
        this.lLm = Thread.currentThread();
        if (this.in == this.lLn) {
            djx();
        }
        if (this.in < 0) {
            this.in = 0;
            this.lLn = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.in;
        this.in = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.in >= this.buffer.length) {
            this.in = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void q(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        djw();
        this.lLm = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.lLn) {
                djx();
            }
            if (this.lLn < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.lLn) {
                i3 = 0;
            } else if (this.in == -1) {
                this.lLn = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.lLn - this.in;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.in, i3);
            i4 -= i3;
            i += i3;
            this.in = i3 + this.in;
            if (this.in >= this.buffer.length) {
                this.in = 0;
            }
        }
    }

    private void djw() throws IOException {
        if (!this.lLk) {
            throw new IOException("Pipe not connected");
        }
        if (this.lLi || this.lLj) {
            throw new IOException("Pipe closed");
        }
        if (this.lLl != null && !this.lLl.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void djx() throws IOException {
        while (this.in == this.lLn) {
            djw();
            notifyAll();
            try {
                wait(1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void djy() {
        this.lLi = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.lLk) {
                throw new IOException("Pipe not connected");
            }
            if (this.lLj) {
                throw new IOException("Pipe closed");
            }
            if (this.lLm != null && !this.lLm.isAlive() && !this.lLi && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.lLl = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.lLi) {
                        break;
                    } else if (this.lLm != null && !this.lLm.isAlive() && i2 - 1 < 0) {
                        throw new IOException("Pipe broken");
                    } else {
                        notifyAll();
                        try {
                            wait(1000L);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                } else {
                    byte[] bArr = this.buffer;
                    int i3 = this.lLn;
                    this.lLn = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.lLn >= this.buffer.length) {
                        this.lLn = 0;
                    }
                    if (this.in == this.lLn) {
                        this.in = -1;
                    }
                }
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int length;
        int i3 = 0;
        synchronized (this) {
            if (bArr == null) {
                throw new NullPointerException();
            }
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 != 0) {
                int read = read();
                if (read < 0) {
                    i3 = -1;
                } else {
                    bArr[i] = (byte) read;
                    i3 = 1;
                    while (this.in >= 0 && i2 > 1) {
                        if (this.in > this.lLn) {
                            length = Math.min(this.buffer.length - this.lLn, this.in - this.lLn);
                        } else {
                            length = this.buffer.length - this.lLn;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.lLn, bArr, i + i3, length);
                        this.lLn += length;
                        i3 += length;
                        i2 -= length;
                        if (this.lLn >= this.buffer.length) {
                            this.lLn = 0;
                        }
                        if (this.in == this.lLn) {
                            this.in = -1;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        int length;
        if (this.in < 0) {
            length = 0;
        } else if (this.in == this.lLn) {
            length = this.buffer.length;
        } else if (this.in > this.lLn) {
            length = this.in - this.lLn;
        } else {
            length = (this.in + this.buffer.length) - this.lLn;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.lLj = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
