package com.baidu.tieba.personCenter;
/* loaded from: classes22.dex */
public class a {
    private static a lVc = new a();
    private long creatTime = 0;
    private long fvq = 0;
    private long beginTime = 0;
    private long lVd = 0;
    private long lVe = 0;

    private a() {
    }

    public static a dtt() {
        return lVc;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bdL() {
        return this.beginTime;
    }

    public void cX(long j) {
        this.beginTime = j;
    }

    public long dtu() {
        return this.fvq;
    }

    public void gL(long j) {
        this.fvq = j;
    }

    public long getRefreshTime() {
        return this.lVd;
    }

    public void setRefreshTime(long j) {
        this.lVd = j;
    }

    public long dtv() {
        return this.lVe;
    }

    public void gM(long j) {
        this.lVe = j;
    }
}
