package com.baidu.tieba.personPolymeric;
/* loaded from: classes24.dex */
public class b {
    private static b mpq = new b();
    private long creatTime = 0;
    private long mpr = 0;
    private long mps = 0;
    private long fCl = 0;
    private long beginTime = 0;
    private long mpt = 0;
    private long mpu = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mpr = 0L;
        this.mps = 0L;
        this.fCl = 0L;
        this.beginTime = 0L;
        this.mpt = 0L;
        this.mpu = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mpu);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mpt);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fCl);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mps);
        return stringBuffer.toString();
    }

    public static b dzV() {
        return mpq;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bgj() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dym() {
        return this.fCl;
    }

    public void ht(long j) {
        this.fCl = j;
    }

    public long getRefreshTime() {
        return this.mpt;
    }

    public void setRefreshTime(long j) {
        this.mpt = j;
    }

    public long dyn() {
        return this.mpu;
    }

    public void hu(long j) {
        if (this.mpu == 0) {
            this.mpu = j;
        }
    }

    public long dzW() {
        return this.mpr;
    }

    public void hw(long j) {
        if (this.mpr == 0) {
            this.mpr = j;
        }
    }

    public long dzX() {
        return this.mps;
    }

    public void hx(long j) {
        this.mps = j;
    }
}
