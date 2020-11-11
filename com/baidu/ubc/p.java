package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class p {
    private long aaK;
    private int emf;
    private JSONObject emg;
    private String emh;
    private boolean emi = false;
    private JSONArray emk;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private int mOption;
    private String mState;

    public p() {
    }

    public p(String str, int i, String str2, int i2) {
        this.mId = str;
        this.emf = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.emf = i;
        this.emg = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int bdE() {
        return this.emf;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject bdG() {
        return this.emg;
    }

    public long bdL() {
        return this.aaK;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bdM() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String bdF() {
        return this.emh;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nn(int i) {
        this.emf = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cX(long j) {
        this.aaK = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yY(String str) {
        this.mState = str;
    }

    public void yZ(String str) {
        this.emh = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hY(boolean z) {
        this.emi = z;
    }

    public boolean bdB() {
        return this.emi;
    }

    public void bdI() {
        if (g.edf().yO(this.mId)) {
            this.emh = UBC.getUBCContext().aCZ();
        }
    }

    public void za(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.emk = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bdN() {
        return this.emk;
    }
}
