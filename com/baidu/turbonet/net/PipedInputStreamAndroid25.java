package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread meA;
    Thread meB;
    boolean mex = false;
    volatile boolean mey = false;
    boolean mez = false;
    protected int in = -1;
    protected int meC = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        Gm(1024);
    }

    private void Gm(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void Gn(int i) throws IOException {
        dqN();
        this.meB = Thread.currentThread();
        if (this.in == this.meC) {
            dqO();
        }
        if (this.in < 0) {
            this.in = 0;
            this.meC = 0;
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
    public synchronized void r(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dqN();
        this.meB = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.meC) {
                dqO();
            }
            if (this.meC < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.meC) {
                i3 = 0;
            } else if (this.in == -1) {
                this.meC = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.meC - this.in;
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

    private void dqN() throws IOException {
        if (!this.mez) {
            throw new IOException("Pipe not connected");
        }
        if (this.mex || this.mey) {
            throw new IOException("Pipe closed");
        }
        if (this.meA != null && !this.meA.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dqO() throws IOException {
        while (this.in == this.meC) {
            dqN();
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
    public synchronized void dqP() {
        this.mex = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.mez) {
                throw new IOException("Pipe not connected");
            }
            if (this.mey) {
                throw new IOException("Pipe closed");
            }
            if (this.meB != null && !this.meB.isAlive() && !this.mex && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.meA = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.mex) {
                        break;
                    } else if (this.meB != null && !this.meB.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.meC;
                    this.meC = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.meC >= this.buffer.length) {
                        this.meC = 0;
                    }
                    if (this.in == this.meC) {
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
                        if (this.in > this.meC) {
                            length = Math.min(this.buffer.length - this.meC, this.in - this.meC);
                        } else {
                            length = this.buffer.length - this.meC;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.meC, bArr, i + i3, length);
                        this.meC += length;
                        i3 += length;
                        i2 -= length;
                        if (this.meC >= this.buffer.length) {
                            this.meC = 0;
                        }
                        if (this.in == this.meC) {
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
        } else if (this.in == this.meC) {
            length = this.buffer.length;
        } else if (this.in > this.meC) {
            length = this.in - this.meC;
        } else {
            length = (this.in + this.buffer.length) - this.meC;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mey = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
