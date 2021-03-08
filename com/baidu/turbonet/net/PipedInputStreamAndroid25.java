package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes5.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oTu;
    Thread oTv;
    boolean oTs = false;
    volatile boolean oTt = false;
    boolean connected = false;
    protected int in = -1;
    protected int oTw = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        Nb(1024);
    }

    private void Nb(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void Nc(int i) throws IOException {
        egO();
        this.oTv = Thread.currentThread();
        if (this.in == this.oTw) {
            egP();
        }
        if (this.in < 0) {
            this.in = 0;
            this.oTw = 0;
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
        egO();
        this.oTv = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.in == this.oTw) {
                egP();
            }
            if (this.oTw < this.in) {
                i3 = this.buffer.length - this.in;
            } else if (this.in >= this.oTw) {
                i3 = 0;
            } else if (this.in == -1) {
                this.oTw = 0;
                this.in = 0;
                i3 = this.buffer.length - this.in;
            } else {
                i3 = this.oTw - this.in;
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

    private void egO() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.oTs || this.oTt) {
            throw new IOException("Pipe closed");
        }
        if (this.oTu != null && !this.oTu.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void egP() throws IOException {
        while (this.in == this.oTw) {
            egO();
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
    public synchronized void egQ() {
        this.oTs = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.oTt) {
                throw new IOException("Pipe closed");
            }
            if (this.oTv != null && !this.oTv.isAlive() && !this.oTs && this.in < 0) {
                throw new IOException("Write end dead");
            }
            this.oTu = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.in < 0) {
                    if (this.oTs) {
                        break;
                    } else if (this.oTv != null && !this.oTv.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.oTw;
                    this.oTw = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.oTw >= this.buffer.length) {
                        this.oTw = 0;
                    }
                    if (this.in == this.oTw) {
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
                        if (this.in > this.oTw) {
                            length = Math.min(this.buffer.length - this.oTw, this.in - this.oTw);
                        } else {
                            length = this.buffer.length - this.oTw;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.oTw, bArr, i + i3, length);
                        this.oTw += length;
                        i3 += length;
                        i2 -= length;
                        if (this.oTw >= this.buffer.length) {
                            this.oTw = 0;
                        }
                        if (this.in == this.oTw) {
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
        } else if (this.in == this.oTw) {
            length = this.buffer.length;
        } else if (this.in > this.oTw) {
            length = this.in - this.oTw;
        } else {
            length = (this.in + this.buffer.length) - this.oTw;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oTt = true;
        synchronized (this) {
            this.in = -1;
        }
    }
}
