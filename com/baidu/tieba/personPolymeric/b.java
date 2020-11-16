package com.baidu.tieba.personPolymeric;
/* loaded from: classes23.dex */
public class b {
    private static b mbk = new b();
    private long creatTime = 0;
    private long mbl = 0;
    private long mbm = 0;
    private long fuA = 0;
    private long beginTime = 0;
    private long mbn = 0;
    private long mbo = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mbl = 0L;
        this.mbm = 0L;
        this.fuA = 0L;
        this.beginTime = 0L;
        this.mbn = 0L;
        this.mbo = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mbo);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mbn);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fuA);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mbm);
        return stringBuffer.toString();
    }

    public static b duD() {
        return mbk;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long bde() {
        return this.beginTime;
    }

    public void cX(long j) {
        this.beginTime = j;
    }

    public long dsU() {
        return this.fuA;
    }

    public void gO(long j) {
        this.fuA = j;
    }

    public long getRefreshTime() {
        return this.mbn;
    }

    public void setRefreshTime(long j) {
        this.mbn = j;
    }

    public long dsV() {
        return this.mbo;
    }

    public void gP(long j) {
        if (this.mbo == 0) {
            this.mbo = j;
        }
    }

    public long duE() {
        return this.mbl;
    }

    public void gR(long j) {
        if (this.mbl == 0) {
            this.mbl = j;
        }
    }

    public long duF() {
        return this.mbm;
    }

    public void gS(long j) {
        this.mbm = j;
    }
}
