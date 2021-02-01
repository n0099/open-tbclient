package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oRY;
    private boolean oRZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void egZ() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void eha() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider ehb();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oRY = iOException;
        this.oRZ = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.oRZ) {
            ehp();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ehp() throws IOException {
        if (this.oRY != null) {
            throw this.oRY;
        }
    }
}
