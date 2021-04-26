package com.baidu.turbonet.base.library_loader;
/* loaded from: classes5.dex */
public class ProcessInitException extends Exception {
    public int mErrorCode;

    public ProcessInitException(int i2) {
        this.mErrorCode = 0;
        this.mErrorCode = i2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ProcessInitException(int i2, Throwable th) {
        super(null, th);
        this.mErrorCode = 0;
        this.mErrorCode = i2;
    }
}
