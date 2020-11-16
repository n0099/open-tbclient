package com.baidu.turbonet.base.library_loader;
/* loaded from: classes12.dex */
public class ProcessInitException extends Exception {
    private int mErrorCode;

    public ProcessInitException(int i) {
        this.mErrorCode = 0;
        this.mErrorCode = i;
    }

    public ProcessInitException(int i, Throwable th) {
        super(null, th);
        this.mErrorCode = 0;
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
