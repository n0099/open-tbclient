package com.baidu.ubc;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j {
    private String Vi;
    private String aDu;
    private int bpn;
    private JSONObject bpo;
    private String bpp;
    private boolean bpq;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private long mTime;

    public j(String str, String str2, int i) {
        this.mContent = "";
        this.bpq = false;
        this.Vi = "";
        this.mId = str;
        this.aDu = str;
        this.bpn = -1;
        this.mContent = str2;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, JSONObject jSONObject, int i) {
        this.mContent = "";
        this.bpq = false;
        this.Vi = "";
        this.mId = str;
        this.aDu = str;
        this.bpn = -1;
        this.bpo = jSONObject;
        this.mOption = i;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, int i2) {
        this.mContent = "";
        this.bpq = false;
        this.Vi = "";
        this.mId = str2;
        this.aDu = str;
        this.bpn = i;
        this.mContent = str3;
        this.mOption = i2;
        if ((this.mOption & 2) == 0) {
            this.mTime = System.currentTimeMillis();
        }
    }

    public j(String str, String str2, int i, String str3, long j, int i2) {
        this.mContent = "";
        this.bpq = false;
        this.Vi = "";
        this.mId = str2;
        this.aDu = str;
        this.bpn = i;
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

    public String Tc() {
        return this.aDu;
    }

    public int Td() {
        return this.bpn;
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

    public String Te() {
        return this.bpp;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public JSONObject Tf() {
        return this.bpo;
    }

    public String getFileName() {
        return this.Vi;
    }

    public void qn(String str) {
        this.Vi = str;
    }

    public boolean Ta() {
        return this.bpq;
    }

    public void cV(boolean z) {
        this.bpq = z;
    }

    public void Th() {
        if (this.mId != null && this.mId.equals(this.aDu) && e.crY().jI(this.mId)) {
            this.bpp = UBC.getUBCContext().Fp();
        }
    }
}
