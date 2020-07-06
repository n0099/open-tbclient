package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread mBD;
    Thread mBE;
    boolean mBA = false;
    volatile boolean mBB = false;
    boolean mBC = false;
    protected int mBF = -1;
    protected int mBG = 0;

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
        dvK();
        this.mBE = Thread.currentThread();
        if (this.mBF == this.mBG) {
            dvL();
        }
        if (this.mBF < 0) {
            this.mBF = 0;
            this.mBG = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.mBF;
        this.mBF = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.mBF >= this.buffer.length) {
            this.mBF = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dvK();
        this.mBE = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.mBF == this.mBG) {
                dvL();
            }
            if (this.mBG < this.mBF) {
                i3 = this.buffer.length - this.mBF;
            } else if (this.mBF >= this.mBG) {
                i3 = 0;
            } else if (this.mBF == -1) {
                this.mBG = 0;
                this.mBF = 0;
                i3 = this.buffer.length - this.mBF;
            } else {
                i3 = this.mBG - this.mBF;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.mBF, i3);
            i4 -= i3;
            i += i3;
            this.mBF = i3 + this.mBF;
            if (this.mBF >= this.buffer.length) {
                this.mBF = 0;
            }
        }
    }

    private void dvK() throws IOException {
        if (!this.mBC) {
            throw new IOException("Pipe not connected");
        }
        if (this.mBA || this.mBB) {
            throw new IOException("Pipe closed");
        }
        if (this.mBD != null && !this.mBD.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dvL() throws IOException {
        while (this.mBF == this.mBG) {
            dvK();
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
    public synchronized void dvM() {
        this.mBA = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.mBC) {
                throw new IOException("Pipe not connected");
            }
            if (this.mBB) {
                throw new IOException("Pipe closed");
            }
            if (this.mBE != null && !this.mBE.isAlive() && !this.mBA && this.mBF < 0) {
                throw new IOException("Write end dead");
            }
            this.mBD = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.mBF < 0) {
                    if (this.mBA) {
                        break;
                    } else if (this.mBE != null && !this.mBE.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.mBG;
                    this.mBG = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.mBG >= this.buffer.length) {
                        this.mBG = 0;
                    }
                    if (this.mBF == this.mBG) {
                        this.mBF = -1;
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
                    while (this.mBF >= 0 && i2 > 1) {
                        if (this.mBF > this.mBG) {
                            length = Math.min(this.buffer.length - this.mBG, this.mBF - this.mBG);
                        } else {
                            length = this.buffer.length - this.mBG;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.mBG, bArr, i + i3, length);
                        this.mBG += length;
                        i3 += length;
                        i2 -= length;
                        if (this.mBG >= this.buffer.length) {
                            this.mBG = 0;
                        }
                        if (this.mBF == this.mBG) {
                            this.mBF = -1;
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
        if (this.mBF < 0) {
            length = 0;
        } else if (this.mBF == this.mBG) {
            length = this.buffer.length;
        } else if (this.mBF > this.mBG) {
            length = this.mBF - this.mBG;
        } else {
            length = (this.mBF + this.buffer.length) - this.mBG;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mBB = true;
        synchronized (this) {
            this.mBF = -1;
        }
    }
}
