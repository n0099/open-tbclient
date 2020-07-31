package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class k {
    private String dAp;
    private String dAq;
    private int dAr;
    private String dAs;
    private int dAt;
    private int dAu;
    private String dAv;
    private String mCategory;
    private String mId;
    private String mMn;
    private String mMo;
    private String mMp;
    private String mMq;
    private int mRate;
    private String mType;
    private String mVersion;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dAp = str2;
        this.dAq = str3;
        this.dAr = i;
        this.mType = str4;
        this.dAs = str5;
    }

    public void ka(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void kb(int i) {
        this.dAt = i;
    }

    public void kc(int i) {
        this.dAu = i;
    }

    public void QE(String str) {
        this.mMn = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aNh() {
        return this.dAp;
    }

    public String aNi() {
        return this.dAq;
    }

    public int getTimeout() {
        return this.dAr;
    }

    public String getType() {
        return this.mType;
    }

    public String aNj() {
        return this.dAs;
    }

    public String dAb() {
        return this.mMn;
    }

    public int aNk() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aNl() {
        return this.dAt;
    }

    public int aNm() {
        return this.dAu;
    }

    public void uY(String str) {
        this.dAv = str;
    }

    public String aNn() {
        return this.dAv;
    }

    public String dAc() {
        return this.mMo;
    }

    public void QF(String str) {
        this.mMo = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void QG(String str) {
        this.mMp = str;
    }

    public String dAd() {
        return this.mMp;
    }

    public void QH(String str) {
        this.mMq = str;
    }

    public String dAe() {
        return this.mMq;
    }
}
