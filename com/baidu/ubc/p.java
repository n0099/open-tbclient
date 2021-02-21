package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class p {
    private long acr;
    private int eyF;
    private JSONObject eyG;
    private String eyH;
    private boolean eyI = false;
    private JSONArray eyK;
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
        this.eyF = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.eyF = i;
        this.eyG = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int beT() {
        return this.eyF;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject beV() {
        return this.eyG;
    }

    public long bfa() {
        return this.acr;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String bfb() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String beU() {
        return this.eyH;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mn(int i) {
        this.eyF = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void dC(long j) {
        this.acr = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yH(String str) {
        this.mState = str;
    }

    public void yI(String str) {
        this.eyH = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void iJ(boolean z) {
        this.eyI = z;
    }

    public boolean beQ() {
        return this.eyI;
    }

    public void beX() {
        if (g.ehF().yx(this.mId)) {
            this.eyH = UBC.getUBCContext().aDx();
        }
    }

    public void yJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.eyK = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bfc() {
        return this.eyK;
    }
}
