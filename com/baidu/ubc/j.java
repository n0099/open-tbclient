package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Tn;
    private String aFY;
    private int bws;
    private JSONObject bwt;
    private String bwu;
    private boolean bwv;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.bwv = false;
        this.Tn = "";
        this.mId = str;
        this.aFY = str;
        this.bws = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bwv = false;
        this.Tn = "";
        this.mId = str;
        this.aFY = str;
        this.bws = -1;
        this.bwt = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bwv = false;
        this.Tn = "";
        this.mId = str2;
        this.aFY = str;
        this.bws = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bwv = false;
        this.Tn = "";
        this.mId = str2;
        this.aFY = str;
        this.bws = i;
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

    public String XP() {
        return this.aFY;
    }

    public int XQ() {
        return this.bws;
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

    public String XR() {
        return this.bwu;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject XS() {
        return this.bwt;
    }

    public String getFileName() {
        return this.Tn;
    }

    public void rO(String str) {
        this.Tn = str;
    }

    public boolean XN() {
        return this.bwv;
    }

    public void dr(boolean z) {
        this.bwv = z;
    }

    public void XU() {
        if (this.mId != null && this.mId.equals(this.aFY) && e.cDc().kO(this.mId)) {
            this.bwu = UBC.getUBCContext().Ie();
        }
    }
}
