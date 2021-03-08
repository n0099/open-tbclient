package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oUD;
    private boolean oUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void ehp() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void ehq() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider ehr();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oUD = iOException;
        this.oUE = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.oUE) {
            ehF();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ehF() throws IOException {
        if (this.oUD != null) {
            throw this.oUD;
        }
    }
}
