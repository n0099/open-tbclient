package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes19.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread mJN;
    Thread mJO;
    boolean mJK = false;
    volatile boolean mJL = false;
    boolean mJM = false;
    protected int mJP = -1;
    protected int mJQ = 0;

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
        dyY();
        this.mJO = Thread.currentThread();
        if (this.mJP == this.mJQ) {
            dyZ();
        }
        if (this.mJP < 0) {
            this.mJP = 0;
            this.mJQ = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.mJP;
        this.mJP = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.mJP >= this.buffer.length) {
            this.mJP = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void s(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dyY();
        this.mJO = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.mJP == this.mJQ) {
                dyZ();
            }
            if (this.mJQ < this.mJP) {
                i3 = this.buffer.length - this.mJP;
            } else if (this.mJP >= this.mJQ) {
                i3 = 0;
            } else if (this.mJP == -1) {
                this.mJQ = 0;
                this.mJP = 0;
                i3 = this.buffer.length - this.mJP;
            } else {
                i3 = this.mJQ - this.mJP;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.mJP, i3);
            i4 -= i3;
            i += i3;
            this.mJP = i3 + this.mJP;
            if (this.mJP >= this.buffer.length) {
                this.mJP = 0;
            }
        }
    }

    private void dyY() throws IOException {
        if (!this.mJM) {
            throw new IOException("Pipe not connected");
        }
        if (this.mJK || this.mJL) {
            throw new IOException("Pipe closed");
        }
        if (this.mJN != null && !this.mJN.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dyZ() throws IOException {
        while (this.mJP == this.mJQ) {
            dyY();
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
    public synchronized void dza() {
        this.mJK = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.mJM) {
                throw new IOException("Pipe not connected");
            }
            if (this.mJL) {
                throw new IOException("Pipe closed");
            }
            if (this.mJO != null && !this.mJO.isAlive() && !this.mJK && this.mJP < 0) {
                throw new IOException("Write end dead");
            }
            this.mJN = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.mJP < 0) {
                    if (this.mJK) {
                        break;
                    } else if (this.mJO != null && !this.mJO.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.mJQ;
                    this.mJQ = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.mJQ >= this.buffer.length) {
                        this.mJQ = 0;
                    }
                    if (this.mJP == this.mJQ) {
                        this.mJP = -1;
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
                    while (this.mJP >= 0 && i2 > 1) {
                        if (this.mJP > this.mJQ) {
                            length = Math.min(this.buffer.length - this.mJQ, this.mJP - this.mJQ);
                        } else {
                            length = this.buffer.length - this.mJQ;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.mJQ, bArr, i + i3, length);
                        this.mJQ += length;
                        i3 += length;
                        i2 -= length;
                        if (this.mJQ >= this.buffer.length) {
                            this.mJQ = 0;
                        }
                        if (this.mJP == this.mJQ) {
                            this.mJP = -1;
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
        if (this.mJP < 0) {
            length = 0;
        } else if (this.mJP == this.mJQ) {
            length = this.buffer.length;
        } else if (this.mJP > this.mJQ) {
            length = this.mJP - this.mJQ;
        } else {
            length = (this.mJP + this.buffer.length) - this.mJQ;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mJL = true;
        synchronized (this) {
            this.mJP = -1;
        }
    }
}
