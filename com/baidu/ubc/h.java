package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bqf;
    private String jwl;
    private String jwm;
    private int jwn;
    private int jwo;
    private int jwp;
    private String jwq;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.jwl = str2;
        this.jwm = str3;
        this.jwn = i;
        this.mType = str4;
        this.bqf = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String crZ() {
        return this.jwl;
    }

    public String csa() {
        return this.jwm;
    }

    public int getTimeout() {
        return this.jwn;
    }

    public String getType() {
        return this.mType;
    }

    public String csb() {
        return this.bqf;
    }

    public int csc() {
        return this.mRate;
    }

    public void BG(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int csd() {
        return this.jwo;
    }

    public void BH(int i) {
        this.jwo = i;
    }

    public int cse() {
        return this.jwp;
    }

    public void BI(int i) {
        this.jwp = i;
    }

    public String getIdType() {
        return this.jwq;
    }

    public void EK(String str) {
        this.jwq = str;
    }
}
