package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes16.dex */
public class k {
    private String dLG;
    private String dLH;
    private int dLI;
    private String dLJ;
    private int dLK;
    private int dLL;
    private String dLM;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String npE;
    private String npF;
    private String npG;
    private String npH;
    private String npI;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dLG = str2;
        this.dLH = str3;
        this.dLI = i;
        this.mType = str4;
        this.dLJ = str5;
    }

    public void mr(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void ms(int i) {
        this.dLK = i;
    }

    public void mt(int i) {
        this.dLL = i;
    }

    public void Ue(String str) {
        this.npE = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aWt() {
        return this.dLG;
    }

    public String aWu() {
        return this.dLH;
    }

    public int getTimeout() {
        return this.dLI;
    }

    public String getType() {
        return this.mType;
    }

    public String aWv() {
        return this.dLJ;
    }

    public String dPW() {
        return this.npE;
    }

    public int aWw() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aWx() {
        return this.dLK;
    }

    public int aWy() {
        return this.dLL;
    }

    public void xD(String str) {
        this.dLM = str;
    }

    public String aWz() {
        return this.dLM;
    }

    public String dPX() {
        return this.npF;
    }

    public void Uf(String str) {
        this.npF = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Ug(String str) {
        this.npG = str;
    }

    public String dPY() {
        return this.npG;
    }

    public void Uh(String str) {
        this.npH = str;
    }

    public String dPZ() {
        return this.npH;
    }

    public String dQa() {
        return this.npI;
    }

    public void Ui(String str) {
        this.npI = str;
    }
}
