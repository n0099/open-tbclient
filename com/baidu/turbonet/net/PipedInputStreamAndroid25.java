package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes5.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oLl;
    Thread oLm;
    boolean oLj = false;
    volatile boolean oLk = false;
    boolean connected = false;
    protected int in = -1;
    protected int oLn = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        Oh(1024);
    }

    private void Oh(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void Oi(int i) throws IOException {
        ehX();
        this.oLm = Thread.currentThread();
        if (this.in == this.oLn) {
            ehY();
        }
        if (this.in < 0) {
            this.in = 0;
            this.oLn = 0;
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
    public synchronized void v(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        ehX();
        this.oLm = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.oLn) {
                ehY();
            }
            if (this.oLn < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.oLn) {
                i3 = 0;
            } else if (this.in == -1) {
                this.oLn = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.oLn - this.in;
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

    private void ehX() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.oLj || this.oLk) {
            throw new IOException("Pipe closed");
        }
        if (this.oLl != null && !this.oLl.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void ehY() throws IOException {
        while (this.in == this.oLn) {
            ehX();
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
    public synchronized void ehZ() {
        this.oLj = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.oLk) {
                throw new IOException("Pipe closed");
            }
            if (this.oLm != null && !this.oLm.isAlive() && !this.oLj && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.oLl = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.oLj) {
                        break;
                    } else if (this.oLm != null && !this.oLm.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.oLn;
                    this.oLn = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.oLn >= this.buffer.length) {
                        this.oLn = 0;
                    }
                    if (this.in == this.oLn) {
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
                        if (this.in > this.oLn) {
                            length = Math.min(this.buffer.length - this.oLn, this.in - this.oLn);
                        } else {
                            length = this.buffer.length - this.oLn;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.oLn, bArr, i + i3, length);
                        this.oLn += length;
                        i3 += length;
                        i2 -= length;
                        if (this.oLn >= this.buffer.length) {
                            this.oLn = 0;
                        }
                        if (this.in == this.oLn) {
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
        } else if (this.in == this.oLn) {
            length = this.buffer.length;
        } else if (this.in > this.oLn) {
            length = this.in - this.oLn;
        } else {
            length = (this.in + this.buffer.length) - this.oLn;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oLk = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
