package com.baidu.turbonet.net.proxy;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class a extends InputStream {
    private static final String TAG = a.class.getName();
    private InputStream inputStream;
    private b mfG;
    private long bytesRead = 0;
    private boolean mfH = false;

    public a(InputStream inputStream, b bVar) {
        this.inputStream = inputStream;
        this.mfG = bVar;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.mfH) {
            return -1;
        }
        try {
            int read = this.inputStream.read(bArr, 0, bArr.length);
            if (read >= 0) {
                this.bytesRead += read;
            } else {
                this.mfH = true;
                this.mfG.onComplete(this.bytesRead);
            }
            return read;
        } catch (IOException e) {
            this.mfG.a(e, this.bytesRead);
            throw e;
        } catch (IllegalStateException e2) {
            Log.e(TAG, "Exception reading data from InputStream", e2);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.mfH) {
            return -1;
        }
        try {
            int read = this.inputStream.read(bArr, i, i2);
            if (read >= 0) {
                this.bytesRead += read;
            } else {
                this.mfH = true;
                this.mfG.onComplete(this.bytesRead);
            }
            return read;
        } catch (IOException e) {
            this.mfG.a(e, this.bytesRead);
            throw e;
        } catch (IllegalStateException e2) {
            Log.e(TAG, "Exception reading data from InputStream", e2);
            return -1;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.inputStream.skip(j);
        this.bytesRead += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return this.inputStream.available();
        } catch (IOException e) {
            this.mfG.a(e, this.bytesRead);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.mfH) {
            this.mfH = true;
            try {
                if (this.inputStream.read() == -1) {
                    this.mfG.onComplete(this.bytesRead);
                } else {
                    this.mfG.fy(this.bytesRead);
                }
                try {
                    this.inputStream.close();
                } catch (Exception e) {
                    this.mfG.a(e, this.bytesRead);
                }
            } catch (Exception e2) {
                try {
                    this.inputStream.close();
                } catch (Exception e3) {
                    this.mfG.a(e3, this.bytesRead);
                }
            } catch (Throwable th) {
                try {
                    this.inputStream.close();
                } catch (Exception e4) {
                    this.mfG.a(e4, this.bytesRead);
                }
                throw th;
            }
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            this.inputStream.reset();
        } catch (IOException e) {
            this.mfG.a(e, this.bytesRead);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.mfH) {
            return -1;
        }
        try {
            int read = this.inputStream.read();
            if (read >= 0) {
                this.bytesRead += read;
            } else {
                this.mfH = true;
                this.mfG.onComplete(this.bytesRead);
            }
            return read;
        } catch (IOException e) {
            this.mfG.a(e, this.bytesRead);
            throw e;
        } catch (IllegalStateException e2) {
            Log.e(TAG, "Exception reading data from InputStream", e2);
            return -1;
        }
    }
}
