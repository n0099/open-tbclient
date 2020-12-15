package com.baidu.tieba.personCenter;
/* loaded from: classes22.dex */
public class a {
    private static a mjD = new a();
    private long creatTime = 0;
    private long fCl = 0;
    private long beginTime = 0;
    private long mjE = 0;
    private long mjF = 0;

    private a() {
    }

    public static a dym() {
        return mjD;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bgj() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dyn() {
        return this.fCl;
    }

    public void ht(long j) {
        this.fCl = j;
    }

    public long getRefreshTime() {
        return this.mjE;
    }

    public void setRefreshTime(long j) {
        this.mjE = j;
    }

    public long dyo() {
        return this.mjF;
    }

    public void hu(long j) {
        this.mjF = j;
    }
}
