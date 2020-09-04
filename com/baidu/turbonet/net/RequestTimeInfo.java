package com.baidu.turbonet.net;
/* loaded from: classes10.dex */
public final class RequestTimeInfo {
    private final long nbs;
    private final long nbt;
    private final long ndo;
    private final long ndp;
    private final long ndq;

    public RequestTimeInfo() {
        this.ndo = 0L;
        this.ndp = 0L;
        this.ndq = 0L;
        this.nbs = 0L;
        this.nbt = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.ndo = j;
        this.ndp = j2;
        this.ndq = j3;
        this.nbs = j4;
        this.nbt = j5;
    }
}
