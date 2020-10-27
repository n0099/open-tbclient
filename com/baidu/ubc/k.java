package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class k {
    private String egd;
    private String ege;
    private int egf;
    private String egg;
    private int egh;
    private int egi;
    private String egj;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String ohA;
    private String ohB;
    private String ohC;
    private String ohD;
    private String ohE;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.egd = str2;
        this.ege = str3;
        this.egf = i;
        this.mType = str4;
        this.egg = str5;
    }

    public void mZ(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void na(int i) {
        this.egh = i;
    }

    public void nb(int i) {
        this.egi = i;
    }

    public void Wg(String str) {
        this.ohA = str;
    }

    public String getId() {
        return this.mId;
    }

    public String baU() {
        return this.egd;
    }

    public String baV() {
        return this.ege;
    }

    public int getTimeout() {
        return this.egf;
    }

    public String getType() {
        return this.mType;
    }

    public String baW() {
        return this.egg;
    }

    public String dZz() {
        return this.ohA;
    }

    public int baX() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int baY() {
        return this.egh;
    }

    public int baZ() {
        return this.egi;
    }

    public void yI(String str) {
        this.egj = str;
    }

    public String bba() {
        return this.egj;
    }

    public String dZA() {
        return this.ohB;
    }

    public void Wh(String str) {
        this.ohB = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Wi(String str) {
        this.ohC = str;
    }

    public String dZB() {
        return this.ohC;
    }

    public void Wj(String str) {
        this.ohD = str;
    }

    public String dZC() {
        return this.ohD;
    }

    public String dZD() {
        return this.ohE;
    }

    public void Wk(String str) {
        this.ohE = str;
    }
}
