package com.baidu.tieba.personPolymeric;
/* loaded from: classes7.dex */
public class b {
    private static b mpZ = new b();
    private long creatTime = 0;
    private long mqa = 0;
    private long mqb = 0;
    private long fHj = 0;
    private long beginTime = 0;
    private long mqc = 0;
    private long mqd = 0;

    private b() {
    }

    public void reset() {
        this.creatTime = 0L;
        this.mqa = 0L;
        this.mqb = 0L;
        this.fHj = 0L;
        this.beginTime = 0L;
        this.mqc = 0L;
        this.mqd = 0L;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" beginTime:");
        stringBuffer.append(this.beginTime);
        stringBuffer.append(" creatTime:");
        stringBuffer.append(this.creatTime);
        stringBuffer.append(" refreshStartTime:");
        stringBuffer.append(this.mqd);
        stringBuffer.append(" refrehTime:");
        stringBuffer.append(this.mqc);
        stringBuffer.append(" drawTime:");
        stringBuffer.append(this.fHj);
        stringBuffer.append(" profileTime:");
        stringBuffer.append(this.mqb);
        return stringBuffer.toString();
    }

    public static b dvU() {
        return mpZ;
    }

    public long getCreateTime() {
        return this.creatTime;
    }

    public void setCreateTime(long j) {
        this.creatTime = j;
    }

    public long beN() {
        return this.beginTime;
    }

    public void dw(long j) {
        this.beginTime = j;
    }

    public long dul() {
        return this.fHj;
    }

    public void ho(long j) {
        this.fHj = j;
    }

    public long getRefreshTime() {
        return this.mqc;
    }

    public void setRefreshTime(long j) {
        this.mqc = j;
    }

    public long dum() {
        return this.mqd;
    }

    public void hp(long j) {
        if (this.mqd == 0) {
            this.mqd = j;
        }
    }

    public long dvV() {
        return this.mqa;
    }

    public void hr(long j) {
        if (this.mqa == 0) {
            this.mqa = j;
        }
    }

    public long dvW() {
        return this.mqb;
    }

    public void hs(long j) {
        this.mqb = j;
    }
}
