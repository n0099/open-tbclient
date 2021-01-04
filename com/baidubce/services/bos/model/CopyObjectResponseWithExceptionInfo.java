package com.baidubce.services.bos.model;
/* loaded from: classes6.dex */
public class CopyObjectResponseWithExceptionInfo extends CopyObjectResponse {
    private String code;
    private String message;
    private String requestId;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
