package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes6.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oRp;
    Thread oRq;
    boolean oRn = false;
    volatile boolean oRo = false;
    boolean connected = false;
    protected int in = -1;
    protected int oRr = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        MX(1024);
    }

    private void MX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void MY(int i) throws IOException {
        egG();
        this.oRq = Thread.currentThread();
        if (this.in == this.oRr) {
            egH();
        }
        if (this.in < 0) {
            this.in = 0;
            this.oRr = 0;
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
    public synchronized void u(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        egG();
        this.oRq = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.oRr) {
                egH();
            }
            if (this.oRr < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.oRr) {
                i3 = 0;
            } else if (this.in == -1) {
                this.oRr = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.oRr - this.in;
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

    private void egG() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.oRn || this.oRo) {
            throw new IOException("Pipe closed");
        }
        if (this.oRp != null && !this.oRp.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void egH() throws IOException {
        while (this.in == this.oRr) {
            egG();
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
    public synchronized void egI() {
        this.oRn = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.oRo) {
                throw new IOException("Pipe closed");
            }
            if (this.oRq != null && !this.oRq.isAlive() && !this.oRn && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.oRp = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.oRn) {
                        break;
                    } else if (this.oRq != null && !this.oRq.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.oRr;
                    this.oRr = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.oRr >= this.buffer.length) {
                        this.oRr = 0;
                    }
                    if (this.in == this.oRr) {
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
                        if (this.in > this.oRr) {
                            length = Math.min(this.buffer.length - this.oRr, this.in - this.oRr);
                        } else {
                            length = this.buffer.length - this.oRr;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.oRr, bArr, i + i3, length);
                        this.oRr += length;
                        i3 += length;
                        i2 -= length;
                        if (this.oRr >= this.buffer.length) {
                            this.oRr = 0;
                        }
                        if (this.in == this.oRr) {
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
        } else if (this.in == this.oRr) {
            length = this.buffer.length;
        } else if (this.in > this.oRr) {
            length = this.in - this.oRr;
        } else {
            length = (this.in + this.buffer.length) - this.oRr;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oRo = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
