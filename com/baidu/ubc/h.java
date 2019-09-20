package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bwI;
    private String bwJ;
    private int bwK;
    private String bwL;
    private int bwM;
    private int bwN;
    private String bwO;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.bwI = str2;
        this.bwJ = str3;
        this.bwK = i;
        this.mType = str4;
        this.bwL = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String XK() {
        return this.bwI;
    }

    public String XL() {
        return this.bwJ;
    }

    public int getTimeout() {
        return this.bwK;
    }

    public String getType() {
        return this.mType;
    }

    public String XM() {
        return this.bwL;
    }

    public int XN() {
        return this.mRate;
    }

    public void fZ(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int XO() {
        return this.bwM;
    }

    public void ga(int i) {
        this.bwM = i;
    }

    public int XP() {
        return this.bwN;
    }

    public void gb(int i) {
        this.bwN = i;
    }

    public String XQ() {
        return this.bwO;
    }

    public void kW(String str) {
        this.bwO = str;
    }
}
