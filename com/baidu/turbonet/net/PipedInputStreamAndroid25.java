package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes10.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread nda;
    Thread ndb;
    boolean ncX = false;
    volatile boolean ncY = false;
    boolean ncZ = false;
    protected int ndc = -1;
    protected int ndd = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        Kq(1024);
    }

    private void Kq(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void Kr(int i) throws IOException {
        dKU();
        this.ndb = Thread.currentThread();
        if (this.ndc == this.ndd) {
            dKV();
        }
        if (this.ndc < 0) {
            this.ndc = 0;
            this.ndd = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.ndc;
        this.ndc = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.ndc >= this.buffer.length) {
            this.ndc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void t(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dKU();
        this.ndb = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.ndc == this.ndd) {
                dKV();
            }
            if (this.ndd < this.ndc) {
                i3 = this.buffer.length - this.ndc;
            } else if (this.ndc >= this.ndd) {
                i3 = 0;
            } else if (this.ndc == -1) {
                this.ndd = 0;
                this.ndc = 0;
                i3 = this.buffer.length - this.ndc;
            } else {
                i3 = this.ndd - this.ndc;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.ndc, i3);
            i4 -= i3;
            i += i3;
            this.ndc = i3 + this.ndc;
            if (this.ndc >= this.buffer.length) {
                this.ndc = 0;
            }
        }
    }

    private void dKU() throws IOException {
        if (!this.ncZ) {
            throw new IOException("Pipe not connected");
        }
        if (this.ncX || this.ncY) {
            throw new IOException("Pipe closed");
        }
        if (this.nda != null && !this.nda.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dKV() throws IOException {
        while (this.ndc == this.ndd) {
            dKU();
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
    public synchronized void dKW() {
        this.ncX = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.ncZ) {
                throw new IOException("Pipe not connected");
            }
            if (this.ncY) {
                throw new IOException("Pipe closed");
            }
            if (this.ndb != null && !this.ndb.isAlive() && !this.ncX && this.ndc < 0) {
                throw new IOException("Write end dead");
            }
            this.nda = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.ndc < 0) {
                    if (this.ncX) {
                        break;
                    } else if (this.ndb != null && !this.ndb.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.ndd;
                    this.ndd = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.ndd >= this.buffer.length) {
                        this.ndd = 0;
                    }
                    if (this.ndc == this.ndd) {
                        this.ndc = -1;
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
                    while (this.ndc >= 0 && i2 > 1) {
                        if (this.ndc > this.ndd) {
                            length = Math.min(this.buffer.length - this.ndd, this.ndc - this.ndd);
                        } else {
                            length = this.buffer.length - this.ndd;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.ndd, bArr, i + i3, length);
                        this.ndd += length;
                        i3 += length;
                        i2 -= length;
                        if (this.ndd >= this.buffer.length) {
                            this.ndd = 0;
                        }
                        if (this.ndc == this.ndd) {
                            this.ndc = -1;
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
        if (this.ndc < 0) {
            length = 0;
        } else if (this.ndc == this.ndd) {
            length = this.buffer.length;
        } else if (this.ndc > this.ndd) {
            length = this.ndc - this.ndd;
        } else {
            length = (this.ndc + this.buffer.length) - this.ndd;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ncY = true;
        synchronized (this) {
            this.ndc = -1;
        }
    }
}
