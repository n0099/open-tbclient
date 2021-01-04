package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class k {
    private String eBb;
    private String eBc;
    private int eBd;
    private String eBe;
    private int eBf;
    private int eBg;
    private String eBh;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String oNA;
    private String oNB;
    private int oNC = 2;
    private String oNx;
    private String oNy;
    private String oNz;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.eBb = str2;
        this.eBc = str3;
        this.eBd = i;
        this.mType = str4;
        this.eBe = str5;
    }

    public void nM(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void nN(int i) {
        this.eBf = i;
    }

    public void nO(int i) {
        this.eBg = i;
    }

    public void Xt(String str) {
        this.oNx = str;
    }

    public String getId() {
        return this.mId;
    }

    public String bip() {
        return this.eBb;
    }

    public String biq() {
        return this.eBc;
    }

    public int getTimeout() {
        return this.eBd;
    }

    public String getType() {
        return this.mType;
    }

    public String bir() {
        return this.eBe;
    }

    public String eja() {
        return this.oNx;
    }

    public int bis() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bit() {
        return this.eBf;
    }

    public int biu() {
        return this.eBg;
    }

    public void zx(String str) {
        this.eBh = str;
    }

    public String biv() {
        return this.eBh;
    }

    public String ejb() {
        return this.oNy;
    }

    public void Xu(String str) {
        this.oNy = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Xv(String str) {
        this.oNz = str;
    }

    public String ejc() {
        return this.oNz;
    }

    public void Xw(String str) {
        this.oNA = str;
    }

    public String ejd() {
        return this.oNA;
    }

    public String eje() {
        return this.oNB;
    }

    public void Xx(String str) {
        this.oNB = str;
    }

    public int ejf() {
        return this.oNC;
    }

    public void Ot(int i) {
        this.oNC = i;
    }
}
