package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Ss;
    private JSONObject hUF;
    private int hUG;
    private String hUH;
    private boolean hUI;
    private int hUi;
    private String mCategory;
    private String mContent;
    private String mFlowId;
    private String mId;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.hUI = false;
        this.Ss = "";
        this.mId = str;
        this.mFlowId = str;
        this.hUi = -1;
        this.mContent = str2;
        this.hUG = i;
        if ((this.hUG & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.hUI = false;
        this.Ss = "";
        this.mId = str;
        this.mFlowId = str;
        this.hUi = -1;
        this.hUF = jSONObject;
        this.hUG = i;
        if ((this.hUG & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.hUI = false;
        this.Ss = "";
        this.mId = str2;
        this.mFlowId = str;
        this.hUi = i;
        this.mContent = str3;
        this.hUG = i2;
        if ((this.hUG & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.hUI = false;
        this.Ss = "";
        this.mId = str2;
        this.mFlowId = str;
        this.hUi = i;
        this.mContent = str3;
        this.hUG = i2;
        if ((this.hUG & 2) == 0) {
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

    public String bOW() {
        return this.mFlowId;
    }

    public int bOX() {
        return this.hUi;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int bOY() {
        return this.hUG;
    }

    public String bOZ() {
        return this.hUH;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject bPa() {
        return this.hUF;
    }

    public String getFileName() {
        return this.Ss;
    }

    public void iU(String str) {
        this.Ss = str;
    }

    public boolean bOU() {
        return this.hUI;
    }

    public void oI(boolean z) {
        this.hUI = z;
    }

    public void bPb() {
        if (this.mId != null && this.mId.equals(this.mFlowId) && e.bOK().xw(this.mId)) {
            this.hUH = o.bPm().XZ();
        }
    }
}
