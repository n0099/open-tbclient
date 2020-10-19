package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes19.dex */
class n {
    private String aaE;
    private String dXQ;
    private int dXR;
    private JSONObject dXS;
    private String dXT;
    private boolean dXU;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String nFa;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.nFa = "0";
        this.mId = str;
        this.dXQ = str;
        this.dXR = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.nFa = "0";
        this.mId = str;
        this.dXQ = str;
        this.dXR = -1;
        this.dXS = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.nFa = "0";
        this.mId = str2;
        this.dXQ = str;
        this.dXR = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dXU = false;
        this.aaE = "";
        this.nFa = "0";
        this.mId = str2;
        this.dXQ = str;
        this.dXR = i;
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

    public String aZk() {
        return this.dXQ;
    }

    public int aZl() {
        return this.dXR;
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

    public String aZm() {
        return this.dXT;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aZn() {
        return this.dXS;
    }

    public void setFileName(String str) {
        this.aaE = str;
    }

    public String getFileName() {
        return this.aaE;
    }

    public void hC(boolean z) {
        this.dXU = z;
    }

    public boolean aZi() {
        return this.dXU;
    }

    public void aZp() {
        if (this.mId != null && this.mId.equals(this.dXQ) && g.dTF().yh(this.mId)) {
            this.dXT = UBC.getUBCContext().ayF();
        }
    }

    public void UU(String str) {
        this.nFa = str;
    }

    public String dTJ() {
        return this.nFa;
    }
}
