package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes17.dex */
public class k {
    private String eko;
    private String ekp;
    private int ekq;
    private String ekr;
    private int eks;
    private int ekt;
    private String eku;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String osj;
    private String osk;
    private String osl;
    private String osm;
    private String osn;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.eko = str2;
        this.ekp = str3;
        this.ekq = i;
        this.mType = str4;
        this.ekr = str5;
    }

    public void nf(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void ng(int i) {
        this.eks = i;
    }

    public void nh(int i) {
        this.ekt = i;
    }

    public void Wu(String str) {
        this.osj = str;
    }

    public String getId() {
        return this.mId;
    }

    public String bcN() {
        return this.eko;
    }

    public String bcO() {
        return this.ekp;
    }

    public int getTimeout() {
        return this.ekq;
    }

    public String getType() {
        return this.mType;
    }

    public String bcP() {
        return this.ekr;
    }

    public String edg() {
        return this.osj;
    }

    public int bcQ() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bcR() {
        return this.eks;
    }

    public int bcS() {
        return this.ekt;
    }

    public void yR(String str) {
        this.eku = str;
    }

    public String bcT() {
        return this.eku;
    }

    public String edh() {
        return this.osk;
    }

    public void Wv(String str) {
        this.osk = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Ww(String str) {
        this.osl = str;
    }

    public String edi() {
        return this.osl;
    }

    public void Wx(String str) {
        this.osm = str;
    }

    public String edj() {
        return this.osm;
    }

    public String edk() {
        return this.osn;
    }

    public void Wy(String str) {
        this.osn = str;
    }
}
