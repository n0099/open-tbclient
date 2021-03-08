package com.baidu.tieba.personCenter;
/* loaded from: classes2.dex */
public class a {
    private static a mvz = new a();
    private long creatTime = 0;
    private long fKU = 0;
    private long beginTime = 0;
    private long mvA = 0;
    private long mvB = 0;

    private a() {
    }

    public static a dwJ() {
        return mvz;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bfc() {
        return this.beginTime;
    }

    public void dC(long j) {
        this.beginTime = j;
    }

    public long dwK() {
        return this.fKU;
    }

    public void ht(long j) {
        this.fKU = j;
    }

    public long getRefreshTime() {
        return this.mvA;
    }

    public void setRefreshTime(long j) {
        this.mvA = j;
    }

    public long dwL() {
        return this.mvB;
    }

    public void hu(long j) {
        this.mvB = j;
    }
}
