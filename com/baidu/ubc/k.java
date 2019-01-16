package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long SG;
    private int ifM;
    private JSONArray ifO;
    private JSONObject igj;
    private int igk;
    private String igl;
    private boolean igm = false;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.ifM = i;
        this.mContent = str2;
        this.igk = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bSB() {
        return this.ifM;
    }

    public void xV(int i) {
        this.ifM = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bSE() {
        return this.igj;
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
        return this.igk;
    }

    public String bSD() {
        return this.igl;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean bSy() {
        return this.igm;
    }

    public void oO(boolean z) {
        this.igm = z;
    }

    public void yC(String str) {
        this.igl = str;
    }

    public void bSF() {
        if (e.bSo().ys(this.mId)) {
            this.igl = o.bSQ().ZC();
        }
    }

    public void yD(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ifO = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bSI() {
        return this.ifO;
    }
}
