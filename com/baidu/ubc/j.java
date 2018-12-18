package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Ss;
    private JSONObject ibP;
    private int ibQ;
    private String ibR;
    private boolean ibS;
    private int ibs;
    private String mCategory;
    private String mContent;
    private String mFlowId;
    private String mId;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.ibS = false;
        this.Ss = "";
        this.mId = str;
        this.mFlowId = str;
        this.ibs = -1;
        this.mContent = str2;
        this.ibQ = i;
        if ((this.ibQ & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.ibS = false;
        this.Ss = "";
        this.mId = str;
        this.mFlowId = str;
        this.ibs = -1;
        this.ibP = jSONObject;
        this.ibQ = i;
        if ((this.ibQ & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.ibS = false;
        this.Ss = "";
        this.mId = str2;
        this.mFlowId = str;
        this.ibs = i;
        this.mContent = str3;
        this.ibQ = i2;
        if ((this.ibQ & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.ibS = false;
        this.Ss = "";
        this.mId = str2;
        this.mFlowId = str;
        this.ibs = i;
        this.mContent = str3;
        this.ibQ = i2;
        if ((this.ibQ & 2) == 0) {
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

    public String bRb() {
        return this.mFlowId;
    }

    public int bRc() {
        return this.ibs;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int bRd() {
        return this.ibQ;
    }

    public String bRe() {
        return this.ibR;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject bRf() {
        return this.ibP;
    }

    public String getFileName() {
        return this.Ss;
    }

    public void jm(String str) {
        this.Ss = str;
    }

    public boolean bQZ() {
        return this.ibS;
    }

    public void oK(boolean z) {
        this.ibS = z;
    }

    public void bRg() {
        if (this.mId != null && this.mId.equals(this.mFlowId) && e.bQP().xZ(this.mId)) {
            this.ibR = o.bRr().Zd();
        }
    }
}
