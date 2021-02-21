package com.baidu.tieba.personPolymeric;
/* loaded from: classes8.dex */
public class b {
    private static b mzo = new b();
    private long creatTime = 0;
    private long mzp = 0;
    private long mzq = 0;
    private long fJu = 0;
    private long beginTime = 0;
    private long mzr = 0;
    private long mzs = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mzp = 0L;
        this.mzq = 0L;
        this.fJu = 0L;
        this.beginTime = 0L;
        this.mzr = 0L;
        this.mzs = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mzs);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mzr);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fJu);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mzq);
        return stringBuffer.toString();
    }

    public static b dyk() {
        return mzo;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bfa() {
        return this.beginTime;
    }

    public void dC(long j) {
        this.beginTime = j;
    }

    public long dwB() {
        return this.fJu;
    }

    public void ht(long j) {
        this.fJu = j;
    }

    public long getRefreshTime() {
        return this.mzr;
    }

    public void setRefreshTime(long j) {
        this.mzr = j;
    }

    public long dwC() {
        return this.mzs;
    }

    public void hu(long j) {
        if (this.mzs == 0) {
            this.mzs = j;
        }
    }

    public long dyl() {
        return this.mzp;
    }

    public void hw(long j) {
        if (this.mzp == 0) {
            this.mzp = j;
        }
    }

    public long dym() {
        return this.mzq;
    }

    public void hx(long j) {
        this.mzq = j;
    }
}
