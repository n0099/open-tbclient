package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bqe;
    private String jwt;
    private String jwu;
    private int jwv;
    private int jww;
    private int jwx;
    private String jwy;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.jwt = str2;
        this.jwu = str3;
        this.jwv = i;
        this.mType = str4;
        this.bqe = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String crW() {
        return this.jwt;
    }

    public String crX() {
        return this.jwu;
    }

    public int getTimeout() {
        return this.jwv;
    }

    public String getType() {
        return this.mType;
    }

    public String crY() {
        return this.bqe;
    }

    public int crZ() {
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

    public int csa() {
        return this.jww;
    }

    public void BH(int i) {
        this.jww = i;
    }

    public int csb() {
        return this.jwx;
    }

    public void BI(int i) {
        this.jwx = i;
    }

    public String getIdType() {
        return this.jwy;
    }

    public void EM(String str) {
        this.jwy = str;
    }
}
