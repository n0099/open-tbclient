package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class k {
    private String elV;
    private String elW;
    private int elX;
    private String elY;
    private int elZ;
    private int ema;
    private String emb;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String oqF;
    private String oqG;
    private String oqH;
    private String oqI;
    private String oqJ;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.elV = str2;
        this.elW = str3;
        this.elX = i;
        this.mType = str4;
        this.elY = str5;
    }

    public void nj(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void nk(int i) {
        this.elZ = i;
    }

    public void nl(int i) {
        this.ema = i;
    }

    public void WJ(String str) {
        this.oqF = str;
    }

    public String getId() {
        return this.mId;
    }

    public String bdu() {
        return this.elV;
    }

    public String bdv() {
        return this.elW;
    }

    public int getTimeout() {
        return this.elX;
    }

    public String getType() {
        return this.mType;
    }

    public String bdw() {
        return this.elY;
    }

    public String edh() {
        return this.oqF;
    }

    public int bdx() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bdy() {
        return this.elZ;
    }

    public int bdz() {
        return this.ema;
    }

    public void yW(String str) {
        this.emb = str;
    }

    public String bdA() {
        return this.emb;
    }

    public String edi() {
        return this.oqG;
    }

    public void WK(String str) {
        this.oqG = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void WL(String str) {
        this.oqH = str;
    }

    public String edj() {
        return this.oqH;
    }

    public void WM(String str) {
        this.oqI = str;
    }

    public String edk() {
        return this.oqI;
    }

    public String edl() {
        return this.oqJ;
    }

    public void WN(String str) {
        this.oqJ = str;
    }
}
