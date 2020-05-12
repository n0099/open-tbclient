package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes13.dex */
class n {
    private String Yz;
    private String cgr;
    private int ded;
    private JSONObject dee;
    private String def;
    private boolean deg;
    private String lNO;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.deg = false;
        this.Yz = "";
        this.lNO = "0";
        this.mId = str;
        this.cgr = str;
        this.ded = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.deg = false;
        this.Yz = "";
        this.lNO = "0";
        this.mId = str;
        this.cgr = str;
        this.ded = -1;
        this.dee = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.deg = false;
        this.Yz = "";
        this.lNO = "0";
        this.mId = str2;
        this.cgr = str;
        this.ded = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.deg = false;
        this.Yz = "";
        this.lNO = "0";
        this.mId = str2;
        this.cgr = str;
        this.ded = i;
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

    public String ahF() {
        return this.cgr;
    }

    public int aDJ() {
        return this.ded;
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

    public String aDK() {
        return this.def;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aDL() {
        return this.dee;
    }

    public void setFileName(String str) {
        this.Yz = str;
    }

    public String getFileName() {
        return this.Yz;
    }

    public void gc(boolean z) {
        this.deg = z;
    }

    public boolean aDH() {
        return this.deg;
    }

    public void aDN() {
        if (this.mId != null && this.mId.equals(this.cgr) && g.dkz().sc(this.mId)) {
            this.def = UBC.getUBCContext().ahx();
        }
    }

    public void Nu(String str) {
        this.lNO = str;
    }

    public String dkD() {
        return this.lNO;
    }
}
