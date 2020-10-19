package com.baidu.tieba.personCenter;
/* loaded from: classes22.dex */
public class a {
    private static a lCJ = new a();
    private long creatTime = 0;
    private long fgW = 0;
    private long beginTime = 0;
    private long lCK = 0;
    private long lCL = 0;

    private a() {
    }

    public static a dnK() {
        return lCJ;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aZs() {
        return this.beginTime;
    }

    public void cz(long j) {
        this.beginTime = j;
    }

    public long dnL() {
        return this.fgW;
    }

    public void go(long j) {
        this.fgW = j;
    }

    public long getRefreshTime() {
        return this.lCK;
    }

    public void setRefreshTime(long j) {
        this.lCK = j;
    }

    public long dnM() {
        return this.lCL;
    }

    public void gp(long j) {
        this.lCL = j;
    }
}
