package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes19.dex */
public class p {
    private long aaJ;
    private int dXR;
    private JSONObject dXS;
    private String dXT;
    private boolean dXU = false;
    private JSONArray dXW;
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
        this.dXR = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.dXR = i;
        this.dXS = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int aZl() {
        return this.dXR;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aZn() {
        return this.dXS;
    }

    public long aZs() {
        return this.aaJ;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aZt() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aZm() {
        return this.dXT;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mS(int i) {
        this.dXR = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cz(long j) {
        this.aaJ = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void yr(String str) {
        this.mState = str;
    }

    public void ys(String str) {
        this.dXT = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hC(boolean z) {
        this.dXU = z;
    }

    public boolean aZi() {
        return this.dXU;
    }

    public void aZp() {
        if (g.dTF().yh(this.mId)) {
            this.dXT = UBC.getUBCContext().ayF();
        }
    }

    public void yt(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dXW = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aZu() {
        return this.dXW;
    }
}
