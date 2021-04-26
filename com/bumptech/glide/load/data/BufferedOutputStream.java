package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public final class BufferedOutputStream extends OutputStream {
    public ArrayPool arrayPool;
    public byte[] buffer;
    public int index;
    @NonNull
    public final OutputStream out;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void flushBuffer() throws IOException {
        int i2 = this.index;
        if (i2 > 0) {
            this.out.write(this.buffer, 0, i2);
            this.index = 0;
        }
    }

    private void maybeFlushBuffer() throws IOException {
        if (this.index == this.buffer.length) {
            flushBuffer();
        }
    }

    private void release() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            this.arrayPool.put(bArr);
            this.buffer = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.out.close();
            release();
        } catch (Throwable th) {
            this.out.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.buffer;
        int i3 = this.index;
        this.index = i3 + 1;
        bArr[i3] = (byte) i2;
        maybeFlushBuffer();
    }

    @VisibleForTesting
    public BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i2) {
        this.out = outputStream;
        this.arrayPool = arrayPool;
        this.buffer = (byte[]) arrayPool.get(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.index == 0 && i5 >= this.buffer.length) {
                this.out.write(bArr, i6, i5);
                return;
            }
            int min = Math.min(i5, this.buffer.length - this.index);
            System.arraycopy(bArr, i6, this.buffer, this.index, min);
            this.index += min;
            i4 += min;
            maybeFlushBuffer();
        } while (i4 < i3);
    }
}
