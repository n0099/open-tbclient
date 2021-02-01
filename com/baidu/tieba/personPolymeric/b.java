package com.baidu.tieba.personPolymeric;
/* loaded from: classes8.dex */
public class b {
    private static b myZ = new b();
    private long creatTime = 0;
    private long mza = 0;
    private long mzb = 0;
    private long fJu = 0;
    private long beginTime = 0;
    private long mzc = 0;
    private long mzd = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mza = 0L;
        this.mzb = 0L;
        this.fJu = 0L;
        this.beginTime = 0L;
        this.mzc = 0L;
        this.mzd = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mzd);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mzc);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fJu);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mzb);
        return stringBuffer.toString();
    }

    public static b dyd() {
        return myZ;
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

    public long dwu() {
        return this.fJu;
    }

    public void ht(long j) {
        this.fJu = j;
    }

    public long getRefreshTime() {
        return this.mzc;
    }

    public void setRefreshTime(long j) {
        this.mzc = j;
    }

    public long dwv() {
        return this.mzd;
    }

    public void hu(long j) {
        if (this.mzd == 0) {
            this.mzd = j;
        }
    }

    public long dye() {
        return this.mza;
    }

    public void hw(long j) {
        if (this.mza == 0) {
            this.mza = j;
        }
    }

    public long dyf() {
        return this.mzb;
    }

    public void hx(long j) {
        this.mzb = j;
    }
}
