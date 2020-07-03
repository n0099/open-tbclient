package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException mDk;
    private boolean mDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dwm() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dwn() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dwo();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.mDk = iOException;
        this.mDl = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.mDl) {
            dwC();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dwC() throws IOException {
        if (this.mDk != null) {
            throw this.mDk;
        }
    }
}
