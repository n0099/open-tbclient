package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class k {
    private int eyA;
    private String eyB;
    private String eyv;
    private String eyw;
    private int eyx;
    private String eyy;
    private int eyz;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String oTb;
    private String oTc;
    private String oTd;
    private String oTe;
    private String oTf;
    private int oTg = 2;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.eyv = str2;
        this.eyw = str3;
        this.eyx = i;
        this.mType = str4;
        this.eyy = str5;
    }

    public void mj(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mk(int i) {
        this.eyz = i;
    }

    public void ml(int i) {
        this.eyA = i;
    }

    public void Xk(String str) {
        this.oTb = str;
    }

    public String getId() {
        return this.mId;
    }

    public String beJ() {
        return this.eyv;
    }

    public String beK() {
        return this.eyw;
    }

    public int getTimeout() {
        return this.eyx;
    }

    public String getType() {
        return this.mType;
    }

    public String beL() {
        return this.eyy;
    }

    public String ehB() {
        return this.oTb;
    }

    public int beM() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int beN() {
        return this.eyz;
    }

    public int beO() {
        return this.eyA;
    }

    public void yF(String str) {
        this.eyB = str;
    }

    public String beP() {
        return this.eyB;
    }

    public String ehC() {
        return this.oTc;
    }

    public void Xl(String str) {
        this.oTc = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Xm(String str) {
        this.oTd = str;
    }

    public String ehD() {
        return this.oTd;
    }

    public void Xn(String str) {
        this.oTe = str;
    }

    public String ehE() {
        return this.oTe;
    }

    public String ehF() {
        return this.oTf;
    }

    public void Xo(String str) {
        this.oTf = str;
    }

    public int ehG() {
        return this.oTg;
    }

    public void Ni(int i) {
        this.oTg = i;
    }
}
