package com.baidu.tieba.personCenter;
/* loaded from: classes22.dex */
public class a {
    private static a lPg = new a();
    private long creatTime = 0;
    private long fpw = 0;
    private long beginTime = 0;
    private long lPh = 0;
    private long lPi = 0;

    private a() {
    }

    public static a dqR() {
        return lPg;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bbl() {
        return this.beginTime;
    }

    public void cB(long j) {
        this.beginTime = j;
    }

    public long dqS() {
        return this.fpw;
    }

    public void gp(long j) {
        this.fpw = j;
    }

    public long getRefreshTime() {
        return this.lPh;
    }

    public void setRefreshTime(long j) {
        this.lPh = j;
    }

    public long dqT() {
        return this.lPi;
    }

    public void gq(long j) {
        this.lPi = j;
    }
}
