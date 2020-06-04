package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class k {
    private String dpO;
    private String dpP;
    private int dpQ;
    private String dpR;
    private int dpS;
    private int dpT;
    private String dpU;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String mim;
    private String mio;
    private String mip;
    private String miq;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dpO = str2;
        this.dpP = str3;
        this.dpQ = i;
        this.mType = str4;
        this.dpR = str5;
    }

    public void jw(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jx(int i) {
        this.dpS = i;
    }

    public void jy(int i) {
        this.dpT = i;
    }

    public void Pg(String str) {
        this.mim = str;
    }

    public String getId() {
        return this.mId;
    }

    public String aIj() {
        return this.dpO;
    }

    public String aIk() {
        return this.dpP;
    }

    public int getTimeout() {
        return this.dpQ;
    }

    public String getType() {
        return this.mType;
    }

    public String aIl() {
        return this.dpR;
    }

    public String dsf() {
        return this.mim;
    }

    public int aIm() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int aIn() {
        return this.dpS;
    }

    public int aIo() {
        return this.dpT;
    }

    public void tN(String str) {
        this.dpU = str;
    }

    public String aIp() {
        return this.dpU;
    }

    public String dsg() {
        return this.mio;
    }

    public void Ph(String str) {
        this.mio = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Pi(String str) {
        this.mip = str;
    }

    public String dsh() {
        return this.mip;
    }

    public void Pj(String str) {
        this.miq = str;
    }

    public String dsi() {
        return this.miq;
    }
}
