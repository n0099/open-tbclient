package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes13.dex */
class n {
    private String YO;
    private String dpX;
    private int dpY;
    private JSONObject dpZ;
    private String dqa;
    private boolean dqb;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;
    private String mip;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mip = "0";
        this.mId = str;
        this.dpX = str;
        this.dpY = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mip = "0";
        this.mId = str;
        this.dpX = str;
        this.dpY = -1;
        this.dpZ = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mip = "0";
        this.mId = str2;
        this.dpX = str;
        this.dpY = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.dqb = false;
        this.YO = "";
        this.mip = "0";
        this.mId = str2;
        this.dpX = str;
        this.dpY = i;
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

    public String aIs() {
        return this.dpX;
    }

    public int aIt() {
        return this.dpY;
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

    public String aIu() {
        return this.dqa;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aIv() {
        return this.dpZ;
    }

    public void setFileName(String str) {
        this.YO = str;
    }

    public String getFileName() {
        return this.YO;
    }

    public void gn(boolean z) {
        this.dqb = z;
    }

    public boolean aIq() {
        return this.dqb;
    }

    public void aIx() {
        if (this.mId != null && this.mId.equals(this.dpX) && g.dsd().tF(this.mId)) {
            this.dqa = UBC.getUBCContext().akR();
        }
    }

    public void Pi(String str) {
        this.mip = str;
    }

    public String dsh() {
        return this.mip;
    }
}
