package com.baidu.ubc;
/* loaded from: classes2.dex */
class h {
    private String bvA;
    private String bvu;
    private String bvv;
    private int bvw;
    private String bvx;
    private int bvy;
    private int bvz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;

    public h(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.bvu = str2;
        this.bvv = str3;
        this.bvw = i;
        this.mType = str4;
        this.bvx = str5;
    }

    public String getId() {
        return this.mId;
    }

    public String WM() {
        return this.bvu;
    }

    public String WN() {
        return this.bvv;
    }

    public int getTimeout() {
        return this.bvw;
    }

    public String getType() {
        return this.mType;
    }

    public String WO() {
        return this.bvx;
    }

    public int WP() {
        return this.mRate;
    }

    public void fU(int i) {
        this.mRate = i;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public int WQ() {
        return this.bvy;
    }

    public void fV(int i) {
        this.bvy = i;
    }

    public int WR() {
        return this.bvz;
    }

    public void fW(int i) {
        this.bvz = i;
    }

    public String getIdType() {
        return this.bvA;
    }

    public void kN(String str) {
        this.bvA = str;
    }
}
