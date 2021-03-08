package com.baidu.turbonet.net;
/* loaded from: classes5.dex */
public final class RequestTimeInfo {
    private final long oSl;
    private final long oSm;
    private final long oTF;
    private final long oTG;
    private final long oTH;

    public RequestTimeInfo() {
        this.oTF = 0L;
        this.oTG = 0L;
        this.oTH = 0L;
        this.oSl = 0L;
        this.oSm = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.oTF = j;
        this.oTG = j2;
        this.oTH = j3;
        this.oSl = j4;
        this.oSm = j5;
    }
}
