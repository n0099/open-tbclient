package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String SV;
    private String aFq;
    private int bvC;
    private JSONObject bvD;
    private String bvE;
    private boolean bvF;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.bvF = false;
        this.SV = "";
        this.mId = str;
        this.aFq = str;
        this.bvC = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bvF = false;
        this.SV = "";
        this.mId = str;
        this.aFq = str;
        this.bvC = -1;
        this.bvD = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bvF = false;
        this.SV = "";
        this.mId = str2;
        this.aFq = str;
        this.bvC = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bvF = false;
        this.SV = "";
        this.mId = str2;
        this.aFq = str;
        this.bvC = i;
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

    public String WU() {
        return this.aFq;
    }

    public int WV() {
        return this.bvC;
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

    public String WW() {
        return this.bvE;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject WX() {
        return this.bvD;
    }

    public String getFileName() {
        return this.SV;
    }

    public void rw(String str) {
        this.SV = str;
    }

    public boolean WS() {
        return this.bvF;
    }

    public void dm(boolean z) {
        this.bvF = z;
    }

    public void WZ() {
        if (this.mId != null && this.mId.equals(this.aFq) && e.cAe().kG(this.mId)) {
            this.bvE = UBC.getUBCContext().Hs();
        }
    }
}
