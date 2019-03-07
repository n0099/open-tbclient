package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bqe;
    private String jwa;
    private String jwb;
    private int jwc;
    private int jwd;
    private int jwe;
    private String jwf;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.jwa = str2;
        this.jwb = str3;
        this.jwc = i;
        this.mType = str4;
        this.bqe = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String crM() {
        return this.jwa;
    }

    public String crN() {
        return this.jwb;
    }

    public int getTimeout() {
        return this.jwc;
    }

    public String getType() {
        return this.mType;
    }

    public String crO() {
        return this.bqe;
    }

    public int crP() {
        return this.mRate;
    }

    public void BF(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int crQ() {
        return this.jwd;
    }

    public void BG(int i) {
        this.jwd = i;
    }

    public int crR() {
        return this.jwe;
    }

    public void BH(int i) {
        this.jwe = i;
    }

    public String getIdType() {
        return this.jwf;
    }

    public void EJ(String str) {
        this.jwf = str;
    }
}
