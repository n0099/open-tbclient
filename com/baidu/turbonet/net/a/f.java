package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException noJ;
    private boolean noK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dPA();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dPy() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dPz() throws IOException;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.noJ = iOException;
        this.noK = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.noK) {
            dPO();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dPO() throws IOException {
        if (this.noJ != null) {
            throw this.noJ;
        }
    }
}
