package com.baidu.turbonet.net;
/* loaded from: classes19.dex */
public final class RequestTimeInfo {
    private final long mIb;
    private final long mIc;
    private final long mKb;
    private final long mKc;
    private final long mKd;

    public RequestTimeInfo() {
        this.mKb = 0L;
        this.mKc = 0L;
        this.mKd = 0L;
        this.mIb = 0L;
        this.mIc = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.mKb = j;
        this.mKc = j2;
        this.mKd = j3;
        this.mIb = j4;
        this.mIc = j5;
    }
}
