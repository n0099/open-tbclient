package com.baidubce.services.bos.model;
/* loaded from: classes6.dex */
public class CopyObjectResponseWithExceptionInfo extends CopyObjectResponse {
    public String code;
    public String message;
    public String requestId;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
