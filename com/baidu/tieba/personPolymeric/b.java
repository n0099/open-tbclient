package com.baidu.tieba.personPolymeric;
/* loaded from: classes24.dex */
public class b {
    private static b mps = new b();
    private long creatTime = 0;
    private long mpt = 0;
    private long mpu = 0;
    private long fCl = 0;
    private long beginTime = 0;
    private long mpv = 0;
    private long mpw = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mpt = 0L;
        this.mpu = 0L;
        this.fCl = 0L;
        this.beginTime = 0L;
        this.mpv = 0L;
        this.mpw = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mpw);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mpv);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fCl);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mpu);
        return stringBuffer.toString();
    }

    public static b dzW() {
        return mps;
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

    public long dyn() {
        return this.fCl;
    }

    public void ht(long j) {
        this.fCl = j;
    }

    public long getRefreshTime() {
        return this.mpv;
    }

    public void setRefreshTime(long j) {
        this.mpv = j;
    }

    public long dyo() {
        return this.mpw;
    }

    public void hu(long j) {
        if (this.mpw == 0) {
            this.mpw = j;
        }
    }

    public long dzX() {
        return this.mpt;
    }

    public void hw(long j) {
        if (this.mpt == 0) {
            this.mpt = j;
        }
    }

    public long dzY() {
        return this.mpu;
    }

    public void hx(long j) {
        this.mpu = j;
    }
}
