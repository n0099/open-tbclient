package com.baidu.tieba.personCenter;
/* loaded from: classes21.dex */
public class a {
    private static a lns = new a();
    private long creatTime = 0;
    private long eUN = 0;
    private long beginTime = 0;
    private long lnt = 0;
    private long lnu = 0;

    private a() {
    }

    public static a dka() {
        return lns;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aWK() {
        return this.beginTime;
    }

    public void cr(long j) {
        this.beginTime = j;
    }

    public long dkb() {
        return this.eUN;
    }

    public void fW(long j) {
        this.eUN = j;
    }

    public long getRefreshTime() {
        return this.lnt;
    }

    public void setRefreshTime(long j) {
        this.lnt = j;
    }

    public long dkc() {
        return this.lnu;
    }

    public void fX(long j) {
        this.lnu = j;
    }
}
