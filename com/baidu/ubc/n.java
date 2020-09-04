package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes18.dex */
class n {
    private String ZV;
    private String dJL;
    private int dJM;
    private JSONObject dJN;
    private String dJO;
    private boolean dJP;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String nfF;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.dJP = false;
        this.ZV = "";
        this.nfF = "0";
        this.mId = str;
        this.dJL = str;
        this.dJM = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dJP = false;
        this.ZV = "";
        this.nfF = "0";
        this.mId = str;
        this.dJL = str;
        this.dJM = -1;
        this.dJN = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dJP = false;
        this.ZV = "";
        this.nfF = "0";
        this.mId = str2;
        this.dJL = str;
        this.dJM = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dJP = false;
        this.ZV = "";
        this.nfF = "0";
        this.mId = str2;
        this.dJL = str;
        this.dJM = i;
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

    public String aVQ() {
        return this.dJL;
    }

    public int aVR() {
        return this.dJM;
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

    public String aVS() {
        return this.dJO;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aVT() {
        return this.dJN;
    }

    public void setFileName(String str) {
        this.ZV = str;
    }

    public String getFileName() {
        return this.ZV;
    }

    public void hi(boolean z) {
        this.dJP = z;
    }

    public boolean aVO() {
        return this.dJP;
    }

    public void aVV() {
        if (this.mId != null && this.mId.equals(this.dJL) && g.dLW().xc(this.mId)) {
            this.dJO = UBC.getUBCContext().avl();
        }
    }

    public void TF(String str) {
        this.nfF = str;
    }

    public String dMa() {
        return this.nfF;
    }
}
