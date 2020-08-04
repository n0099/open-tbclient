package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException mLv;
    private boolean mLw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dzE() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dzF() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dzG();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.mLv = iOException;
        this.mLw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.mLw) {
            dzU();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dzU() throws IOException {
        if (this.mLv != null) {
            throw this.mLv;
        }
    }
}
