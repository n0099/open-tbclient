package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class p {
    private long aaK;
    private int ego;
    private JSONObject egp;
    private String egq;
    private boolean egr = false;
    private JSONArray egt;
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
        this.ego = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.ego = i;
        this.egp = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int bbe() {
        return this.ego;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject bbg() {
        return this.egp;
    }

    public long bbl() {
        return this.aaK;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bbm() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String bbf() {
        return this.egq;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nd(int i) {
        this.ego = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cB(long j) {
        this.aaK = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yK(String str) {
        this.mState = str;
    }

    public void yL(String str) {
        this.egq = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hP(boolean z) {
        this.egr = z;
    }

    public boolean bbb() {
        return this.egr;
    }

    public void bbi() {
        if (g.dZx().yA(this.mId)) {
            this.egq = UBC.getUBCContext().aAz();
        }
    }

    public void yM(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.egt = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bbn() {
        return this.egt;
    }
}
