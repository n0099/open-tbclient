package com.baidu.turbonet.net;
/* loaded from: classes5.dex */
public final class RequestTimeInfo {
    private final long oKb;
    private final long oKc;
    private final long oLw;
    private final long oLx;
    private final long oLy;

    public RequestTimeInfo() {
        this.oLw = 0L;
        this.oLx = 0L;
        this.oLy = 0L;
        this.oKb = 0L;
        this.oKc = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oLw = j;
        this.oLx = j2;
        this.oLy = j3;
        this.oKb = j4;
        this.oKc = j5;
    }
}
