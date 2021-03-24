package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    public static final String TAG = "ContentLengthStream";
    public static final int UNKNOWN = -1;
    public final long contentLength;
    public int readSoFar;

    public ContentLengthInputStream(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    private int checkReadSoFarOrThrow(int i) throws IOException {
        if (i >= 0) {
            this.readSoFar += i;
        } else if (this.contentLength - this.readSoFar > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
        }
        return i;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, @Nullable String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    public static int parseContentLength(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "failed to parse content length header: " + str, e2);
                }
            }
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - this.readSoFar, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        checkReadSoFarOrThrow(read >= 0 ? 1 : -1);
        return read;
    }

    @NonNull
    public static InputStream obtain(@NonNull InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i, i2));
    }
}
