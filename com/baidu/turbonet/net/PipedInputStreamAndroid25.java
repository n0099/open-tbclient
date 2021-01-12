package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes4.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oGG;
    Thread oGH;
    boolean oGE = false;
    volatile boolean oGF = false;
    boolean connected = false;
    protected int in = -1;
    protected int oGI = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        MA(1024);
    }

    private void MA(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void MB(int i) throws IOException {
        eeg();
        this.oGH = Thread.currentThread();
        if (this.in == this.oGI) {
            eeh();
        }
        if (this.in < 0) {
            this.in = 0;
            this.oGI = 0;
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
        eeg();
        this.oGH = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.oGI) {
                eeh();
            }
            if (this.oGI < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.oGI) {
                i3 = 0;
            } else if (this.in == -1) {
                this.oGI = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.oGI - this.in;
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

    private void eeg() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.oGE || this.oGF) {
            throw new IOException("Pipe closed");
        }
        if (this.oGG != null && !this.oGG.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void eeh() throws IOException {
        while (this.in == this.oGI) {
            eeg();
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
    public synchronized void eei() {
        this.oGE = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.oGF) {
                throw new IOException("Pipe closed");
            }
            if (this.oGH != null && !this.oGH.isAlive() && !this.oGE && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.oGG = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.oGE) {
                        break;
                    } else if (this.oGH != null && !this.oGH.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.oGI;
                    this.oGI = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.oGI >= this.buffer.length) {
                        this.oGI = 0;
                    }
                    if (this.in == this.oGI) {
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
                        if (this.in > this.oGI) {
                            length = Math.min(this.buffer.length - this.oGI, this.in - this.oGI);
                        } else {
                            length = this.buffer.length - this.oGI;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.oGI, bArr, i + i3, length);
                        this.oGI += length;
                        i3 += length;
                        i2 -= length;
                        if (this.oGI >= this.buffer.length) {
                            this.oGI = 0;
                        }
                        if (this.in == this.oGI) {
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
        } else if (this.in == this.oGI) {
            length = this.buffer.length;
        } else if (this.in > this.oGI) {
            length = this.in - this.oGI;
        } else {
            length = (this.in + this.buffer.length) - this.oGI;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oGF = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
