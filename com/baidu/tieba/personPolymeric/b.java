package com.baidu.tieba.personPolymeric;
/* loaded from: classes18.dex */
public class b {
    private static b lkh = new b();
    private long creatTime = 0;
    private long eRT = 0;
    private long beginTime = 0;
    private long lev = 0;
    private long lew = 0;

    private b() {
    }

    public static b die() {
        return lkh;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aVY() {
        return this.beginTime;
    }

    public void cq(long j) {
        this.beginTime = j;
    }

    public long dgx() {
        return this.eRT;
    }

    public void fI(long j) {
        this.eRT = j;
    }

    public long getRefreshTime() {
        return this.lev;
    }

    public void setRefreshTime(long j) {
        this.lev = j;
    }

    public long dgy() {
        return this.lew;
    }

    public void fJ(long j) {
        if (this.lew == 0) {
            this.lew = j;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refrehStartTime:");
        stringBuffer.append(this.lew);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.lev);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.eRT);
        return stringBuffer.toString();
    }
}
