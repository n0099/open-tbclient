package com.baidu.turbonet.net;
/* loaded from: classes19.dex */
public final class RequestTimeInfo {
    private final long mHZ;
    private final long mIa;
    private final long mJZ;
    private final long mKa;
    private final long mKb;

    public RequestTimeInfo() {
        this.mJZ = 0L;
        this.mKa = 0L;
        this.mKb = 0L;
        this.mHZ = 0L;
        this.mIa = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.mJZ = j;
        this.mKa = j2;
        this.mKb = j3;
        this.mHZ = j4;
        this.mIa = j5;
    }
}
