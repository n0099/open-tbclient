package com.baidu.turbonet.net;
/* loaded from: classes14.dex */
public final class RequestTimeInfo {
    private final long oCX;
    private final long oCY;
    private final long oER;
    private final long oES;
    private final long oET;

    public RequestTimeInfo() {
        this.oER = 0L;
        this.oES = 0L;
        this.oET = 0L;
        this.oCX = 0L;
        this.oCY = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oER = j;
        this.oES = j2;
        this.oET = j3;
        this.oCX = j4;
        this.oCY = j5;
    }
}
