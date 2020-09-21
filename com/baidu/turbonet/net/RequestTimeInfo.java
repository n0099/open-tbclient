package com.baidu.turbonet.net;
/* loaded from: classes15.dex */
public final class RequestTimeInfo {
    private final long nlr;
    private final long nls;
    private final long nnn;
    private final long nno;
    private final long nnp;

    public RequestTimeInfo() {
        this.nnn = 0L;
        this.nno = 0L;
        this.nnp = 0L;
        this.nlr = 0L;
        this.nls = 0L;
    }

    public RequestTimeInfo(long j, long j2, long j3, long j4, long j5) {
        this.nnn = j;
        this.nno = j2;
        this.nnp = j3;
        this.nlr = j4;
        this.nls = j5;
    }
}
