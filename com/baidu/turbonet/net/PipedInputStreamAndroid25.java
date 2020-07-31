package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes19.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread mJL;
    Thread mJM;
    boolean mJI = false;
    volatile boolean mJJ = false;
    boolean mJK = false;
    protected int mJN = -1;
    protected int mJO = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        HQ(1024);
    }

    private void HQ(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void HR(int i) throws IOException {
        dyX();
        this.mJM = Thread.currentThread();
        if (this.mJN == this.mJO) {
            dyY();
        }
        if (this.mJN < 0) {
            this.mJN = 0;
            this.mJO = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.mJN;
        this.mJN = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.mJN >= this.buffer.length) {
            this.mJN = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void s(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dyX();
        this.mJM = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.mJN == this.mJO) {
                dyY();
            }
            if (this.mJO < this.mJN) {
                i3 = this.buffer.length - this.mJN;
            } else if (this.mJN >= this.mJO) {
                i3 = 0;
            } else if (this.mJN == -1) {
                this.mJO = 0;
                this.mJN = 0;
                i3 = this.buffer.length - this.mJN;
            } else {
                i3 = this.mJO - this.mJN;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.mJN, i3);
            i4 -= i3;
            i += i3;
            this.mJN = i3 + this.mJN;
            if (this.mJN >= this.buffer.length) {
                this.mJN = 0;
            }
        }
    }

    private void dyX() throws IOException {
        if (!this.mJK) {
            throw new IOException("Pipe not connected");
        }
        if (this.mJI || this.mJJ) {
            throw new IOException("Pipe closed");
        }
        if (this.mJL != null && !this.mJL.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dyY() throws IOException {
        while (this.mJN == this.mJO) {
            dyX();
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
    public synchronized void dyZ() {
        this.mJI = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.mJK) {
                throw new IOException("Pipe not connected");
            }
            if (this.mJJ) {
                throw new IOException("Pipe closed");
            }
            if (this.mJM != null && !this.mJM.isAlive() && !this.mJI && this.mJN < 0) {
                throw new IOException("Write end dead");
            }
            this.mJL = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.mJN < 0) {
                    if (this.mJI) {
                        break;
                    } else if (this.mJM != null && !this.mJM.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.mJO;
                    this.mJO = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.mJO >= this.buffer.length) {
                        this.mJO = 0;
                    }
                    if (this.mJN == this.mJO) {
                        this.mJN = -1;
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
                    while (this.mJN >= 0 && i2 > 1) {
                        if (this.mJN > this.mJO) {
                            length = Math.min(this.buffer.length - this.mJO, this.mJN - this.mJO);
                        } else {
                            length = this.buffer.length - this.mJO;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.mJO, bArr, i + i3, length);
                        this.mJO += length;
                        i3 += length;
                        i2 -= length;
                        if (this.mJO >= this.buffer.length) {
                            this.mJO = 0;
                        }
                        if (this.mJN == this.mJO) {
                            this.mJN = -1;
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
        if (this.mJN < 0) {
            length = 0;
        } else if (this.mJN == this.mJO) {
            length = this.buffer.length;
        } else if (this.mJN > this.mJO) {
            length = this.mJN - this.mJO;
        } else {
            length = (this.mJN + this.buffer.length) - this.mJO;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mJJ = true;
        synchronized (this) {
            this.mJN = -1;
        }
    }
}
