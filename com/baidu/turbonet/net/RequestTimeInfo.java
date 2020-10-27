package com.baidu.turbonet.net;
/* loaded from: classes17.dex */
public final class RequestTimeInfo {
    private final long odp;
    private final long odq;
    private final long ofl;
    private final long ofm;
    private final long ofn;

    public RequestTimeInfo() {
        this.ofl = 0L;
        this.ofm = 0L;
        this.ofn = 0L;
        this.odp = 0L;
        this.odq = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.ofl = j;
        this.ofm = j2;
        this.ofn = j3;
        this.odp = j4;
        this.odq = j5;
    }
}
