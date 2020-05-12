package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class k {
    private String ddV;
    private String ddW;
    private int ddX;
    private String ddY;
    private int ddZ;
    private int dea;
    private String deb;
    private String lNM;
    private String lNN;
    private String lNO;
    private String lNP;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ddV = str2;
        this.ddW = str3;
        this.ddX = i;
        this.mType = str4;
        this.ddY = str5;
    }

    public void jb(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jc(int i) {
        this.ddZ = i;
    }

    public void jd(int i) {
        this.dea = i;
    }

    public void Ns(String str) {
        this.lNM = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aDA() {
        return this.ddV;
    }

    public String aDB() {
        return this.ddW;
    }

    public int getTimeout() {
        return this.ddX;
    }

    public String getType() {
        return this.mType;
    }

    public String aDC() {
        return this.ddY;
    }

    public String dkB() {
        return this.lNM;
    }

    public int aDD() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aDE() {
        return this.ddZ;
    }

    public int aDF() {
        return this.dea;
    }

    public void si(String str) {
        this.deb = str;
    }

    public String aDG() {
        return this.deb;
    }

    public String dkC() {
        return this.lNN;
    }

    public void Nt(String str) {
        this.lNN = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Nu(String str) {
        this.lNO = str;
    }

    public String dkD() {
        return this.lNO;
    }

    public void Nv(String str) {
        this.lNP = str;
    }

    public String dkE() {
        return this.lNP;
    }
}
