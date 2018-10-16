package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Sv;
    private JSONObject hSU;
    private int hSV;
    private String hSW;
    private boolean hSX = false;
    private int hSx;
    private JSONArray hSz;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.hSx = i;
        this.mContent = str2;
        this.hSV = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bPy() {
        return this.hSx;
    }

    public void wQ(int i) {
        this.hSx = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bPB() {
        return this.hSU;
    }

    public long bPE() {
        return this.Sv;
    }

    public void dl(long j) {
        this.Sv = j;
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

    public void xA(String str) {
        this.mState = str;
    }

    public int bPz() {
        return this.hSV;
    }

    public String bPA() {
        return this.hSW;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean bPv() {
        return this.hSX;
    }

    public void ou(boolean z) {
        this.hSX = z;
    }

    public void xB(String str) {
        this.hSW = str;
    }

    public void bPC() {
        if (e.bPl().xr(this.mId)) {
            this.hSW = o.bPN().XO();
        }
    }

    public void xC(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hSz = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bPF() {
        return this.hSz;
    }
}
