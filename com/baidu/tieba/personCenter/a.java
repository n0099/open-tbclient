package com.baidu.tieba.personCenter;
/* loaded from: classes9.dex */
public class a {
    private static a kFA = new a();
    private long creatTime = 0;
    private long eAY = 0;
    private long beginTime = 0;
    private long kFB = 0;
    private long kFC = 0;

    private a() {
    }

    public static a cRI() {
        return kFA;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aJG() {
        return this.beginTime;
    }

    public void bR(long j) {
        this.beginTime = j;
    }

    public long cRJ() {
        return this.eAY;
    }

    public void fi(long j) {
        this.eAY = j;
    }

    public long getRefreshTime() {
        return this.kFB;
    }

    public void setRefreshTime(long j) {
        this.kFB = j;
    }

    public long cRK() {
        return this.kFC;
    }

    public void fj(long j) {
        this.kFC = j;
    }
}
