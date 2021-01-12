package com.baidu.turbonet.net;
/* loaded from: classes4.dex */
public final class RequestTimeInfo {
    private final long oFw;
    private final long oFx;
    private final long oGR;
    private final long oGS;
    private final long oGT;

    public RequestTimeInfo() {
        this.oGR = 0L;
        this.oGS = 0L;
        this.oGT = 0L;
        this.oFw = 0L;
        this.oFx = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oGR = j;
        this.oGS = j2;
        this.oGT = j3;
        this.oFw = j4;
        this.oFx = j5;
    }
}
