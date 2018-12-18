package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String ibH;
    private String ibI;
    private int ibJ;
    private String ibK;
    private int ibL;
    private int ibM;
    private String ibN;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ibH = str2;
        this.ibI = str3;
        this.ibJ = i;
        this.mType = str4;
        this.ibK = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bQT() {
        return this.ibH;
    }

    public String bQU() {
        return this.ibI;
    }

    public int getTimeout() {
        return this.ibJ;
    }

    public String getType() {
        return this.mType;
    }

    public String bQV() {
        return this.ibK;
    }

    public int bQW() {
        return this.mRate;
    }

    public void xC(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int bQX() {
        return this.ibL;
    }

    public void xD(int i) {
        this.ibL = i;
    }

    public int bQY() {
        return this.ibM;
    }

    public void xE(int i) {
        this.ibM = i;
    }

    public String getIdType() {
        return this.ibN;
    }

    public void yf(String str) {
        this.ibN = str;
    }
}
