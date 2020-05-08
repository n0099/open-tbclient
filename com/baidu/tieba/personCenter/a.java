package com.baidu.tieba.personCenter;
/* loaded from: classes9.dex */
public class a {
    private static a jSQ = new a();
    private long creatTime = 0;
    private long edT = 0;
    private long beginTime = 0;
    private long jSR = 0;
    private long jSS = 0;

    private a() {
    }

    public static a cGb() {
        return jSQ;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aDQ() {
        return this.beginTime;
    }

    public void bR(long j) {
        this.beginTime = j;
    }

    public long cGc() {
        return this.edT;
    }

    public void fe(long j) {
        this.edT = j;
    }

    public long getRefreshTime() {
        return this.jSR;
    }

    public void setRefreshTime(long j) {
        this.jSR = j;
    }

    public long cGd() {
        return this.jSS;
    }

    public void ff(long j) {
        this.jSS = j;
    }
}
