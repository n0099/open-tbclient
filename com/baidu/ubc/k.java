package com.baidu.ubc;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class k {
    private String ewm;
    private String ewn;
    private int ewo;
    private String ewp;
    private int ewq;
    private int ewr;
    private String ews;
    private String mCategory;
    private String mId;
    private int mRate;
    private String mType;
    private String mVersion;
    private String oIT;
    private String oIU;
    private String oIV;
    private String oIW;
    private String oIX;
    private int oIY = 2;

    public k(String str, String str2, String str3, int i, String str4, String str5) {
        this.mId = str;
        this.ewm = str2;
        this.ewn = str3;
        this.ewo = i;
        this.mType = str4;
        this.ewp = str5;
    }

    public void mg(int i) {
        this.mRate = i;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void mh(int i) {
        this.ewq = i;
    }

    public void mi(int i) {
        this.ewr = i;
    }

    public void Wl(String str) {
        this.oIT = str;
    }

    public String getId() {
        return this.mId;
    }

    public String bew() {
        return this.ewm;
    }

    public String bex() {
        return this.ewn;
    }

    public int getTimeout() {
        return this.ewo;
    }

    public String getType() {
        return this.mType;
    }

    public String bey() {
        return this.ewp;
    }

    public String efj() {
        return this.oIT;
    }

    public int bez() {
        return this.mRate;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public int beA() {
        return this.ewq;
    }

    public int beB() {
        return this.ewr;
    }

    public void ym(String str) {
        this.ews = str;
    }

    public String beC() {
        return this.ews;
    }

    public String efk() {
        return this.oIU;
    }

    public void Wm(String str) {
        this.oIU = str;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }

    public String getVersion() {
        return TextUtils.isEmpty(this.mVersion) ? "0" : this.mVersion;
    }

    public void Wn(String str) {
        this.oIV = str;
    }

    public String efl() {
        return this.oIV;
    }

    public void Wo(String str) {
        this.oIW = str;
    }

    public String efm() {
        return this.oIW;
    }

    public String efn() {
        return this.oIX;
    }

    public void Wp(String str) {
        this.oIX = str;
    }

    public int efo() {
        return this.oIY;
    }

    public void MM(int i) {
        this.oIY = i;
    }
}
