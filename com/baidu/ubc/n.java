package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes5.dex */
class n {
    private String acm;
    private String eyE;
    private int eyF;
    private JSONObject eyG;
    private String eyH;
    private boolean eyI;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String oTD;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.eyI = false;
        this.acm = "";
        this.oTD = "0";
        this.mId = str;
        this.eyE = str;
        this.eyF = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.eyI = false;
        this.acm = "";
        this.oTD = "0";
        this.mId = str;
        this.eyE = str;
        this.eyF = -1;
        this.eyG = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.eyI = false;
        this.acm = "";
        this.oTD = "0";
        this.mId = str2;
        this.eyE = str;
        this.eyF = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.eyI = false;
        this.acm = "";
        this.oTD = "0";
        this.mId = str2;
        this.eyE = str;
        this.eyF = i;
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

    public String beS() {
        return this.eyE;
    }

    public int beT() {
        return this.eyF;
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

    public String beU() {
        return this.eyH;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject beV() {
        return this.eyG;
    }

    public void setFileName(String str) {
        this.acm = str;
    }

    public String getFileName() {
        return this.acm;
    }

    public void iJ(boolean z) {
        this.eyI = z;
    }

    public boolean beQ() {
        return this.eyI;
    }

    public void beX() {
        if (this.mId != null && this.mId.equals(this.eyE) && g.ehF().yx(this.mId)) {
            this.eyH = UBC.getUBCContext().aDx();
        }
    }

    public void Xy(String str) {
        this.oTD = str;
    }

    public String ehL() {
        return this.oTD;
    }
}
