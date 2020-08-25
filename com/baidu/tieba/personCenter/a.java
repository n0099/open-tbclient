package com.baidu.tieba.personCenter;
/* loaded from: classes16.dex */
public class a {
    private static a leu = new a();
    private long creatTime = 0;
    private long eRT = 0;
    private long beginTime = 0;
    private long lev = 0;
    private long lew = 0;

    private a() {
    }

    public static a dgw() {
        return leu;
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

    public long dgx() {
        return this.eRT;
    }

    public void fI(long j) {
        this.eRT = j;
    }

    public long getRefreshTime() {
        return this.lev;
    }

    public void setRefreshTime(long j) {
        this.lev = j;
    }

    public long dgy() {
        return this.lew;
    }

    public void fJ(long j) {
        this.lew = j;
    }
}
