package com.baidu.tieba.personCenter;
/* loaded from: classes9.dex */
public class a {
    private static a klO = new a();
    private long creatTime = 0;
    private long esg = 0;
    private long beginTime = 0;
    private long klP = 0;
    private long klQ = 0;

    private a() {
    }

    public static a cNr() {
        return klO;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aIA() {
        return this.beginTime;
    }

    public void bR(long j) {
        this.beginTime = j;
    }

    public long cNs() {
        return this.esg;
    }

    public void ff(long j) {
        this.esg = j;
    }

    public long getRefreshTime() {
        return this.klP;
    }

    public void setRefreshTime(long j) {
        this.klP = j;
    }

    public long cNt() {
        return this.klQ;
    }

    public void fg(long j) {
        this.klQ = j;
    }
}
