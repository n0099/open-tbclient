package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Sv;
    private JSONArray hSA;
    private JSONObject hSV;
    private int hSW;
    private String hSX;
    private boolean hSY = false;
    private int hSy;
    private String mCategory;
    private String mContent;
    private long mEndTime;
    private String mId;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.hSy = i;
        this.mContent = str2;
        this.hSW = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int bPy() {
        return this.hSy;
    }

    public void wQ(int i) {
        this.hSy = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject bPB() {
        return this.hSV;
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
        return this.hSW;
    }

    public String bPA() {
        return this.hSX;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean bPv() {
        return this.hSY;
    }

    public void ou(boolean z) {
        this.hSY = z;
    }

    public void xB(String str) {
        this.hSX = str;
    }

    public void bPC() {
        if (e.bPl().xr(this.mId)) {
            this.hSX = o.bPN().XP();
        }
    }

    public void xC(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.hSA = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray bPF() {
        return this.hSA;
    }
}
