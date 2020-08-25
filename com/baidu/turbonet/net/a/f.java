package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException neq;
    private boolean ner;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dLr() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dLs() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dLt();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.neq = iOException;
        this.ner = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.ner) {
            dLH();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dLH() throws IOException {
        if (this.neq != null) {
            throw this.neq;
        }
    }
}
