package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class k {
    private String dXH;
    private String dXI;
    private int dXJ;
    private String dXK;
    private int dXL;
    private int dXM;
    private String dXN;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String nEY;
    private String nEZ;
    private String nFa;
    private String nFb;
    private String nFc;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dXH = str2;
        this.dXI = str3;
        this.dXJ = i;
        this.mType = str4;
        this.dXK = str5;
    }

    public void mO(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mP(int i) {
        this.dXL = i;
    }

    public void mQ(int i) {
        this.dXM = i;
    }

    public void US(String str) {
        this.nEY = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aZb() {
        return this.dXH;
    }

    public String aZc() {
        return this.dXI;
    }

    public int getTimeout() {
        return this.dXJ;
    }

    public String getType() {
        return this.mType;
    }

    public String aZd() {
        return this.dXK;
    }

    public String dTH() {
        return this.nEY;
    }

    public int aZe() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aZf() {
        return this.dXL;
    }

    public int aZg() {
        return this.dXM;
    }

    public void yp(String str) {
        this.dXN = str;
    }

    public String aZh() {
        return this.dXN;
    }

    public String dTI() {
        return this.nEZ;
    }

    public void UT(String str) {
        this.nEZ = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void UU(String str) {
        this.nFa = str;
    }

    public String dTJ() {
        return this.nFa;
    }

    public void UV(String str) {
        this.nFb = str;
    }

    public String dTK() {
        return this.nFb;
    }

    public String dTL() {
        return this.nFc;
    }

    public void UW(String str) {
        this.nFc = str;
    }
}
