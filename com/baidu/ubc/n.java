package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes5.dex */
class n {
    private String adH;
    private String eAf;
    private int eAg;
    private JSONObject eAh;
    private String eAi;
    private boolean eAj;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String oVI;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.oVI = "0";
        this.mId = str;
        this.eAf = str;
        this.eAg = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.oVI = "0";
        this.mId = str;
        this.eAf = str;
        this.eAg = -1;
        this.eAh = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.oVI = "0";
        this.mId = str2;
        this.eAf = str;
        this.eAg = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.eAj = false;
        this.adH = "";
        this.oVI = "0";
        this.mId = str2;
        this.eAf = str;
        this.eAg = i;
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

    public String beU() {
        return this.eAf;
    }

    public int beV() {
        return this.eAg;
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

    public String beW() {
        return this.eAi;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject beX() {
        return this.eAh;
    }

    public void setFileName(String str) {
        this.adH = str;
    }

    public String getFileName() {
        return this.adH;
    }

    public void iJ(boolean z) {
        this.eAj = z;
    }

    public boolean beS() {
        return this.eAj;
    }

    public void beZ() {
        if (this.mId != null && this.mId.equals(this.eAf) && g.ehN().yE(this.mId)) {
            this.eAi = UBC.getUBCContext().aDA();
        }
    }

    public void XF(String str) {
        this.oVI = str;
    }

    public String ehT() {
        return this.oVI;
    }
}
