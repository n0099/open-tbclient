package com.baidu.tieba.personCenter;
/* loaded from: classes16.dex */
public class a {
    private static a leB = new a();
    private long creatTime = 0;
    private long eRX = 0;
    private long beginTime = 0;
    private long leC = 0;
    private long leD = 0;

    private a() {
    }

    public static a dgx() {
        return leB;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aVY() {
        return this.beginTime;
    }

    public void cq(long j) {
        this.beginTime = j;
    }

    public long dgy() {
        return this.eRX;
    }

    public void fI(long j) {
        this.eRX = j;
    }

    public long getRefreshTime() {
        return this.leC;
    }

    public void setRefreshTime(long j) {
        this.leC = j;
    }

    public long dgz() {
        return this.leD;
    }

    public void fJ(long j) {
        this.leD = j;
    }
}
