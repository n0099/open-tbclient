package com.baidu.tieba.personCenter;
/* loaded from: classes9.dex */
public class a {
    private static a jSM = new a();
    private long creatTime = 0;
    private long edO = 0;
    private long beginTime = 0;
    private long jSN = 0;
    private long jSO = 0;

    private a() {
    }

    public static a cGe() {
        return jSM;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aDQ() {
        return this.beginTime;
    }

    public void bR(long j) {
        this.beginTime = j;
    }

    public long cGf() {
        return this.edO;
    }

    public void fe(long j) {
        this.edO = j;
    }

    public long getRefreshTime() {
        return this.jSN;
    }

    public void setRefreshTime(long j) {
        this.jSN = j;
    }

    public long cGg() {
        return this.jSO;
    }

    public void ff(long j) {
        this.jSO = j;
    }
}
