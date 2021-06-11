package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class ExifOrientationStream extends FilterInputStream {
    public static final byte[] EXIF_SEGMENT;
    public static final int ORIENTATION_POSITION;
    public static final int SEGMENT_LENGTH;
    public static final int SEGMENT_START_POSITION = 2;
    public final byte orientation;
    public int position;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.orientation = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i2;
        int i3 = this.position;
        if (i3 < 2 || i3 > (i2 = ORIENTATION_POSITION)) {
            read = super.read();
        } else if (i3 == i2) {
            read = this.orientation;
        } else {
            read = EXIF_SEGMENT[i3 - 2] & 255;
        }
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
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
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.position;
        int i6 = ORIENTATION_POSITION;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.orientation;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int min = Math.min(i6 - i5, i3);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i2, min);
            i4 = min;
        }
        if (i4 > 0) {
            this.position += i4;
        }
        return i4;
    }
}
