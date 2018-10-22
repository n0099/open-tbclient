package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String hSN;
    private String hSO;
    private int hSP;
    private String hSQ;
    private int hSR;
    private int hSS;
    private String hST;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.hSN = str2;
        this.hSO = str3;
        this.hSP = i;
        this.mType = str4;
        this.hSQ = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bPp() {
        return this.hSN;
    }

    public String bPq() {
        return this.hSO;
    }

    public int getTimeout() {
        return this.hSP;
    }

    public String getType() {
        return this.mType;
    }

    public String bPr() {
        return this.hSQ;
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
        return this.hSR;
    }

    public void wN(int i) {
        this.hSR = i;
    }

    public int bPu() {
        return this.hSS;
    }

    public void wO(int i) {
        this.hSS = i;
    }

    public String getIdType() {
        return this.hST;
    }

    public void xx(String str) {
        this.hST = str;
    }
}
