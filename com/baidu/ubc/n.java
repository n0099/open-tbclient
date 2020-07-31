package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes9.dex */
class n {
    private String Zo;
    private JSONObject dAA;
    private String dAB;
    private boolean dAC;
    private String dAy;
    private int dAz;
    private String mCategory;
    private String mContent;
    private String mId;
    private String mMp;
    private int mOption;
    private long mTime;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mMp = "0";
        this.mId = str;
        this.dAy = str;
        this.dAz = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mMp = "0";
        this.mId = str;
        this.dAy = str;
        this.dAz = -1;
        this.dAA = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mMp = "0";
        this.mId = str2;
        this.dAy = str;
        this.dAz = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dAC = false;
        this.Zo = "";
        this.mMp = "0";
        this.mId = str2;
        this.dAy = str;
        this.dAz = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            if (j > 0) {
                this.mTime = j;
            } else {
                this.mTime = System.currentTimeMillis();
            }
        }
    }

    public String getId() {
        return this.mId;
    }

    public String aNq() {
        return this.dAy;
    }

    public int aNr() {
        return this.dAz;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aNs() {
        return this.dAB;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aNt() {
        return this.dAA;
    }

    public void setFileName(String str) {
        this.Zo = str;
    }

    public String getFileName() {
        return this.Zo;
    }

    public void gN(boolean z) {
        this.dAC = z;
    }

    public boolean aNo() {
        return this.dAC;
    }

    public void aNv() {
        if (this.mId != null && this.mId.equals(this.dAy) && g.dzZ().uQ(this.mId)) {
            this.dAB = UBC.getUBCContext().anq();
        }
    }

    public void QG(String str) {
        this.mMp = str;
    }

    public String dAd() {
        return this.mMp;
    }
}
