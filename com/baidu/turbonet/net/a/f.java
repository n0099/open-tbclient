package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException mDn;
    private boolean mDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dwq() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dwr() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dws();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.mDn = iOException;
        this.mDo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.mDo) {
            dwG();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwG() throws IOException {
        if (this.mDn != null) {
            throw this.mDn;
        }
    }
}
