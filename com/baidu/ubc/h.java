package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String hSM;
    private String hSN;
    private int hSO;
    private String hSP;
    private int hSQ;
    private int hSR;
    private String hSS;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.hSM = str2;
        this.hSN = str3;
        this.hSO = i;
        this.mType = str4;
        this.hSP = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bPp() {
        return this.hSM;
    }

    public String bPq() {
        return this.hSN;
    }

    public int getTimeout() {
        return this.hSO;
    }

    public String getType() {
        return this.mType;
    }

    public String bPr() {
        return this.hSP;
    }

    public int bPs() {
        return this.mRate;
    }

    public void wM(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int bPt() {
        return this.hSQ;
    }

    public void wN(int i) {
        this.hSQ = i;
    }

    public int bPu() {
        return this.hSR;
    }

    public void wO(int i) {
        this.hSR = i;
    }

    public String getIdType() {
        return this.hSS;
    }

    public void xx(String str) {
        this.hSS = str;
    }
}
