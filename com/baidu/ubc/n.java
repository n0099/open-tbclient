package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes5.dex */
class n {
    private String acr;
    private String ewv;
    private int eww;
    private JSONObject ewx;
    private String ewy;
    private boolean ewz;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String oIV;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.oIV = "0";
        this.mId = str;
        this.ewv = str;
        this.eww = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.oIV = "0";
        this.mId = str;
        this.ewv = str;
        this.eww = -1;
        this.ewx = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.oIV = "0";
        this.mId = str2;
        this.ewv = str;
        this.eww = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.ewz = false;
        this.acr = "";
        this.oIV = "0";
        this.mId = str2;
        this.ewv = str;
        this.eww = i;
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

    public String beF() {
        return this.ewv;
    }

    public int beG() {
        return this.eww;
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

    public String beH() {
        return this.ewy;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject beI() {
        return this.ewx;
    }

    public void setFileName(String str) {
        this.acr = str;
    }

    public String getFileName() {
        return this.acr;
    }

    public void iH(boolean z) {
        this.ewz = z;
    }

    public boolean beD() {
        return this.ewz;
    }

    public void beK() {
        if (this.mId != null && this.mId.equals(this.ewv) && g.eff().ye(this.mId)) {
            this.ewy = UBC.getUBCContext().aDb();
        }
    }

    public void Wn(String str) {
        this.oIV = str;
    }

    public String efl() {
        return this.oIV;
    }
}
