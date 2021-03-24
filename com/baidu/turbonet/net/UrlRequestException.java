package com.baidu.turbonet.net;

import java.io.IOException;
/* loaded from: classes5.dex */
public class UrlRequestException extends IOException {
    public static final int ERROR_ADDRESS_UNREACHABLE = 9;
    public static final int ERROR_CONNECTION_CLOSED = 5;
    public static final int ERROR_CONNECTION_REFUSED = 7;
    public static final int ERROR_CONNECTION_RESET = 8;
    public static final int ERROR_CONNECTION_TIMED_OUT = 6;
    public static final int ERROR_HOSTNAME_NOT_RESOLVED = 1;
    public static final int ERROR_INTERNET_DISCONNECTED = 2;
    public static final int ERROR_LISTENER_EXCEPTION_THROWN = 0;
    public static final int ERROR_NETWORK_CHANGED = 3;
    public static final int ERROR_OTHER = 12;
    public static final int ERROR_QUIC_PROTOCOL_FAILED = 11;
    public static final int ERROR_TIMED_OUT = 4;
    public static final int ERROR_ZERORTT_HANDSHAKE_ERROR = 10;
    public final int mCronetInternalErrorCode;
    public final int mErrorCode;

    public UrlRequestException(String str, int i, int i2) {
        super(str, null);
        this.mErrorCode = i;
        this.mCronetInternalErrorCode = i2;
    }

    public int getCronetInternalErrorCode() {
        return this.mCronetInternalErrorCode;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public boolean immediatelyRetryable() {
        int i = this.mErrorCode;
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 8 || i == 10;
    }

    public UrlRequestException(String str, Throwable th) {
        super(str, th);
        this.mErrorCode = 0;
        this.mCronetInternalErrorCode = 0;
    }
}
