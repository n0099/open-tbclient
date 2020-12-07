package com.baidu.turbonet.net;
/* loaded from: classes14.dex */
public final class RequestTimeInfo {
    private final long oCV;
    private final long oCW;
    private final long oEP;
    private final long oEQ;
    private final long oER;

    public RequestTimeInfo() {
        this.oEP = 0L;
        this.oEQ = 0L;
        this.oER = 0L;
        this.oCV = 0L;
        this.oCW = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oEP = j;
        this.oEQ = j2;
        this.oER = j3;
        this.oCV = j4;
        this.oCW = j5;
    }
}
