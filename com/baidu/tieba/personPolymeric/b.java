package com.baidu.tieba.personPolymeric;
/* loaded from: classes24.dex */
public class b {
    private static b lIx = new b();
    private long creatTime = 0;
    private long lIy = 0;
    private long lIz = 0;
    private long fgW = 0;
    private long beginTime = 0;
    private long lIA = 0;
    private long lIB = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.lIy = 0L;
        this.lIz = 0L;
        this.fgW = 0L;
        this.beginTime = 0L;
        this.lIA = 0L;
        this.lIB = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.lIB);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.lIA);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fgW);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.lIz);
        return stringBuffer.toString();
    }

    public static b dpu() {
        return lIx;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long aZs() {
        return this.beginTime;
    }

    public void cz(long j) {
        this.beginTime = j;
    }

    public long dnL() {
        return this.fgW;
    }

    public void go(long j) {
        this.fgW = j;
    }

    public long getRefreshTime() {
        return this.lIA;
    }

    public void setRefreshTime(long j) {
        this.lIA = j;
    }

    public long dnM() {
        return this.lIB;
    }

    public void gp(long j) {
        if (this.lIB == 0) {
            this.lIB = j;
        }
    }

    public long dpv() {
        return this.lIy;
    }

    public void gr(long j) {
        if (this.lIy == 0) {
            this.lIy = j;
        }
    }

    public long dpw() {
        return this.lIz;
    }

    public void gs(long j) {
        this.lIz = j;
    }
}
