package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes17.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread nCv;
    Thread nCw;
    boolean nCt = false;
    volatile boolean nCu = false;
    boolean connected = false;
    protected int nCx = -1;
    protected int nCy = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        LB(1024);
    }

    private void LB(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void LC(int i) throws IOException {
        dSD();
        this.nCw = Thread.currentThread();
        if (this.nCx == this.nCy) {
            dSE();
        }
        if (this.nCx < 0) {
            this.nCx = 0;
            this.nCy = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.nCx;
        this.nCx = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.nCx >= this.buffer.length) {
            this.nCx = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void v(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dSD();
        this.nCw = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.nCx == this.nCy) {
                dSE();
            }
            if (this.nCy < this.nCx) {
                i3 = this.buffer.length - this.nCx;
            } else if (this.nCx >= this.nCy) {
                i3 = 0;
            } else if (this.nCx == -1) {
                this.nCy = 0;
                this.nCx = 0;
                i3 = this.buffer.length - this.nCx;
            } else {
                i3 = this.nCy - this.nCx;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.nCx, i3);
            i4 -= i3;
            i += i3;
            this.nCx = i3 + this.nCx;
            if (this.nCx >= this.buffer.length) {
                this.nCx = 0;
            }
        }
    }

    private void dSD() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.nCt || this.nCu) {
            throw new IOException("Pipe closed");
        }
        if (this.nCv != null && !this.nCv.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dSE() throws IOException {
        while (this.nCx == this.nCy) {
            dSD();
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
    public synchronized void dSF() {
        this.nCt = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.nCu) {
                throw new IOException("Pipe closed");
            }
            if (this.nCw != null && !this.nCw.isAlive() && !this.nCt && this.nCx < 0) {
                throw new IOException("Write end dead");
            }
            this.nCv = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.nCx < 0) {
                    if (this.nCt) {
                        break;
                    } else if (this.nCw != null && !this.nCw.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.nCy;
                    this.nCy = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.nCy >= this.buffer.length) {
                        this.nCy = 0;
                    }
                    if (this.nCx == this.nCy) {
                        this.nCx = -1;
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
                    while (this.nCx >= 0 && i2 > 1) {
                        if (this.nCx > this.nCy) {
                            length = Math.min(this.buffer.length - this.nCy, this.nCx - this.nCy);
                        } else {
                            length = this.buffer.length - this.nCy;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.nCy, bArr, i + i3, length);
                        this.nCy += length;
                        i3 += length;
                        i2 -= length;
                        if (this.nCy >= this.buffer.length) {
                            this.nCy = 0;
                        }
                        if (this.nCx == this.nCy) {
                            this.nCx = -1;
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
        if (this.nCx < 0) {
            length = 0;
        } else if (this.nCx == this.nCy) {
            length = this.buffer.length;
        } else if (this.nCx > this.nCy) {
            length = this.nCx - this.nCy;
        } else {
            length = (this.nCx + this.buffer.length) - this.nCy;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nCu = true;
        synchronized (this) {
            this.nCx = -1;
        }
    }
}
