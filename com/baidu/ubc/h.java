package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bqj;
    private String jwc;
    private String jwd;
    private int jwe;
    private int jwf;
    private int jwg;
    private String jwh;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.jwc = str2;
        this.jwd = str3;
        this.jwe = i;
        this.mType = str4;
        this.bqj = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String crX() {
        return this.jwc;
    }

    public String crY() {
        return this.jwd;
    }

    public int getTimeout() {
        return this.jwe;
    }

    public String getType() {
        return this.mType;
    }

    public String crZ() {
        return this.bqj;
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
        return this.jwf;
    }

    public void BD(int i) {
        this.jwf = i;
    }

    public int csc() {
        return this.jwg;
    }

    public void BE(int i) {
        this.jwg = i;
    }

    public String getIdType() {
        return this.jwh;
    }

    public void EJ(String str) {
        this.jwh = str;
    }
}
