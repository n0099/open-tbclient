package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException ogF;
    private boolean ogG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dZb() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dZc() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dZd();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.ogF = iOException;
        this.ogG = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.ogG) {
            dZr();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZr() throws IOException {
        if (this.ogF != null) {
            throw this.ogF;
        }
    }
}
