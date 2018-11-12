package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String hUA;
    private int hUB;
    private int hUC;
    private String hUD;
    private String hUx;
    private String hUy;
    private int hUz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.hUx = str2;
        this.hUy = str3;
        this.hUz = i;
        this.mType = str4;
        this.hUA = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String bOO() {
        return this.hUx;
    }

    public String bOP() {
        return this.hUy;
    }

    public int getTimeout() {
        return this.hUz;
    }

    public String getType() {
        return this.mType;
    }

    public String bOQ() {
        return this.hUA;
    }

    public int bOR() {
        return this.mRate;
    }

    public void xf(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int bOS() {
        return this.hUB;
    }

    public void xg(int i) {
        this.hUB = i;
    }

    public int bOT() {
        return this.hUC;
    }

    public void xh(int i) {
        this.hUC = i;
    }

    public String getIdType() {
        return this.hUD;
    }

    public void xC(String str) {
        this.hUD = str;
    }
}
