package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class p {
    private long aaa;
    private int dJM;
    private JSONObject dJN;
    private String dJO;
    private boolean dJP = false;
    private JSONArray dJR;
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
        this.dJM = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.dJM = i;
        this.dJN = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int aVR() {
        return this.dJM;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aVT() {
        return this.dJN;
    }

    public long aVY() {
        return this.aaa;
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
        return this.dJO;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void mk(int i) {
        this.dJM = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void cq(long j) {
        this.aaa = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void xm(String str) {
        this.mState = str;
    }

    public void xn(String str) {
        this.dJO = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void hi(boolean z) {
        this.dJP = z;
    }

    public boolean aVO() {
        return this.dJP;
    }

    public void aVV() {
        if (g.dLW().xc(this.mId)) {
            this.dJO = UBC.getUBCContext().avl();
        }
    }

    public void xo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dJR = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aWa() {
        return this.dJR;
    }
}
