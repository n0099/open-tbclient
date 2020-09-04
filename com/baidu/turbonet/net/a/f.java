package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException neJ;
    private boolean neK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dLA() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dLB() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider dLC();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.neJ = iOException;
        this.neK = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.neK) {
            dLQ();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dLQ() throws IOException {
        if (this.neJ != null) {
            throw this.neJ;
        }
    }
}
