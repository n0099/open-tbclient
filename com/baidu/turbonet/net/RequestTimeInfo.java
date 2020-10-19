package com.baidu.turbonet.net;
/* loaded from: classes17.dex */
public final class RequestTimeInfo {
    private final long nAO;
    private final long nAP;
    private final long nCJ;
    private final long nCK;
    private final long nCL;

    public RequestTimeInfo() {
        this.nCJ = 0L;
        this.nCK = 0L;
        this.nCL = 0L;
        this.nAO = 0L;
        this.nAP = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.nCJ = j;
        this.nCK = j2;
        this.nCL = j3;
        this.nAO = j4;
        this.nAP = j5;
    }
}
