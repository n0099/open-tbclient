package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException mgh;
    private boolean mgi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void drt() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dru() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider drv();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.mgh = iOException;
        this.mgi = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.mgi) {
            drJ();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drJ() throws IOException {
        if (this.mgh != null) {
            throw this.mgh;
        }
    }
}
