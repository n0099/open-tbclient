package com.baidu.turbonet.net;
/* loaded from: classes4.dex */
public final class RequestTimeInfo {
    private final long oFx;
    private final long oFy;
    private final long oGS;
    private final long oGT;
    private final long oGU;

    public RequestTimeInfo() {
        this.oGS = 0L;
        this.oGT = 0L;
        this.oGU = 0L;
        this.oFx = 0L;
        this.oFy = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oGS = j;
        this.oGT = j2;
        this.oGU = j3;
        this.oFx = j4;
        this.oFy = j5;
    }
}
