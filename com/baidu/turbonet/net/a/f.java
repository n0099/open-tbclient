package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends OutputStream {
    private IOException lMS;
    private boolean lMT;
    private boolean mClosed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dkc() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dkd() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dke();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(IOException iOException) {
        this.lMS = iOException;
        this.lMT = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.lMT) {
            dks();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dks() throws IOException {
        if (this.lMS != null) {
            throw this.lMS;
        }
    }
}
