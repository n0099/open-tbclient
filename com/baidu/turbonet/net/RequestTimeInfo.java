package com.baidu.turbonet.net;
/* loaded from: classes.dex */
public final class RequestTimeInfo {
    private final long mBR;
    private final long mBS;
    private final long mBT;
    private final long mzU;
    private final long mzV;

    public RequestTimeInfo() {
        this.mBR = 0L;
        this.mBS = 0L;
        this.mBT = 0L;
        this.mzU = 0L;
        this.mzV = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.mBR = j;
        this.mBS = j2;
        this.mBT = j3;
        this.mzU = j4;
        this.mzV = j5;
    }
}
