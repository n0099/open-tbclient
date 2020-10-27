package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes17.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oeW;
    Thread oeX;
    boolean oeU = false;
    volatile boolean oeV = false;
    boolean connected = false;
    protected int oeY = -1;
    protected int oeZ = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        MD(1024);
    }

    private void MD(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void ME(int i) throws IOException {
        dYv();
        this.oeX = Thread.currentThread();
        if (this.oeY == this.oeZ) {
            dYw();
        }
        if (this.oeY < 0) {
            this.oeY = 0;
            this.oeZ = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.oeY;
        this.oeY = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.oeY >= this.buffer.length) {
            this.oeY = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void v(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dYv();
        this.oeX = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.oeY == this.oeZ) {
                dYw();
            }
            if (this.oeZ < this.oeY) {
                i3 = this.buffer.length - this.oeY;
            } else if (this.oeY >= this.oeZ) {
                i3 = 0;
            } else if (this.oeY == -1) {
                this.oeZ = 0;
                this.oeY = 0;
                i3 = this.buffer.length - this.oeY;
            } else {
                i3 = this.oeZ - this.oeY;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.oeY, i3);
            i4 -= i3;
            i += i3;
            this.oeY = i3 + this.oeY;
            if (this.oeY >= this.buffer.length) {
                this.oeY = 0;
            }
        }
    }

    private void dYv() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.oeU || this.oeV) {
            throw new IOException("Pipe closed");
        }
        if (this.oeW != null && !this.oeW.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dYw() throws IOException {
        while (this.oeY == this.oeZ) {
            dYv();
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
    public synchronized void dYx() {
        this.oeU = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.oeV) {
                throw new IOException("Pipe closed");
            }
            if (this.oeX != null && !this.oeX.isAlive() && !this.oeU && this.oeY < 0) {
                throw new IOException("Write end dead");
            }
            this.oeW = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.oeY < 0) {
                    if (this.oeU) {
                        break;
                    } else if (this.oeX != null && !this.oeX.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.oeZ;
                    this.oeZ = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.oeZ >= this.buffer.length) {
                        this.oeZ = 0;
                    }
                    if (this.oeY == this.oeZ) {
                        this.oeY = -1;
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
                    while (this.oeY >= 0 && i2 > 1) {
                        if (this.oeY > this.oeZ) {
                            length = Math.min(this.buffer.length - this.oeZ, this.oeY - this.oeZ);
                        } else {
                            length = this.buffer.length - this.oeZ;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.oeZ, bArr, i + i3, length);
                        this.oeZ += length;
                        i3 += length;
                        i2 -= length;
                        if (this.oeZ >= this.buffer.length) {
                            this.oeZ = 0;
                        }
                        if (this.oeY == this.oeZ) {
                            this.oeY = -1;
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
        if (this.oeY < 0) {
            length = 0;
        } else if (this.oeY == this.oeZ) {
            length = this.buffer.length;
        } else if (this.oeY > this.oeZ) {
            length = this.oeY - this.oeZ;
        } else {
            length = (this.oeY + this.buffer.length) - this.oeZ;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.oeV = true;
        synchronized (this) {
            this.oeY = -1;
        }
    }
}
