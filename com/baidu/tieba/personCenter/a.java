package com.baidu.tieba.personCenter;
/* loaded from: classes9.dex */
public class a {
    private static a kkI = new a();
    private long creatTime = 0;
    private long esg = 0;
    private long beginTime = 0;
    private long kkJ = 0;
    private long kkK = 0;

    private a() {
    }

    public static a cNb() {
        return kkI;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aIA() {
        return this.beginTime;
    }

    public void bR(long j) {
        this.beginTime = j;
    }

    public long cNc() {
        return this.esg;
    }

    public void ff(long j) {
        this.esg = j;
    }

    public long getRefreshTime() {
        return this.kkJ;
    }

    public void setRefreshTime(long j) {
        this.kkJ = j;
    }

    public long cNd() {
        return this.kkK;
    }

    public void fg(long j) {
        this.kkK = j;
    }
}
