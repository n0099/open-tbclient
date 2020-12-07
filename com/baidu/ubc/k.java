package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class k {
    private String erq;
    private String ers;
    private int ert;
    private String eru;
    private int erv;
    private int erw;
    private String erx;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String oHm;
    private String oHn;
    private String oHo;
    private String oHp;
    private String oHq;
    private int oHr = 2;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.erq = str2;
        this.ers = str3;
        this.ert = i;
        this.mType = str4;
        this.eru = str5;
    }

    public void nD(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void nE(int i) {
        this.erv = i;
    }

    public void nF(int i) {
        this.erw = i;
    }

    public void XK(String str) {
        this.oHm = str;
    }

    public String getId() {
        return this.mId;
    }

    public String bfS() {
        return this.erq;
    }

    public String bfT() {
        return this.ers;
    }

    public int getTimeout() {
        return this.ert;
    }

    public String getType() {
        return this.mType;
    }

    public String bfU() {
        return this.eru;
    }

    public String eiP() {
        return this.oHm;
    }

    public int bfV() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int bfW() {
        return this.erv;
    }

    public int bfX() {
        return this.erw;
    }

    public void zy(String str) {
        this.erx = str;
    }

    public String bfY() {
        return this.erx;
    }

    public String eiQ() {
        return this.oHn;
    }

    public void XL(String str) {
        this.oHn = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void XM(String str) {
        this.oHo = str;
    }

    public String eiR() {
        return this.oHo;
    }

    public void XN(String str) {
        this.oHp = str;
    }

    public String eiS() {
        return this.oHp;
    }

    public String eiT() {
        return this.oHq;
    }

    public void XO(String str) {
        this.oHq = str;
    }

    public int eiU() {
        return this.oHr;
    }

    public void OE(int i) {
        this.oHr = i;
    }
}
