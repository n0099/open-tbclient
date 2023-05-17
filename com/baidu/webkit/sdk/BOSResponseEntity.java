package com.baidu.webkit.sdk;
/* loaded from: classes8.dex */
public class BOSResponseEntity {
    public int mErrorCode;
    public String mResponseMessage;
    public boolean mSuccess;

    public BOSResponseEntity() {
        this.mSuccess = true;
        this.mResponseMessage = null;
    }

    public BOSResponseEntity(boolean z) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
    }

    public BOSResponseEntity(boolean z, String str) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
        this.mResponseMessage = str;
    }

    public BOSResponseEntity(boolean z, String str, int i) {
        this.mSuccess = true;
        this.mResponseMessage = null;
        this.mSuccess = z;
        this.mResponseMessage = str;
        this.mErrorCode = i;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getMessage() {
        return this.mResponseMessage;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }
}
