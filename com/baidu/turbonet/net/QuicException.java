package com.baidu.turbonet.net;
/* loaded from: classes15.dex */
public class QuicException extends TurbonetException {
    private final int mQuicDetailedErrorCode;

    public QuicException(String str, int i, int i2) {
        super(str, 11, i);
        this.mQuicDetailedErrorCode = i2;
    }

    public int getQuicDetailedErrorCode() {
        return this.mQuicDetailedErrorCode;
    }
}
