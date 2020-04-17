package com.baidu.ubc;

import org.json.JSONObject;
/* loaded from: classes13.dex */
class n {
    private String Yw;
    private String cgl;
    private int ddY;
    private JSONObject ddZ;
    private String dea;
    private boolean deb;
    private String lNK;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public n(String str, String str2, int i) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.lNK = "0";
        this.mId = str;
        this.cgl = str;
        this.ddY = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.lNK = "0";
        this.mId = str;
        this.cgl = str;
        this.ddY = -1;
        this.ddZ = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.lNK = "0";
        this.mId = str2;
        this.cgl = str;
        this.ddY = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public n(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.deb = false;
        this.Yw = "";
        this.lNK = "0";
        this.mId = str2;
        this.cgl = str;
        this.ddY = i;
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

    public String ahG() {
        return this.cgl;
    }

    public int aDJ() {
        return this.ddY;
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
        return this.dea;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public JSONObject aDL() {
        return this.ddZ;
    }

    public void setFileName(String str) {
        this.Yw = str;
    }

    public String getFileName() {
        return this.Yw;
    }

    public void gc(boolean z) {
        this.deb = z;
    }

    public boolean aDH() {
        return this.deb;
    }

    public void aDN() {
        if (this.mId != null && this.mId.equals(this.cgl) && g.dkB().sc(this.mId)) {
            this.dea = UBC.getUBCContext().ahy();
        }
    }

    public void Nr(String str) {
        this.lNK = str;
    }

    public String dkF() {
        return this.lNK;
    }
}
