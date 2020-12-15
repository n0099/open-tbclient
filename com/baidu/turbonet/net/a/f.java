package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oGl;
    private boolean oGm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eio() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eip() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider eiq();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oGl = iOException;
        this.oGm = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.oGm) {
            eiE();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eiE() throws IOException {
        if (this.oGl != null) {
            throw this.oGl;
        }
    }
}
