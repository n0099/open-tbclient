package com.baidu.turbonet.net;
/* loaded from: classes12.dex */
public final class RequestTimeInfo {
    private final long onX;
    private final long onY;
    private final long opT;
    private final long opU;
    private final long opV;

    public RequestTimeInfo() {
        this.opT = 0L;
        this.opU = 0L;
        this.opV = 0L;
        this.onX = 0L;
        this.onY = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.opT = j;
        this.opU = j2;
        this.opV = j3;
        this.onX = j4;
        this.onY = j5;
    }
}
