package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class p {
    private long acA;
    private int eBl;
    private JSONObject eBm;
    private String eBn;
    private boolean eBo = false;
    private JSONArray eBq;
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
        this.eBl = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.eBl = i;
        this.eBm = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int biA() {
        return this.eBl;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject biC() {
        return this.eBm;
    }

    public long biH() {
        return this.acA;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String biI() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String biB() {
        return this.eBn;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void nQ(int i) {
        this.eBl = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void dw(long j) {
        this.acA = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void zz(String str) {
        this.mState = str;
    }

    public void zA(String str) {
        this.eBn = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void iL(boolean z) {
        this.eBo = z;
    }

    public boolean bix() {
        return this.eBo;
    }

    public void biE() {
        if (g.eiX().zp(this.mId)) {
            this.eBn = UBC.getUBCContext().aGV();
        }
    }

    public void zB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.eBq = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray biJ() {
        return this.eBq;
    }
}
