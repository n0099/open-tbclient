package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oMu;
    private boolean oMv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider eiA();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eiy() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eiz() throws IOException;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oMu = iOException;
        this.oMv = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.oMv) {
            eiO();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eiO() throws IOException {
        if (this.oMu != null) {
            throw this.oMu;
        }
    }
}
