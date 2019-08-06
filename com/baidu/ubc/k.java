package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Ts;
    private long aGT;
    private int bws;
    private JSONObject bwt;
    private String bwu;
    private boolean bwv = false;
    private JSONArray bwy;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bws = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public k(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.bws = i;
        this.bwt = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int XQ() {
        return this.bws;
    }

    public void gc(int i) {
        this.bws = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject XS() {
        return this.bwt;
    }

    public long getBeginTime() {
        return this.Ts;
    }

    public void ai(long j) {
        this.Ts = j;
    }

    public long getEndTime() {
        return this.aGT;
    }

    public void setEndTime(long j) {
        this.aGT = j;
    }

    public String XW() {
        return this.mState;
    }

    public void kV(String str) {
        this.mState = str;
    }

    public int getOption() {
        return this.mOption;
    }

    public String XR() {
        return this.bwu;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean XN() {
        return this.bwv;
    }

    public void dr(boolean z) {
        this.bwv = z;
    }

    public void kW(String str) {
        this.bwu = str;
    }

    public void XU() {
        if (e.cDx().kO(this.mId)) {
            this.bwu = UBC.getUBCContext().Ie();
        }
    }

    public void kX(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bwy = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray XX() {
        return this.bwy;
    }
}
