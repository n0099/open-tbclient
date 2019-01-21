package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String igc;
    private String igd;
    private int ige;
    private String igf;
    private int igg;
    private int igh;
    private String igi;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.igc = str2;
        this.igd = str3;
        this.ige = i;
        this.mType = str4;
        this.igf = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bSs() {
        return this.igc;
    }

    public String bSt() {
        return this.igd;
    }

    public int getTimeout() {
        return this.ige;
    }

    public String getType() {
        return this.mType;
    }

    public String bSu() {
        return this.igf;
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
        return this.igg;
    }

    public void xS(int i) {
        this.igg = i;
    }

    public int bSx() {
        return this.igh;
    }

    public void xT(int i) {
        this.igh = i;
    }

    public String getIdType() {
        return this.igi;
    }

    public void yy(String str) {
        this.igi = str;
    }
}
