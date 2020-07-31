package com.baidu.tieba.personCenter;
/* loaded from: classes16.dex */
public class a {
    private static a kOC = new a();
    private long creatTime = 0;
    private long eHn = 0;
    private long beginTime = 0;
    private long kOD = 0;
    private long kOE = 0;

    private a() {
    }

    public static a cVz() {
        return kOC;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aNy() {
        return this.beginTime;
    }

    public void cg(long j) {
        this.beginTime = j;
    }

    public long cVA() {
        return this.eHn;
    }

    public void fw(long j) {
        this.eHn = j;
    }

    public long getRefreshTime() {
        return this.kOD;
    }

    public void setRefreshTime(long j) {
        this.kOD = j;
    }

    public long cVB() {
        return this.kOE;
    }

    public void fx(long j) {
        this.kOE = j;
    }
}
