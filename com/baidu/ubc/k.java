package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class k {
    private int dJA;
    private String dJB;
    private int dJC;
    private int dJD;
    private String dJE;
    private String dJy;
    private String dJz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String nfl;
    private String nfm;
    private String nfn;
    private String nfo;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dJy = str2;
        this.dJz = str3;
        this.dJA = i;
        this.mType = str4;
        this.dJB = str5;
    }

    public void mg(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mh(int i) {
        this.dJC = i;
    }

    public void mi(int i) {
        this.dJD = i;
    }

    public void TD(String str) {
        this.nfl = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aVH() {
        return this.dJy;
    }

    public String aVI() {
        return this.dJz;
    }

    public int getTimeout() {
        return this.dJA;
    }

    public String getType() {
        return this.mType;
    }

    public String aVJ() {
        return this.dJB;
    }

    public String dLP() {
        return this.nfl;
    }

    public int aVK() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aVL() {
        return this.dJC;
    }

    public int aVM() {
        return this.dJD;
    }

    public void xj(String str) {
        this.dJE = str;
    }

    public String aVN() {
        return this.dJE;
    }

    public String dLQ() {
        return this.nfm;
    }

    public void TE(String str) {
        this.nfm = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void TF(String str) {
        this.nfn = str;
    }

    public String dLR() {
        return this.nfn;
    }

    public void TG(String str) {
        this.nfo = str;
    }

    public String dLS() {
        return this.nfo;
    }
}
