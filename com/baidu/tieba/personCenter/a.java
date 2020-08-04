package com.baidu.tieba.personCenter;
/* loaded from: classes16.dex */
public class a {
    private static a kOE = new a();
    private long creatTime = 0;
    private long eHn = 0;
    private long beginTime = 0;
    private long kOF = 0;
    private long kOG = 0;

    private a() {
    }

    public static a cVz() {
        return kOE;
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
        return this.kOF;
    }

    public void setRefreshTime(long j) {
        this.kOF = j;
    }

    public long cVB() {
        return this.kOG;
    }

    public void fx(long j) {
        this.kOG = j;
    }
}
