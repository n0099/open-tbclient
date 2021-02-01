package com.baidu.tieba.personCenter;
/* loaded from: classes2.dex */
public class a {
    private static a mti = new a();
    private long creatTime = 0;
    private long fJu = 0;
    private long beginTime = 0;
    private long mtj = 0;
    private long mtk = 0;

    private a() {
    }

    public static a dwt() {
        return mti;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bfa() {
        return this.beginTime;
    }

    public void dC(long j) {
        this.beginTime = j;
    }

    public long dwu() {
        return this.fJu;
    }

    public void ht(long j) {
        this.fJu = j;
    }

    public long getRefreshTime() {
        return this.mtj;
    }

    public void setRefreshTime(long j) {
        this.mtj = j;
    }

    public long dwv() {
        return this.mtk;
    }

    public void hu(long j) {
        this.mtk = j;
    }
}
