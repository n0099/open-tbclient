package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes13.dex */
public class p {
    private long YB;
    private int ddY;
    private JSONObject ddZ;
    private String dea;
    private boolean deb = false;
    private JSONArray ded;
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
        this.ddY = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public p(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.ddY = i;
        this.ddZ = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public int aDJ() {
        return this.ddY;
    }

    public String getContent() {
        return this.mContent;
    }

    public JSONObject aDL() {
        return this.ddZ;
    }

    public long aDQ() {
        return this.YB;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String aDR() {
        return this.mState;
    }

    public int getOption() {
        return this.mOption;
    }

    public String aDK() {
        return this.dea;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void jf(int i) {
        this.ddY = i;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void bR(long j) {
        this.YB = j;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void sj(String str) {
        this.mState = str;
    }

    public void sk(String str) {
        this.dea = str;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void gc(boolean z) {
        this.deb = z;
    }

    public boolean aDH() {
        return this.deb;
    }

    public void aDN() {
        if (g.dkB().sc(this.mId)) {
            this.dea = UBC.getUBCContext().ahy();
        }
    }

    public void sl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.ded = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray aDS() {
        return this.ded;
    }
}
