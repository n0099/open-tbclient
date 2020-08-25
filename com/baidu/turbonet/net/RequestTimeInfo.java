package com.baidu.turbonet.net;
/* loaded from: classes10.dex */
public final class RequestTimeInfo {
    private final long nba;
    private final long nbb;
    private final long ncW;
    private final long ncX;
    private final long ncY;

    public RequestTimeInfo() {
        this.ncW = 0L;
        this.ncX = 0L;
        this.ncY = 0L;
        this.nba = 0L;
        this.nbb = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.ncW = j;
        this.ncX = j2;
        this.ncY = j3;
        this.nba = j4;
        this.nbb = j5;
    }
}
