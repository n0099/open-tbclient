package com.baidu.tieba.personPolymeric;
/* loaded from: classes23.dex */
public class b {
    private static b ltk = new b();
    private long creatTime = 0;
    private long ltl = 0;
    private long ltm = 0;
    private long eUN = 0;
    private long beginTime = 0;
    private long ltn = 0;
    private long lto = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.ltl = 0L;
        this.ltm = 0L;
        this.eUN = 0L;
        this.beginTime = 0L;
        this.ltn = 0L;
        this.lto = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.lto);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.ltn);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.eUN);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.ltm);
        return stringBuffer.toString();
    }

    public static b dlK() {
        return ltk;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aWK() {
        return this.beginTime;
    }

    public void cr(long j) {
        this.beginTime = j;
    }

    public long dkb() {
        return this.eUN;
    }

    public void fW(long j) {
        this.eUN = j;
    }

    public long getRefreshTime() {
        return this.ltn;
    }

    public void setRefreshTime(long j) {
        this.ltn = j;
    }

    public long dkc() {
        return this.lto;
    }

    public void fX(long j) {
        if (this.lto == 0) {
            this.lto = j;
        }
    }

    public long dlL() {
        return this.ltl;
    }

    public void fZ(long j) {
        if (this.ltl == 0) {
            this.ltl = j;
        }
    }

    public long dlM() {
        return this.ltm;
    }

    public void ga(long j) {
        this.ltm = j;
    }
}
