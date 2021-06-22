package com.baidubce;
/* loaded from: classes6.dex */
public enum ErrorCode {
    ACCESS_DENIED("AccessDenied"),
    INAPPROPRIATE_JSON("InappropriateJSON"),
    INTERNAL_ERROR("InternalError"),
    INVALID_ACCESS_KEY_ID("InvalidAccessKeyId"),
    INVALID_HTTP_AUTH_HEADER("InvalidHTTPAuthHeader"),
    INVALID_HTTP_REQUEST("InvalidHTTPRequest"),
    INVALID_URI("InvalidURI"),
    MALFORMED_JSON("MalformedJSON"),
    INVALID_VERSION("InvalidVersion"),
    OPT_IN_REQUIRED("OptInRequired"),
    PRECONDITION_FAILED("PreconditionFailed"),
    REQUEST_EXPIRED("RequestExpired"),
    REQUEST_TIME_TOO_SKEWED("RequestTimeTooSkewed"),
    SIGNATURE_DOES_NOT_MATCH("SignatureDoesNotMatch");
    
    public String code;

    ErrorCode(String str) {
        this.code = str;
    }

    public boolean equals(String str) {
        return this.code.equals(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.code;
    }
}
