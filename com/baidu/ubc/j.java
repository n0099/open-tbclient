package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Ss;
    private int ieF;
    private JSONObject ifc;
    private int ifd;
    private String ife;
    private boolean iff;
    private String mCategory;
    private String mContent;
    private String mFlowId;
    private String mId;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.iff = false;
        this.Ss = "";
        this.mId = str;
        this.mFlowId = str;
        this.ieF = -1;
        this.mContent = str2;
        this.ifd = i;
        if ((this.ifd & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.iff = false;
        this.Ss = "";
        this.mId = str;
        this.mFlowId = str;
        this.ieF = -1;
        this.ifc = jSONObject;
        this.ifd = i;
        if ((this.ifd & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.iff = false;
        this.Ss = "";
        this.mId = str2;
        this.mFlowId = str;
        this.ieF = i;
        this.mContent = str3;
        this.ifd = i2;
        if ((this.ifd & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.iff = false;
        this.Ss = "";
        this.mId = str2;
        this.mFlowId = str;
        this.ieF = i;
        this.mContent = str3;
        this.ifd = i2;
        if ((this.ifd & 2) == 0) {
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

    public String bRS() {
        return this.mFlowId;
    }

    public int bRT() {
        return this.ieF;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getTime() {
        return this.mTime;
    }

    public int bRU() {
        return this.ifd;
    }

    public String bRV() {
        return this.ife;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject bRW() {
        return this.ifc;
    }

    public String getFileName() {
        return this.Ss;
    }

    public void jn(String str) {
        this.Ss = str;
    }

    public boolean bRQ() {
        return this.iff;
    }

    public void oN(boolean z) {
        this.iff = z;
    }

    public void bRX() {
        if (this.mId != null && this.mId.equals(this.mFlowId) && e.bRG().yc(this.mId)) {
            this.ife = o.bSi().Zf();
        }
    }
}
