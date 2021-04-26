package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {
    public volatile byte[] buf;
    public final ArrayPool byteArrayPool;
    public int count;
    public int marklimit;
    public int markpos;
    public int pos;

    /* loaded from: classes5.dex */
    public static class InvalidMarkException extends IOException {
        public static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.markpos;
        if (i2 != -1) {
            int i3 = this.pos - i2;
            int i4 = this.marklimit;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.byteArrayPool.get(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    this.byteArrayPool.put(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.markpos;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                int i6 = this.pos - this.markpos;
                this.pos = i6;
                this.markpos = 0;
                this.count = 0;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                int i7 = this.pos;
                if (read > 0) {
                    i7 += read;
                }
                this.count = i7;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = read2;
        }
        return read2;
    }

    public static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.buf != null && inputStream != null) {
        } else {
            throw streamClosed();
        }
        return (this.count - this.pos) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.marklimit = Math.max(this.marklimit, i2);
        this.markpos = this.pos;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.pos < this.count || fillbuf(inputStream, bArr) != -1) {
                if (bArr != this.buf && (bArr = this.buf) == null) {
                    throw streamClosed();
                }
                if (this.count - this.pos > 0) {
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    return bArr[i2] & 255;
                }
                return -1;
            }
            return -1;
        }
        throw streamClosed();
    }

    public synchronized void release() {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.buf != null) {
            if (-1 != this.markpos) {
                this.pos = this.markpos;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.pos + " markLimit: " + this.marklimit);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.buf;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                if (this.count - this.pos >= j) {
                    this.pos = (int) (this.pos + j);
                    return j;
                }
                long j2 = this.count - this.pos;
                this.pos = this.count;
                if (this.markpos != -1 && j <= this.marklimit) {
                    if (fillbuf(inputStream, bArr) == -1) {
                        return j2;
                    }
                    if (this.count - this.pos >= j - j2) {
                        this.pos = (int) ((this.pos + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + this.count) - this.pos;
                    this.pos = this.count;
                    return j3;
                }
                return j2 + inputStream.skip(j - j2);
            }
            throw streamClosed();
        }
        throw streamClosed();
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i2) {
        super(inputStream);
        this.markpos = -1;
        this.byteArrayPool = arrayPool;
        this.buf = (byte[]) arrayPool.get(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.buf;
        if (bArr2 == null) {
            throw streamClosed();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.pos < this.count) {
                int i6 = this.count - this.pos >= i3 ? i3 : this.count - this.pos;
                System.arraycopy(bArr2, this.pos, bArr, i2, i6);
                this.pos += i6;
                if (i6 == i3 || inputStream.available() == 0) {
                    return i6;
                }
                i2 += i6;
                i4 = i3 - i6;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.markpos == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else if (fillbuf(inputStream, bArr2) == -1) {
                    return i4 != i3 ? i3 - i4 : -1;
                } else {
                    if (bArr2 != this.buf && (bArr2 = this.buf) == null) {
                        throw streamClosed();
                    }
                    i5 = this.count - this.pos >= i4 ? i4 : this.count - this.pos;
                    System.arraycopy(bArr2, this.pos, bArr, i2, i5);
                    this.pos += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            throw streamClosed();
        }
    }
}
