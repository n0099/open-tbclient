package com.baidu.tieba.personPolymeric;
/* loaded from: classes24.dex */
public class b {
    private static b lUT = new b();
    private long creatTime = 0;
    private long lUU = 0;
    private long lUV = 0;
    private long fpw = 0;
    private long beginTime = 0;
    private long lUW = 0;
    private long lUX = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.lUU = 0L;
        this.lUV = 0L;
        this.fpw = 0L;
        this.beginTime = 0L;
        this.lUW = 0L;
        this.lUX = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.lUX);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.lUW);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fpw);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.lUV);
        return stringBuffer.toString();
    }

    public static b dsB() {
        return lUT;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bbl() {
        return this.beginTime;
    }

    public void cB(long j) {
        this.beginTime = j;
    }

    public long dqS() {
        return this.fpw;
    }

    public void gp(long j) {
        this.fpw = j;
    }

    public long getRefreshTime() {
        return this.lUW;
    }

    public void setRefreshTime(long j) {
        this.lUW = j;
    }

    public long dqT() {
        return this.lUX;
    }

    public void gq(long j) {
        if (this.lUX == 0) {
            this.lUX = j;
        }
    }

    public long dsC() {
        return this.lUU;
    }

    public void gs(long j) {
        if (this.lUU == 0) {
            this.lUU = j;
        }
    }

    public long dsD() {
        return this.lUV;
    }

    public void gt(long j) {
        this.lUV = j;
    }
}
