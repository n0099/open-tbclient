package com.baidu.turbonet.net;
/* loaded from: classes17.dex */
public final class RequestTimeInfo {
    private final long omt;
    private final long omu;
    private final long oop;
    private final long ooq;
    private final long oor;

    public RequestTimeInfo() {
        this.oop = 0L;
        this.ooq = 0L;
        this.oor = 0L;
        this.omt = 0L;
        this.omu = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oop = j;
        this.ooq = j2;
        this.oor = j3;
        this.omt = j4;
        this.omu = j5;
    }
}
