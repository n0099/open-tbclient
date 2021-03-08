package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class k {
    private int eAa;
    private int eAb;
    private String eAc;
    private String ezW;
    private String ezX;
    private int ezY;
    private String ezZ;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String oVG;
    private String oVH;
    private String oVI;
    private String oVJ;
    private String oVK;
    private int oVL = 2;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ezW = str2;
        this.ezX = str3;
        this.ezY = i;
        this.mType = str4;
        this.ezZ = str5;
    }

    public void mk(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void ml(int i) {
        this.eAa = i;
    }

    public void mm(int i) {
        this.eAb = i;
    }

    public void XD(String str) {
        this.oVG = str;
    }

    public String getId() {
        return this.mId;
    }

    public String beL() {
        return this.ezW;
    }

    public String beM() {
        return this.ezX;
    }

    public int getTimeout() {
        return this.ezY;
    }

    public String getType() {
        return this.mType;
    }

    public String beN() {
        return this.ezZ;
    }

    public String ehR() {
        return this.oVG;
    }

    public int beO() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int beP() {
        return this.eAa;
    }

    public int beQ() {
        return this.eAb;
    }

    public void yM(String str) {
        this.eAc = str;
    }

    public String beR() {
        return this.eAc;
    }

    public String ehS() {
        return this.oVH;
    }

    public void XE(String str) {
        this.oVH = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void XF(String str) {
        this.oVI = str;
    }

    public String ehT() {
        return this.oVI;
    }

    public void XG(String str) {
        this.oVJ = str;
    }

    public String ehU() {
        return this.oVJ;
    }

    public String ehV() {
        return this.oVK;
    }

    public void XH(String str) {
        this.oVK = str;
    }

    public int ehW() {
        return this.oVL;
    }

    public void Nn(int i) {
        this.oVL = i;
    }
}
