package com.baidu.tieba.personPolymeric;
/* loaded from: classes7.dex */
public class b {
    private static b mBr = new b();
    private long creatTime = 0;
    private long mBs = 0;
    private long mBt = 0;
    private long fKU = 0;
    private long beginTime = 0;
    private long mBu = 0;
    private long mBv = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mBs = 0L;
        this.mBt = 0L;
        this.fKU = 0L;
        this.beginTime = 0L;
        this.mBu = 0L;
        this.mBv = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mBv);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mBu);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fKU);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mBt);
        return stringBuffer.toString();
    }

    public static b dyt() {
        return mBr;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bfc() {
        return this.beginTime;
    }

    public void dC(long j) {
        this.beginTime = j;
    }

    public long dwK() {
        return this.fKU;
    }

    public void ht(long j) {
        this.fKU = j;
    }

    public long getRefreshTime() {
        return this.mBu;
    }

    public void setRefreshTime(long j) {
        this.mBu = j;
    }

    public long dwL() {
        return this.mBv;
    }

    public void hu(long j) {
        if (this.mBv == 0) {
            this.mBv = j;
        }
    }

    public long dyu() {
        return this.mBs;
    }

    public void hw(long j) {
        if (this.mBs == 0) {
            this.mBs = j;
        }
    }

    public long dyv() {
        return this.mBt;
    }

    public void hx(long j) {
        this.mBt = j;
    }
}
