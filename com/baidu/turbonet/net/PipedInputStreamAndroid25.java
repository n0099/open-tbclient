package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes6.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oQP;
    Thread oQQ;
    boolean oQN = false;
    volatile boolean oQO = false;
    boolean connected = false;
    protected int in = -1;
    protected int oQR = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        MW(1024);
    }

    private void MW(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void MX(int i) throws IOException {
        egy();
        this.oQQ = Thread.currentThread();
        if (this.in == this.oQR) {
            egz();
        }
        if (this.in < 0) {
            this.in = 0;
            this.oQR = 0;
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
        egy();
        this.oQQ = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.oQR) {
                egz();
            }
            if (this.oQR < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.oQR) {
                i3 = 0;
            } else if (this.in == -1) {
                this.oQR = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.oQR - this.in;
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

    private void egy() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.oQN || this.oQO) {
            throw new IOException("Pipe closed");
        }
        if (this.oQP != null && !this.oQP.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void egz() throws IOException {
        while (this.in == this.oQR) {
            egy();
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
    public synchronized void egA() {
        this.oQN = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.oQO) {
                throw new IOException("Pipe closed");
            }
            if (this.oQQ != null && !this.oQQ.isAlive() && !this.oQN && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.oQP = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.oQN) {
                        break;
                    } else if (this.oQQ != null && !this.oQQ.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.oQR;
                    this.oQR = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.oQR >= this.buffer.length) {
                        this.oQR = 0;
                    }
                    if (this.in == this.oQR) {
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
                        if (this.in > this.oQR) {
                            length = Math.min(this.buffer.length - this.oQR, this.in - this.oQR);
                        } else {
                            length = this.buffer.length - this.oQR;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.oQR, bArr, i + i3, length);
                        this.oQR += length;
                        i3 += length;
                        i2 -= length;
                        if (this.oQR >= this.buffer.length) {
                            this.oQR = 0;
                        }
                        if (this.in == this.oQR) {
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
        } else if (this.in == this.oQR) {
            length = this.buffer.length;
        } else if (this.in > this.oQR) {
            length = this.in - this.oQR;
        } else {
            length = (this.in + this.buffer.length) - this.oQR;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oQO = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
