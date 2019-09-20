package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Tr;
    private long aHr;
    private int bwQ;
    private JSONObject bwR;
    private String bwS;
    private boolean bwT = false;
    private JSONArray bwW;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bwQ = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public k(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.bwQ = i;
        this.bwR = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int XU() {
        return this.bwQ;
    }

    public void gd(int i) {
        this.bwQ = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject XW() {
        return this.bwR;
    }

    public long getBeginTime() {
        return this.Tr;
    }

    public void ai(long j) {
        this.Tr = j;
    }

    public long getEndTime() {
        return this.aHr;
    }

    public void setEndTime(long j) {
        this.aHr = j;
    }

    public String Ya() {
        return this.mState;
    }

    public void kX(String str) {
        this.mState = str;
    }

    public int getOption() {
        return this.mOption;
    }

    public String XV() {
        return this.bwS;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean XR() {
        return this.bwT;
    }

    public void dr(boolean z) {
        this.bwT = z;
    }

    public void kY(String str) {
        this.bwS = str;
    }

    public void XY() {
        if (e.cEl().kQ(this.mId)) {
            this.bwS = UBC.getUBCContext().Ii();
        }
    }

    public void kZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bwW = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Yb() {
        return this.bwW;
    }
}
