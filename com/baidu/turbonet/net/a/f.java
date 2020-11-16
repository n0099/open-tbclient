package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oro;
    private boolean orp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void ecI() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void ecJ() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider ecK();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oro = iOException;
        this.orp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.orp) {
            ecY();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ecY() throws IOException {
        if (this.oro != null) {
            throw this.oro;
        }
    }
}
