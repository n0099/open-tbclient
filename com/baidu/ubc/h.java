package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bqi;
    private String jwb;
    private String jwc;
    private int jwd;
    private int jwe;
    private int jwf;
    private String jwg;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.jwb = str2;
        this.jwc = str3;
        this.jwd = i;
        this.mType = str4;
        this.bqi = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String crX() {
        return this.jwb;
    }

    public String crY() {
        return this.jwc;
    }

    public int getTimeout() {
        return this.jwd;
    }

    public String getType() {
        return this.mType;
    }

    public String crZ() {
        return this.bqi;
    }

    public int csa() {
        return this.mRate;
    }

    public void BC(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int csb() {
        return this.jwe;
    }

    public void BD(int i) {
        this.jwe = i;
    }

    public int csc() {
        return this.jwf;
    }

    public void BE(int i) {
        this.jwf = i;
    }

    public String getIdType() {
        return this.jwg;
    }

    public void EJ(String str) {
        this.jwg = str;
    }
}
