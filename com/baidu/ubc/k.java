package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class k {
    private String duA;
    private String duB;
    private int duC;
    private String duD;
    private int duE;
    private int duF;
    private String duG;
    private String mCategory;
    private String mEg;
    private String mEh;
    private String mEi;
    private String mEj;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.duA = str2;
        this.duB = str3;
        this.duC = i;
        this.mType = str4;
        this.duD = str5;
    }

    public void jH(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jI(int i) {
        this.duE = i;
    }

    public void jJ(int i) {
        this.duF = i;
    }

    public void PS(String str) {
        this.mEg = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aJp() {
        return this.duA;
    }

    public String aJq() {
        return this.duB;
    }

    public int getTimeout() {
        return this.duC;
    }

    public String getType() {
        return this.mType;
    }

    public String aJr() {
        return this.duD;
    }

    public String dwK() {
        return this.mEg;
    }

    public int aJs() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aJt() {
        return this.duE;
    }

    public int aJu() {
        return this.duF;
    }

    public void tV(String str) {
        this.duG = str;
    }

    public String aJv() {
        return this.duG;
    }

    public String dwL() {
        return this.mEh;
    }

    public void PT(String str) {
        this.mEh = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void PU(String str) {
        this.mEi = str;
    }

    public String dwM() {
        return this.mEi;
    }

    public void PV(String str) {
        this.mEj = str;
    }

    public String dwN() {
        return this.mEj;
    }
}
