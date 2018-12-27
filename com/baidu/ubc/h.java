package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String ieU;
    private String ieV;
    private int ieW;
    private String ieX;
    private int ieY;
    private int ieZ;
    private String ifa;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ieU = str2;
        this.ieV = str3;
        this.ieW = i;
        this.mType = str4;
        this.ieX = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bRK() {
        return this.ieU;
    }

    public String bRL() {
        return this.ieV;
    }

    public int getTimeout() {
        return this.ieW;
    }

    public String getType() {
        return this.mType;
    }

    public String bRM() {
        return this.ieX;
    }

    public int bRN() {
        return this.mRate;
    }

    public void xP(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int bRO() {
        return this.ieY;
    }

    public void xQ(int i) {
        this.ieY = i;
    }

    public int bRP() {
        return this.ieZ;
    }

    public void xR(int i) {
        this.ieZ = i;
    }

    public String getIdType() {
        return this.ifa;
    }

    public void yi(String str) {
        this.ifa = str;
    }
}
