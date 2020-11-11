package com.baidu.turbonet.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
/* loaded from: classes17.dex */
public class PipedInputStreamAndroid25 extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected byte[] buffer;
    Thread oob;
    Thread ooc;
    boolean onZ = false;
    volatile boolean ooa = false;
    boolean connected = false;
    protected int ood = -1;
    protected int ooe = 0;

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
        ecd();
        this.ooc = Thread.currentThread();
        if (this.ood == this.ooe) {
            ece();
        }
        if (this.ood < 0) {
            this.ood = 0;
            this.ooe = 0;
        }
        byte[] bArr = this.buffer;
        int i2 = this.ood;
        this.ood = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        if (this.ood >= this.buffer.length) {
            this.ood = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void v(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        ecd();
        this.ooc = Thread.currentThread();
        int i4 = i2;
        while (i4 > 0) {
            if (this.ood == this.ooe) {
                ece();
            }
            if (this.ooe < this.ood) {
                i3 = this.buffer.length - this.ood;
            } else if (this.ood >= this.ooe) {
                i3 = 0;
            } else if (this.ood == -1) {
                this.ooe = 0;
                this.ood = 0;
                i3 = this.buffer.length - this.ood;
            } else {
                i3 = this.ooe - this.ood;
            }
            if (i3 > i4) {
                i3 = i4;
            }
            if (!$assertionsDisabled && i3 <= 0) {
                throw new AssertionError();
            }
            System.arraycopy(bArr, i, this.buffer, this.ood, i3);
            i4 -= i3;
            i += i3;
            this.ood = i3 + this.ood;
            if (this.ood >= this.buffer.length) {
                this.ood = 0;
            }
        }
    }

    private void ecd() throws IOException {
        if (!this.connected) {
            throw new IOException("Pipe not connected");
        }
        if (this.onZ || this.ooa) {
            throw new IOException("Pipe closed");
        }
        if (this.oob != null && !this.oob.isAlive()) {
            throw new IOException("Read end dead");
        }
    }

    private void ece() throws IOException {
        while (this.ood == this.ooe) {
            ecd();
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
    public synchronized void ecf() {
        this.onZ = true;
        notifyAll();
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i = -1;
        synchronized (this) {
            if (!this.connected) {
                throw new IOException("Pipe not connected");
            }
            if (this.ooa) {
                throw new IOException("Pipe closed");
            }
            if (this.ooc != null && !this.ooc.isAlive() && !this.onZ && this.ood < 0) {
                throw new IOException("Write end dead");
            }
            this.oob = Thread.currentThread();
            int i2 = 2;
            while (true) {
                if (this.ood < 0) {
                    if (this.onZ) {
                        break;
                    } else if (this.ooc != null && !this.ooc.isAlive() && i2 - 1 < 0) {
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
                    int i3 = this.ooe;
                    this.ooe = i3 + 1;
                    i = bArr[i3] & 255;
                    if (this.ooe >= this.buffer.length) {
                        this.ooe = 0;
                    }
                    if (this.ood == this.ooe) {
                        this.ood = -1;
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
                    while (this.ood >= 0 && i2 > 1) {
                        if (this.ood > this.ooe) {
                            length = Math.min(this.buffer.length - this.ooe, this.ood - this.ooe);
                        } else {
                            length = this.buffer.length - this.ooe;
                        }
                        if (length > i2 - 1) {
                            length = i2 - 1;
                        }
                        System.arraycopy(this.buffer, this.ooe, bArr, i + i3, length);
                        this.ooe += length;
                        i3 += length;
                        i2 -= length;
                        if (this.ooe >= this.buffer.length) {
                            this.ooe = 0;
                        }
                        if (this.ood == this.ooe) {
                            this.ood = -1;
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
        if (this.ood < 0) {
            length = 0;
        } else if (this.ood == this.ooe) {
            length = this.buffer.length;
        } else if (this.ood > this.ooe) {
            length = this.ood - this.ooe;
        } else {
            length = (this.ood + this.buffer.length) - this.ooe;
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ooa = true;
        synchronized (this) {
            this.ood = -1;
        }
    }
}
