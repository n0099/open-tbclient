package com.baidu.turbonet.net;
/* loaded from: classes.dex */
public final class RequestTimeInfo {
    private final long mec;
    private final long med;
    private final long mfX;
    private final long mfY;
    private final long mfZ;

    public RequestTimeInfo() {
        this.mfX = 0L;
        this.mfY = 0L;
        this.mfZ = 0L;
        this.mec = 0L;
        this.med = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.mfX = j;
        this.mfY = j2;
        this.mfZ = j3;
        this.mec = j4;
        this.med = j5;
    }
}
