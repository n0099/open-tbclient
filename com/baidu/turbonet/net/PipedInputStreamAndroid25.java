package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread mBA;
    Thread mBB;
    boolean mBx = false;
    volatile boolean mBy = false;
    boolean mBz = false;
    protected int mBC = -1;
    protected int mBD = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        Hv(1024);
    }

    private void Hv(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void Hw(int i) throws IOException {
        dvG();
        this.mBB = Thread.currentThread();
        if (this.mBC == this.mBD) {
            dvH();
        }
        if (this.mBC < 0) {
            this.mBC = 0;
            this.mBD = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.mBC;
        this.mBC = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.mBC >= this.buffer.length) {
            this.mBC = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dvG();
        this.mBB = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.mBC == this.mBD) {
                dvH();
            }
            if (this.mBD < this.mBC) {
                i3 = this.buffer.length - this.mBC;
            } else if (this.mBC >= this.mBD) {
                i3 = 0;
            } else if (this.mBC == -1) {
                this.mBD = 0;
                this.mBC = 0;
                i3 = this.buffer.length - this.mBC;
            } else {
                i3 = this.mBD - this.mBC;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.mBC, i3);
            i4 -= i3;
            i += i3;
            this.mBC = i3 + this.mBC;
            if (this.mBC >= this.buffer.length) {
                this.mBC = 0;
            }
        }
    }

    private void dvG() throws IOException {
        if (!this.mBz) {
            throw new IOException("Pipe not connected");
        }
        if (this.mBx || this.mBy) {
            throw new IOException("Pipe closed");
        }
        if (this.mBA != null && !this.mBA.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dvH() throws IOException {
        while (this.mBC == this.mBD) {
            dvG();
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
    public synchronized void dvI() {
        this.mBx = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.mBz) {
                throw new IOException("Pipe not connected");
            }
            if (this.mBy) {
                throw new IOException("Pipe closed");
            }
            if (this.mBB != null && !this.mBB.isAlive() && !this.mBx && this.mBC < 0) {
                throw new IOException("Write end dead");
            }
            this.mBA = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.mBC < 0) {
                    if (this.mBx) {
                        break;
                    } else if (this.mBB != null && !this.mBB.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.mBD;
                    this.mBD = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.mBD >= this.buffer.length) {
                        this.mBD = 0;
                    }
                    if (this.mBC == this.mBD) {
                        this.mBC = -1;
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
                    while (this.mBC >= 0 && i2 > 1) {
                        if (this.mBC > this.mBD) {
                            length = Math.min(this.buffer.length - this.mBD, this.mBC - this.mBD);
                        } else {
                            length = this.buffer.length - this.mBD;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.mBD, bArr, i + i3, length);
                        this.mBD += length;
                        i3 += length;
                        i2 -= length;
                        if (this.mBD >= this.buffer.length) {
                            this.mBD = 0;
                        }
                        if (this.mBC == this.mBD) {
                            this.mBC = -1;
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
        if (this.mBC < 0) {
            length = 0;
        } else if (this.mBC == this.mBD) {
            length = this.buffer.length;
        } else if (this.mBC > this.mBD) {
            length = this.mBC - this.mBD;
        } else {
            length = (this.mBC + this.buffer.length) - this.mBD;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mBy = true;
        synchronized (this) {
            this.mBC = -1;
        }
    }
}
