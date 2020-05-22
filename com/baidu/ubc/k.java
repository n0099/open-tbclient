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
    private String mhb;
    private String mhc;
    private String mhd;
    private String mhe;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.dpO = str2;
        this.dpP = str3;
        this.dpQ = i;
        this.mType = str4;
        this.dpR = str5;
    }

    public void ju(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void jv(int i) {
        this.dpS = i;
    }

    public void jw(int i) {
        this.dpT = i;
    }

    public void Pf(String str) {
        this.mhb = str;
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

    public String drR() {
        return this.mhb;
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

    public String drS() {
        return this.mhc;
    }

    public void Pg(String str) {
        this.mhc = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Ph(String str) {
        this.mhd = str;
    }

    public String drT() {
        return this.mhd;
    }

    public void Pi(String str) {
        this.mhe = str;
    }

    public String drU() {
        return this.mhe;
    }
}
