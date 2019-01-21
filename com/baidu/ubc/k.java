package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long SG;
    private int ifN;
    private JSONArray ifP;
    private JSONObject igk;
    private int igl;
    private String igm;
    private boolean ign = false;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.ifN = i;
        this.mContent = str2;
        this.igl = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bSB() {
        return this.ifN;
    }

    public void xV(int i) {
        this.ifN = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bSE() {
        return this.igk;
    }

    public long bSH() {
        return this.SG;
    }

    public void ds(long j) {
        this.SG = j;
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

    public void yB(String str) {
        this.mState = str;
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

    public boolean bSy() {
        return this.ign;
    }

    public void oO(boolean z) {
        this.ign = z;
    }

    public void yC(String str) {
        this.igm = str;
    }

    public void bSF() {
        if (e.bSo().ys(this.mId)) {
            this.igm = o.bSQ().ZC();
        }
    }

    public void yD(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ifP = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bSI() {
        return this.ifP;
    }
}
