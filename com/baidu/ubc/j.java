package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Tm;
    private String aGw;
    private int bwQ;
    private JSONObject bwR;
    private String bwS;
    private boolean bwT;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.bwT = false;
        this.Tm = "";
        this.mId = str;
        this.aGw = str;
        this.bwQ = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bwT = false;
        this.Tm = "";
        this.mId = str;
        this.aGw = str;
        this.bwQ = -1;
        this.bwR = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bwT = false;
        this.Tm = "";
        this.mId = str2;
        this.aGw = str;
        this.bwQ = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bwT = false;
        this.Tm = "";
        this.mId = str2;
        this.aGw = str;
        this.bwQ = i;
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

    public String XT() {
        return this.aGw;
    }

    public int XU() {
        return this.bwQ;
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

    public String XV() {
        return this.bwS;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject XW() {
        return this.bwR;
    }

    public String getFileName() {
        return this.Tm;
    }

    public void rZ(String str) {
        this.Tm = str;
    }

    public boolean XR() {
        return this.bwT;
    }

    public void dr(boolean z) {
        this.bwT = z;
    }

    public void XY() {
        if (this.mId != null && this.mId.equals(this.aGw) && e.cEl().kQ(this.mId)) {
            this.bwS = UBC.getUBCContext().Ii();
        }
    }
}
