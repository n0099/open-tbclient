package com.baidu.tieba.personPolymeric;
/* loaded from: classes24.dex */
public class b {
    private static b maS = new b();
    private long creatTime = 0;
    private long maT = 0;
    private long maU = 0;
    private long fvq = 0;
    private long beginTime = 0;
    private long maV = 0;
    private long maW = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.maT = 0L;
        this.maU = 0L;
        this.fvq = 0L;
        this.beginTime = 0L;
        this.maV = 0L;
        this.maW = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.maW);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.maV);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fvq);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.maU);
        return stringBuffer.toString();
    }

    public static b dvd() {
        return maS;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bdL() {
        return this.beginTime;
    }

    public void cX(long j) {
        this.beginTime = j;
    }

    public long dtu() {
        return this.fvq;
    }

    public void gL(long j) {
        this.fvq = j;
    }

    public long getRefreshTime() {
        return this.maV;
    }

    public void setRefreshTime(long j) {
        this.maV = j;
    }

    public long dtv() {
        return this.maW;
    }

    public void gM(long j) {
        if (this.maW == 0) {
            this.maW = j;
        }
    }

    public long dve() {
        return this.maT;
    }

    public void gO(long j) {
        if (this.maT == 0) {
            this.maT = j;
        }
    }

    public long dvf() {
        return this.maU;
    }

    public void gP(long j) {
        this.maU = j;
    }
}
