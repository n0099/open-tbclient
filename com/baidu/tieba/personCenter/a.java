package com.baidu.tieba.personCenter;
/* loaded from: classes2.dex */
public class a {
    private static a moM = new a();
    private long creatTime = 0;
    private long fLQ = 0;
    private long beginTime = 0;
    private long moN = 0;
    private long moO = 0;

    private a() {
    }

    public static a dyb() {
        return moM;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long biG() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dyc() {
        return this.fLQ;
    }

    public void ho(long j) {
        this.fLQ = j;
    }

    public long getRefreshTime() {
        return this.moN;
    }

    public void setRefreshTime(long j) {
        this.moN = j;
    }

    public long dyd() {
        return this.moO;
    }

    public void hp(long j) {
        this.moO = j;
    }
}
