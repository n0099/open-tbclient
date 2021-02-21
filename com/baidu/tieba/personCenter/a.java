package com.baidu.tieba.personCenter;
/* loaded from: classes2.dex */
public class a {
    private static a mtx = new a();
    private long creatTime = 0;
    private long fJu = 0;
    private long beginTime = 0;
    private long mty = 0;
    private long mtz = 0;

    private a() {
    }

    public static a dwA() {
        return mtx;
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

    public long dwB() {
        return this.fJu;
    }

    public void ht(long j) {
        this.fJu = j;
    }

    public long getRefreshTime() {
        return this.mty;
    }

    public void setRefreshTime(long j) {
        this.mty = j;
    }

    public long dwC() {
        return this.mtz;
    }

    public void hu(long j) {
        this.mtz = j;
    }
}
