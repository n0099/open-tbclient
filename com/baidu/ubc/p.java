package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class p {
    private long ZY;
    private int dJI;
    private JSONObject dJJ;
    private String dJK;
    private boolean dJL = false;
    private JSONArray dJN;
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
        this.dJI = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.dJI = i;
        this.dJJ = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int aVR() {
        return this.dJI;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aVT() {
        return this.dJJ;
    }

    public long aVY() {
        return this.ZY;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aVZ() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aVS() {
        return this.dJK;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mk(int i) {
        this.dJI = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cq(long j) {
        this.ZY = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void xl(String str) {
        this.mState = str;
    }

    public void xm(String str) {
        this.dJK = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hh(boolean z) {
        this.dJL = z;
    }

    public boolean aVO() {
        return this.dJL;
    }

    public void aVV() {
        if (g.dLN().xb(this.mId)) {
            this.dJK = UBC.getUBCContext().avl();
        }
    }

    public void xn(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dJN = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aWa() {
        return this.dJN;
    }
}
