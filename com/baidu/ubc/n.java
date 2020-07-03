package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes13.dex */
class n {
    private String Zt;
    private String duJ;
    private int duK;
    private JSONObject duL;
    private String duM;
    private boolean duN;
    private String mCategory;
    private String mContent;
    private String mEi;
    private String mId;
    private int mOption;
    private long mTime;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mEi = "0";
        this.mId = str;
        this.duJ = str;
        this.duK = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mEi = "0";
        this.mId = str;
        this.duJ = str;
        this.duK = -1;
        this.duL = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mEi = "0";
        this.mId = str2;
        this.duJ = str;
        this.duK = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.duN = false;
        this.Zt = "";
        this.mEi = "0";
        this.mId = str2;
        this.duJ = str;
        this.duK = i;
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

    public String aJy() {
        return this.duJ;
    }

    public int aJz() {
        return this.duK;
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

    public String aJA() {
        return this.duM;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aJB() {
        return this.duL;
    }

    public void setFileName(String str) {
        this.Zt = str;
    }

    public String getFileName() {
        return this.Zt;
    }

    public void gs(boolean z) {
        this.duN = z;
    }

    public boolean aJw() {
        return this.duN;
    }

    public void aJD() {
        if (this.mId != null && this.mId.equals(this.duJ) && g.dwI().tN(this.mId)) {
            this.duM = UBC.getUBCContext().alX();
        }
    }

    public void PU(String str) {
        this.mEi = str;
    }

    public String dwM() {
        return this.mEi;
    }
}
