package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String SB;
    private int ifN;
    private JSONObject igk;
    private int igl;
    private String igm;
    private boolean ign;
    private String mCategory;
    private String mContent;
    private String mFlowId;
    private String mId;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.ign = false;
        this.SB = "";
        this.mId = str;
        this.mFlowId = str;
        this.ifN = -1;
        this.mContent = str2;
        this.igl = i;
        if ((this.igl & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.ign = false;
        this.SB = "";
        this.mId = str;
        this.mFlowId = str;
        this.ifN = -1;
        this.igk = jSONObject;
        this.igl = i;
        if ((this.igl & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.ign = false;
        this.SB = "";
        this.mId = str2;
        this.mFlowId = str;
        this.ifN = i;
        this.mContent = str3;
        this.igl = i2;
        if ((this.igl & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.ign = false;
        this.SB = "";
        this.mId = str2;
        this.mFlowId = str;
        this.ifN = i;
        this.mContent = str3;
        this.igl = i2;
        if ((this.igl & 2) == 0) {
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

    public String bSA() {
        return this.mFlowId;
    }

    public int bSB() {
        return this.ifN;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int bSC() {
        return this.igl;
    }

    public String bSD() {
        return this.igm;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject bSE() {
        return this.igk;
    }

    public String getFileName() {
        return this.SB;
    }

    public void jD(String str) {
        this.SB = str;
    }

    public boolean bSy() {
        return this.ign;
    }

    public void oO(boolean z) {
        this.ign = z;
    }

    public void bSF() {
        if (this.mId != null && this.mId.equals(this.mFlowId) && e.bSo().ys(this.mId)) {
            this.igm = o.bSQ().ZC();
        }
    }
}
