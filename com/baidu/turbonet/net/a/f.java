package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException nEd;
    private boolean nEe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dTj() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dTk() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dTl();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.nEd = iOException;
        this.nEe = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.nEe) {
            dTz();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dTz() throws IOException {
        if (this.nEd != null) {
            throw this.nEd;
        }
    }
}
