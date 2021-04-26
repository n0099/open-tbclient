package com.baidu.turbonet.net;
/* loaded from: classes5.dex */
public class QuicException extends TurbonetException {
    public final int mQuicDetailedErrorCode;

    public QuicException(String str, int i2, int i3) {
        super(str, 11, i2);
        this.mQuicDetailedErrorCode = i3;
    }

    public int getQuicDetailedErrorCode() {
        return this.mQuicDetailedErrorCode;
    }
}
