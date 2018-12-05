package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Sx;
    private JSONObject ibP;
    private int ibQ;
    private String ibR;
    private boolean ibS = false;
    private int ibs;
    private JSONArray ibu;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.ibs = i;
        this.mContent = str2;
        this.ibQ = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bRd() {
        return this.ibs;
    }

    public void xG(int i) {
        this.ibs = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bRg() {
        return this.ibP;
    }

    public long bRj() {
        return this.Sx;
    }

    public void dn(long j) {
        this.Sx = j;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public String getState() {
        return this.mState;
    }

    public void yi(String str) {
        this.mState = str;
    }

    public int bRe() {
        return this.ibQ;
    }

    public String bRf() {
        return this.ibR;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean bRa() {
        return this.ibS;
    }

    public void oK(boolean z) {
        this.ibS = z;
    }

    public void yj(String str) {
        this.ibR = str;
    }

    public void bRh() {
        if (e.bQQ().xZ(this.mId)) {
            this.ibR = o.bRs().Zd();
        }
    }

    public void yk(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ibu = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bRk() {
        return this.ibu;
    }
}
