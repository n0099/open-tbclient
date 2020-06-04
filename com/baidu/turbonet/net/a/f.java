package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException mhr;
    private boolean mhs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void drH() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void drI() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider drJ();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.mhr = iOException;
        this.mhs = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.mhs) {
            drX();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drX() throws IOException {
        if (this.mhr != null) {
            throw this.mhr;
        }
    }
}
