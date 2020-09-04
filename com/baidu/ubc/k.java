package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class k {
    private String dJC;
    private String dJD;
    private int dJE;
    private String dJF;
    private int dJG;
    private int dJH;
    private String dJI;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String nfD;
    private String nfE;
    private String nfF;
    private String nfG;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dJC = str2;
        this.dJD = str3;
        this.dJE = i;
        this.mType = str4;
        this.dJF = str5;
    }

    public void mg(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mh(int i) {
        this.dJG = i;
    }

    public void mi(int i) {
        this.dJH = i;
    }

    public void TD(String str) {
        this.nfD = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aVH() {
        return this.dJC;
    }

    public String aVI() {
        return this.dJD;
    }

    public int getTimeout() {
        return this.dJE;
    }

    public String getType() {
        return this.mType;
    }

    public String aVJ() {
        return this.dJF;
    }

    public String dLY() {
        return this.nfD;
    }

    public int aVK() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aVL() {
        return this.dJG;
    }

    public int aVM() {
        return this.dJH;
    }

    public void xk(String str) {
        this.dJI = str;
    }

    public String aVN() {
        return this.dJI;
    }

    public String dLZ() {
        return this.nfE;
    }

    public void TE(String str) {
        this.nfE = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void TF(String str) {
        this.nfF = str;
    }

    public String dMa() {
        return this.nfF;
    }

    public void TG(String str) {
        this.nfG = str;
    }

    public String dMb() {
        return this.nfG;
    }
}
