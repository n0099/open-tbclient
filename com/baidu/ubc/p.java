package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class p {
    private long YT;
    private int dpY;
    private JSONObject dpZ;
    private String dqa;
    private boolean dqb = false;
    private JSONArray dqd;
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
        this.dpY = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.dpY = i;
        this.dpZ = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int aIt() {
        return this.dpY;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aIv() {
        return this.dpZ;
    }

    public long aIA() {
        return this.YT;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aIB() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aIu() {
        return this.dqa;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void jy(int i) {
        this.dpY = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bR(long j) {
        this.YT = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void tP(String str) {
        this.mState = str;
    }

    public void tQ(String str) {
        this.dqa = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void gn(boolean z) {
        this.dqb = z;
    }

    public boolean aIq() {
        return this.dqb;
    }

    public void aIx() {
        if (g.drP().tF(this.mId)) {
            this.dqa = UBC.getUBCContext().akR();
        }
    }

    public void tR(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dqd = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aIC() {
        return this.dqd;
    }
}
