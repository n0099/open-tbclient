package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class k {
    private String ddQ;
    private String ddR;
    private int ddS;
    private String ddT;
    private int ddU;
    private int ddV;
    private String ddW;
    private String lNI;
    private String lNJ;
    private String lNK;
    private String lNL;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ddQ = str2;
        this.ddR = str3;
        this.ddS = i;
        this.mType = str4;
        this.ddT = str5;
    }

    public void jb(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jc(int i) {
        this.ddU = i;
    }

    public void jd(int i) {
        this.ddV = i;
    }

    public void Np(String str) {
        this.lNI = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aDA() {
        return this.ddQ;
    }

    public String aDB() {
        return this.ddR;
    }

    public int getTimeout() {
        return this.ddS;
    }

    public String getType() {
        return this.mType;
    }

    public String aDC() {
        return this.ddT;
    }

    public String dkD() {
        return this.lNI;
    }

    public int aDD() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aDE() {
        return this.ddU;
    }

    public int aDF() {
        return this.ddV;
    }

    public void si(String str) {
        this.ddW = str;
    }

    public String aDG() {
        return this.ddW;
    }

    public String dkE() {
        return this.lNJ;
    }

    public void Nq(String str) {
        this.lNJ = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Nr(String str) {
        this.lNK = str;
    }

    public String dkF() {
        return this.lNK;
    }

    public void Ns(String str) {
        this.lNL = str;
    }

    public String dkG() {
        return this.lNL;
    }
}
