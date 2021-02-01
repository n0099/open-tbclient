package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes15.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;
    private static final byte[] EXIF_SEGMENT = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    private static final int SEGMENT_LENGTH = EXIF_SEGMENT.length;
    private static final int ORIENTATION_POSITION = SEGMENT_LENGTH + 2;

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.orientation = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        if (this.position < 2 || this.position > ORIENTATION_POSITION) {
            read = super.read();
        } else if (this.position == ORIENTATION_POSITION) {
            read = this.orientation;
        } else {
            read = EXIF_SEGMENT[this.position - 2] & 255;
        }
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int min;
        if (this.position > ORIENTATION_POSITION) {
            min = super.read(bArr, i, i2);
        } else if (this.position == ORIENTATION_POSITION) {
            bArr[i] = this.orientation;
            min = 1;
        } else if (this.position < 2) {
            min = super.read(bArr, i, 2 - this.position);
        } else {
            min = Math.min(ORIENTATION_POSITION - this.position, i2);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i, min);
        }
        if (min > 0) {
            this.position += min;
        }
        return min;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.position = (int) (this.position + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
