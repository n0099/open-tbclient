package com.baidu.tieba.personCenter;
/* loaded from: classes2.dex */
public class a {
    private static a mkg = new a();
    private long creatTime = 0;
    private long fHj = 0;
    private long beginTime = 0;
    private long mkh = 0;
    private long mki = 0;

    private a() {
    }

    public static a duk() {
        return mkg;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long beN() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dul() {
        return this.fHj;
    }

    public void ho(long j) {
        this.fHj = j;
    }

    public long getRefreshTime() {
        return this.mkh;
    }

    public void setRefreshTime(long j) {
        this.mkh = j;
    }

    public long dum() {
        return this.mki;
    }

    public void hp(long j) {
        this.mki = j;
    }
}
