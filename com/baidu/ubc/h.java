package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private int bOA;
    private String bOB;
    private int bOC;
    private int bOD;
    private String bOE;
    private String bOy;
    private String bOz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.bOy = str2;
        this.bOz = str3;
        this.bOA = i;
        this.mType = str4;
        this.bOB = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String acx() {
        return this.bOy;
    }

    public String acy() {
        return this.bOz;
    }

    public int getTimeout() {
        return this.bOA;
    }

    public String getType() {
        return this.mType;
    }

    public String acz() {
        return this.bOB;
    }

    public int acA() {
        return this.mRate;
    }

    public void gT(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int acB() {
        return this.bOC;
    }

    public void gU(int i) {
        this.bOC = i;
    }

    public int acC() {
        return this.bOD;
    }

    public void gV(int i) {
        this.bOD = i;
    }

    public String acD() {
        return this.bOE;
    }

    public void ly(String str) {
        this.bOE = str;
    }
}
