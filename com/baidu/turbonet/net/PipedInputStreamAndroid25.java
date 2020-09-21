package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes15.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread nmZ;
    Thread nna;
    boolean nmW = false;
    volatile boolean nmX = false;
    boolean nmY = false;
    protected int nnb = -1;
    protected int nnc = 0;

    static {
        $assertionsDisabled = !PipedInputStreamAndroid25.class.desiredAssertionStatus();
    }

    public PipedInputStreamAndroid25() {
        KV(1024);
    }

    private void KV(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Pipe Size <= 0");
        }
        this.buffer = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void KW(int i) throws IOException {
        dOS();
        this.nna = Thread.currentThread();
        if (this.nnb == this.nnc) {
            dOT();
        }
        if (this.nnb < 0) {
            this.nnb = 0;
            this.nnc = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.nnb;
        this.nnb = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.nnb >= this.buffer.length) {
            this.nnb = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void t(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        dOS();
        this.nna = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.nnb == this.nnc) {
                dOT();
            }
            if (this.nnc < this.nnb) {
                i3 = this.buffer.length - this.nnb;
            } else if (this.nnb >= this.nnc) {
                i3 = 0;
            } else if (this.nnb == -1) {
                this.nnc = 0;
                this.nnb = 0;
                i3 = this.buffer.length - this.nnb;
            } else {
                i3 = this.nnc - this.nnb;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.nnb, i3);
            i4 -= i3;
            i += i3;
            this.nnb = i3 + this.nnb;
            if (this.nnb >= this.buffer.length) {
                this.nnb = 0;
            }
        }
    }

    private void dOS() throws IOException {
        if (!this.nmY) {
            throw new IOException("Pipe not connected");
        }
        if (this.nmW || this.nmX) {
            throw new IOException("Pipe closed");
        }
        if (this.nmZ != null && !this.nmZ.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void dOT() throws IOException {
        while (this.nnb == this.nnc) {
            dOS();
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
    public synchronized void dOU() {
        this.nmW = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.nmY) {
                throw new IOException("Pipe not connected");
            }
            if (this.nmX) {
                throw new IOException("Pipe closed");
            }
            if (this.nna != null && !this.nna.isAlive() && !this.nmW && this.nnb < 0) {
                throw new IOException("Write end dead");
            }
            this.nmZ = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.nnb < 0) {
                    if (this.nmW) {
                        break;
                    } else if (this.nna != null && !this.nna.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.nnc;
                    this.nnc = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.nnc >= this.buffer.length) {
                        this.nnc = 0;
                    }
                    if (this.nnb == this.nnc) {
                        this.nnb = -1;
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
                    while (this.nnb >= 0 && i2 > 1) {
                        if (this.nnb > this.nnc) {
                            length = Math.min(this.buffer.length - this.nnc, this.nnb - this.nnc);
                        } else {
                            length = this.buffer.length - this.nnc;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.nnc, bArr, i + i3, length);
                        this.nnc += length;
                        i3 += length;
                        i2 -= length;
                        if (this.nnc >= this.buffer.length) {
                            this.nnc = 0;
                        }
                        if (this.nnb == this.nnc) {
                            this.nnb = -1;
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
        if (this.nnb < 0) {
            length = 0;
        } else if (this.nnb == this.nnc) {
            length = this.buffer.length;
        } else if (this.nnb > this.nnc) {
            length = this.nnb - this.nnc;
        } else {
            length = (this.nnb + this.buffer.length) - this.nnc;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.nmX = true;
        synchronized (this) {
            this.nnb = -1;
        }
    }
}
