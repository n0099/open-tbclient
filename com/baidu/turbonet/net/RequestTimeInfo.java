package com.baidu.turbonet.net;
/* loaded from: classes6.dex */
public final class RequestTimeInfo {
    private final long oPG;
    private final long oPH;
    private final long oRa;
    private final long oRb;
    private final long oRc;

    public RequestTimeInfo() {
        this.oRa = 0L;
        this.oRb = 0L;
        this.oRc = 0L;
        this.oPG = 0L;
        this.oPH = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oRa = j;
        this.oRb = j2;
        this.oRc = j3;
        this.oPG = j4;
        this.oPH = j5;
    }
}
