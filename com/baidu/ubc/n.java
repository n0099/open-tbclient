package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes6.dex */
class n {
    private String acu;
    private String eBk;
    private int eBl;
    private JSONObject eBm;
    private String eBn;
    private boolean eBo;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String oNz;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.oNz = "0";
        this.mId = str;
        this.eBk = str;
        this.eBl = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.oNz = "0";
        this.mId = str;
        this.eBk = str;
        this.eBl = -1;
        this.eBm = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.oNz = "0";
        this.mId = str2;
        this.eBk = str;
        this.eBl = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.eBo = false;
        this.acu = "";
        this.oNz = "0";
        this.mId = str2;
        this.eBk = str;
        this.eBl = i;
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

    public String biz() {
        return this.eBk;
    }

    public int biA() {
        return this.eBl;
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

    public String biB() {
        return this.eBn;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject biC() {
        return this.eBm;
    }

    public void setFileName(String str) {
        this.acu = str;
    }

    public String getFileName() {
        return this.acu;
    }

    public void iL(boolean z) {
        this.eBo = z;
    }

    public boolean bix() {
        return this.eBo;
    }

    public void biE() {
        if (this.mId != null && this.mId.equals(this.eBk) && g.eiX().zp(this.mId)) {
            this.eBn = UBC.getUBCContext().aGV();
        }
    }

    public void Xu(String str) {
        this.oNz = str;
    }

    public String ejd() {
        return this.oNz;
    }
}
