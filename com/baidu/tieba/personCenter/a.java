package com.baidu.tieba.personCenter;
/* loaded from: classes22.dex */
public class a {
    private static a mjB = new a();
    private long creatTime = 0;
    private long fCl = 0;
    private long beginTime = 0;
    private long mjC = 0;
    private long mjD = 0;

    private a() {
    }

    public static a dyl() {
        return mjB;
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

    public long dym() {
        return this.fCl;
    }

    public void ht(long j) {
        this.fCl = j;
    }

    public long getRefreshTime() {
        return this.mjC;
    }

    public void setRefreshTime(long j) {
        this.mjC = j;
    }

    public long dyn() {
        return this.mjD;
    }

    public void hu(long j) {
        this.mjD = j;
    }
}
