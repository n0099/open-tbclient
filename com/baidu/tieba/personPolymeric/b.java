package com.baidu.tieba.personPolymeric;
/* loaded from: classes8.dex */
public class b {
    private static b muE = new b();
    private long creatTime = 0;
    private long muF = 0;
    private long muG = 0;
    private long fLQ = 0;
    private long beginTime = 0;
    private long muH = 0;
    private long muI = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.muF = 0L;
        this.muG = 0L;
        this.fLQ = 0L;
        this.beginTime = 0L;
        this.muH = 0L;
        this.muI = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.muI);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.muH);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fLQ);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.muG);
        return stringBuffer.toString();
    }

    public static b dzM() {
        return muE;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long biH() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dyd() {
        return this.fLQ;
    }

    public void ho(long j) {
        this.fLQ = j;
    }

    public long getRefreshTime() {
        return this.muH;
    }

    public void setRefreshTime(long j) {
        this.muH = j;
    }

    public long dye() {
        return this.muI;
    }

    public void hp(long j) {
        if (this.muI == 0) {
            this.muI = j;
        }
    }

    public long dzN() {
        return this.muF;
    }

    public void hr(long j) {
        if (this.muF == 0) {
            this.muF = j;
        }
    }

    public long dzO() {
        return this.muG;
    }

    public void hs(long j) {
        this.muG = j;
    }
}
