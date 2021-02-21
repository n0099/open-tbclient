package com.baidu.turbonet.net.a;

import com.baidu.turbonet.net.UploadDataProvider;
import java.io.IOException;
import java.io.OutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class f extends OutputStream {
    private boolean mClosed;
    private IOException oSy;
    private boolean oSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void ehh() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void ehi() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract UploadDataProvider ehj();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mClosed = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(IOException iOException) {
        this.oSy = iOException;
        this.oSz = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkNotClosed() throws IOException {
        if (this.oSz) {
            ehx();
            throw new IOException("Writing after request completed.");
        } else if (this.mClosed) {
            throw new IOException("Stream has been closed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ehx() throws IOException {
        if (this.oSy != null) {
            throw this.oSy;
        }
    }
}
