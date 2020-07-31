package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException mLt;
    private boolean mLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dzD() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dzE() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dzF();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.mLt = iOException;
        this.mLu = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.mLu) {
            dzT();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dzT() throws IOException {
        if (this.mLt != null) {
            throw this.mLt;
        }
    }
}
