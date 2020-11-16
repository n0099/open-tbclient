package com.baidu.tieba.personCenter;
/* loaded from: classes21.dex */
public class a {
    private static a lVu = new a();
    private long creatTime = 0;
    private long fuA = 0;
    private long beginTime = 0;
    private long lVv = 0;
    private long lVw = 0;

    private a() {
    }

    public static a dsT() {
        return lVu;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bde() {
        return this.beginTime;
    }

    public void cX(long j) {
        this.beginTime = j;
    }

    public long dsU() {
        return this.fuA;
    }

    public void gO(long j) {
        this.fuA = j;
    }

    public long getRefreshTime() {
        return this.lVv;
    }

    public void setRefreshTime(long j) {
        this.lVv = j;
    }

    public long dsV() {
        return this.lVw;
    }

    public void gP(long j) {
        this.lVw = j;
    }
}
