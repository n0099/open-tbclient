package com.baidu.tieba.personPolymeric;
/* loaded from: classes8.dex */
public class b {
    private static b muF = new b();
    private long creatTime = 0;
    private long muG = 0;
    private long muH = 0;
    private long fLQ = 0;
    private long beginTime = 0;
    private long muI = 0;
    private long muJ = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.muG = 0L;
        this.muH = 0L;
        this.fLQ = 0L;
        this.beginTime = 0L;
        this.muI = 0L;
        this.muJ = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.muJ);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.muI);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fLQ);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.muH);
        return stringBuffer.toString();
    }

    public static b dzL() {
        return muF;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long biG() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dyc() {
        return this.fLQ;
    }

    public void ho(long j) {
        this.fLQ = j;
    }

    public long getRefreshTime() {
        return this.muI;
    }

    public void setRefreshTime(long j) {
        this.muI = j;
    }

    public long dyd() {
        return this.muJ;
    }

    public void hp(long j) {
        if (this.muJ == 0) {
            this.muJ = j;
        }
    }

    public long dzM() {
        return this.muG;
    }

    public void hr(long j) {
        if (this.muG == 0) {
            this.muG = j;
        }
    }

    public long dzN() {
        return this.muH;
    }

    public void hs(long j) {
        this.muH = j;
    }
}
