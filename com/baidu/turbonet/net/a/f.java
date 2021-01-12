package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oHP;
    private boolean oHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eeH() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eeI() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider eeJ();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oHP = iOException;
        this.oHQ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.oHQ) {
            eeX();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eeX() throws IOException {
        if (this.oHP != null) {
            throw this.oHP;
        }
    }
}
