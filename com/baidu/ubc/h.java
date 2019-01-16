package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String igb;
    private String igc;
    private int igd;
    private String ige;
    private int igf;
    private int igg;
    private String igh;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.igb = str2;
        this.igc = str3;
        this.igd = i;
        this.mType = str4;
        this.ige = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bSs() {
        return this.igb;
    }

    public String bSt() {
        return this.igc;
    }

    public int getTimeout() {
        return this.igd;
    }

    public String getType() {
        return this.mType;
    }

    public String bSu() {
        return this.ige;
    }

    public int bSv() {
        return this.mRate;
    }

    public void xR(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int bSw() {
        return this.igf;
    }

    public void xS(int i) {
        this.igf = i;
    }

    public int bSx() {
        return this.igg;
    }

    public void xT(int i) {
        this.igg = i;
    }

    public String getIdType() {
        return this.igh;
    }

    public void yy(String str) {
        this.igh = str;
    }
}
