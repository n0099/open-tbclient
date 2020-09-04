package com.baidu.tieba.personPolymeric;
/* loaded from: classes18.dex */
public class b {
    private static b lko = new b();
    private long creatTime = 0;
    private long lkp = 0;
    private long lkq = 0;
    private long eRX = 0;
    private long beginTime = 0;
    private long lkr = 0;
    private long lks = 0;

    private b() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.lks);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.lkr);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.eRX);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.lkq);
        return stringBuffer.toString();
    }

    public static b dif() {
        return lko;
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

    public long dgy() {
        return this.eRX;
    }

    public void fI(long j) {
        this.eRX = j;
    }

    public long getRefreshTime() {
        return this.lkr;
    }

    public void setRefreshTime(long j) {
        this.lkr = j;
    }

    public long dgz() {
        return this.lks;
    }

    public void fJ(long j) {
        if (this.lks == 0) {
            this.lks = j;
        }
    }

    public long dig() {
        return this.lkp;
    }

    public void fL(long j) {
        if (this.lkp == 0) {
            this.lkp = j;
        }
    }

    public long dih() {
        return this.lkq;
    }

    public void fM(long j) {
        this.lkq = j;
    }
}
