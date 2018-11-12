package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Sx;
    private JSONObject hUF;
    private int hUG;
    private String hUH;
    private boolean hUI = false;
    private int hUi;
    private JSONArray hUk;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.hUi = i;
        this.mContent = str2;
        this.hUG = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bOX() {
        return this.hUi;
    }

    public void xj(int i) {
        this.hUi = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bPa() {
        return this.hUF;
    }

    public long bPd() {
        return this.Sx;
    }

    public void dg(long j) {
        this.Sx = j;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public String getState() {
        return this.mState;
    }

    public void xF(String str) {
        this.mState = str;
    }

    public int bOY() {
        return this.hUG;
    }

    public String bOZ() {
        return this.hUH;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean bOU() {
        return this.hUI;
    }

    public void oI(boolean z) {
        this.hUI = z;
    }

    public void xG(String str) {
        this.hUH = str;
    }

    public void bPb() {
        if (e.bOK().xw(this.mId)) {
            this.hUH = o.bPm().XZ();
        }
    }

    public void xH(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hUk = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bPe() {
        return this.hUk;
    }
}
