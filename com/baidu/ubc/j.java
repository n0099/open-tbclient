package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Sq;
    private JSONObject hSV;
    private int hSW;
    private String hSX;
    private boolean hSY;
    private int hSy;
    private String mCategory;
    private String mContent;
    private String mFlowId;
    private String mId;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.hSY = false;
        this.Sq = "";
        this.mId = str;
        this.mFlowId = str;
        this.hSy = -1;
        this.mContent = str2;
        this.hSW = i;
        if ((this.hSW & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.hSY = false;
        this.Sq = "";
        this.mId = str;
        this.mFlowId = str;
        this.hSy = -1;
        this.hSV = jSONObject;
        this.hSW = i;
        if ((this.hSW & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.hSY = false;
        this.Sq = "";
        this.mId = str2;
        this.mFlowId = str;
        this.hSy = i;
        this.mContent = str3;
        this.hSW = i2;
        if ((this.hSW & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.hSY = false;
        this.Sq = "";
        this.mId = str2;
        this.mFlowId = str;
        this.hSy = i;
        this.mContent = str3;
        this.hSW = i2;
        if ((this.hSW & 2) == 0) {
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

    public String bPx() {
        return this.mFlowId;
    }

    public int bPy() {
        return this.hSy;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int bPz() {
        return this.hSW;
    }

    public String bPA() {
        return this.hSX;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject bPB() {
        return this.hSV;
    }

    public String getFileName() {
        return this.Sq;
    }

    public void iS(String str) {
        this.Sq = str;
    }

    public boolean bPv() {
        return this.hSY;
    }

    public void ou(boolean z) {
        this.hSY = z;
    }

    public void bPC() {
        if (this.mId != null && this.mId.equals(this.mFlowId) && e.bPl().xr(this.mId)) {
            this.hSX = o.bPN().XP();
        }
    }
}
