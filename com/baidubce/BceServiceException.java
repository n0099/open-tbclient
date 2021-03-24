package com.baidubce;

import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes5.dex */
public class BceServiceException extends BceClientException {
    public static final long serialVersionUID = 1483785729559154396L;
    public String errorCode;
    public String errorMessage;
    public ErrorType errorType;
    public String requestId;
    public int statusCode;

    /* loaded from: classes5.dex */
    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public BceServiceException(String str) {
        super(null);
        this.errorType = ErrorType.Unknown;
        this.errorMessage = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return getErrorMessage() + " (Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + SmallTailInfo.EMOTION_SUFFIX;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public BceServiceException(String str, Exception exc) {
        super(null, exc);
        this.errorType = ErrorType.Unknown;
        this.errorMessage = str;
    }
}
