package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bPp;
    private String bPq;
    private int bPr;
    private String bPs;
    private int bPt;
    private int bPu;
    private String bPv;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.bPp = str2;
        this.bPq = str3;
        this.bPr = i;
        this.mType = str4;
        this.bPs = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String acz() {
        return this.bPp;
    }

    public String acA() {
        return this.bPq;
    }

    public int getTimeout() {
        return this.bPr;
    }

    public String getType() {
        return this.mType;
    }

    public String acB() {
        return this.bPs;
    }

    public int acC() {
        return this.mRate;
    }

    public void gU(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int acD() {
        return this.bPt;
    }

    public void gV(int i) {
        this.bPt = i;
    }

    public int acE() {
        return this.bPu;
    }

    public void gW(int i) {
        this.bPu = i;
    }

    public String acF() {
        return this.bPv;
    }

    public void ly(String str) {
        this.bPv = str;
    }
}
