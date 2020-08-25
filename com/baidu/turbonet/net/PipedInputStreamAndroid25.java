package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes10.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread ncI;
    Thread ncJ;
    boolean ncF = false;
    volatile boolean ncG = false;
    boolean ncH = false;
    protected int ncK = -1;
    protected int ncL = 0;

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
        dKL();
        this.ncJ = Thread.currentThread();
        if (this.ncK == this.ncL) {
            dKM();
        }
        if (this.ncK < 0) {
            this.ncK = 0;
            this.ncL = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.ncK;
        this.ncK = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.ncK >= this.buffer.length) {
            this.ncK = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void t(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dKL();
        this.ncJ = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.ncK == this.ncL) {
                dKM();
            }
            if (this.ncL < this.ncK) {
                i3 = this.buffer.length - this.ncK;
            } else if (this.ncK >= this.ncL) {
                i3 = 0;
            } else if (this.ncK == -1) {
                this.ncL = 0;
                this.ncK = 0;
                i3 = this.buffer.length - this.ncK;
            } else {
                i3 = this.ncL - this.ncK;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.ncK, i3);
            i4 -= i3;
            i += i3;
            this.ncK = i3 + this.ncK;
            if (this.ncK >= this.buffer.length) {
                this.ncK = 0;
            }
        }
    }

    private void dKL() throws IOException {
        if (!this.ncH) {
            throw new IOException("Pipe not connected");
        }
        if (this.ncF || this.ncG) {
            throw new IOException("Pipe closed");
        }
        if (this.ncI != null && !this.ncI.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dKM() throws IOException {
        while (this.ncK == this.ncL) {
            dKL();
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
    public synchronized void dKN() {
        this.ncF = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.ncH) {
                throw new IOException("Pipe not connected");
            }
            if (this.ncG) {
                throw new IOException("Pipe closed");
            }
            if (this.ncJ != null && !this.ncJ.isAlive() && !this.ncF && this.ncK < 0) {
                throw new IOException("Write end dead");
            }
            this.ncI = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.ncK < 0) {
                    if (this.ncF) {
                        break;
                    } else if (this.ncJ != null && !this.ncJ.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.ncL;
                    this.ncL = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.ncL >= this.buffer.length) {
                        this.ncL = 0;
                    }
                    if (this.ncK == this.ncL) {
                        this.ncK = -1;
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
                    while (this.ncK >= 0 && i2 > 1) {
                        if (this.ncK > this.ncL) {
                            length = Math.min(this.buffer.length - this.ncL, this.ncK - this.ncL);
                        } else {
                            length = this.buffer.length - this.ncL;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.ncL, bArr, i + i3, length);
                        this.ncL += length;
                        i3 += length;
                        i2 -= length;
                        if (this.ncL >= this.buffer.length) {
                            this.ncL = 0;
                        }
                        if (this.ncK == this.ncL) {
                            this.ncK = -1;
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
        if (this.ncK < 0) {
            length = 0;
        } else if (this.ncK == this.ncL) {
            length = this.buffer.length;
        } else if (this.ncK > this.ncL) {
            length = this.ncK - this.ncL;
        } else {
            length = (this.ncK + this.buffer.length) - this.ncL;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ncG = true;
        synchronized (this) {
            this.ncK = -1;
        }
    }
}
