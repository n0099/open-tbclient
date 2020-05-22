package com.baidu.turbonet.net;
/* loaded from: classes.dex */
public final class RequestTimeInfo {
    private final long mcS;
    private final long mcT;
    private final long meN;
    private final long meO;
    private final long meP;

    public RequestTimeInfo() {
        this.meN = 0L;
        this.meO = 0L;
        this.meP = 0L;
        this.mcS = 0L;
        this.mcT = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.meN = j;
        this.meO = j2;
        this.meP = j3;
        this.mcS = j4;
        this.mcT = j5;
    }
}
