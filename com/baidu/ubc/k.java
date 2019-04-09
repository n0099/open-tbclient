package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Vo;
    private long aEt;
    private int bpr;
    private JSONObject bps;
    private String bpt;
    private boolean bpu = false;
    private JSONArray bpw;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bpr = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public k(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.bpr = i;
        this.bps = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int Tb() {
        return this.bpr;
    }

    public void fp(int i) {
        this.bpr = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject Td() {
        return this.bps;
    }

    public long Tg() {
        return this.Vo;
    }

    public void X(long j) {
        this.Vo = j;
    }

    public long getEndTime() {
        return this.aEt;
    }

    public void setEndTime(long j) {
        this.aEt = j;
    }

    public String getState() {
        return this.mState;
    }

    public void jP(String str) {
        this.mState = str;
    }

    public int getOption() {
        return this.mOption;
    }

    public String Tc() {
        return this.bpt;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean SY() {
        return this.bpu;
    }

    public void cV(boolean z) {
        this.bpu = z;
    }

    public void jQ(String str) {
        this.bpt = str;
    }

    public void Tf() {
        if (e.crW().jJ(this.mId)) {
            this.bpt = UBC.getUBCContext().Fn();
        }
    }

    public void jR(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bpw = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Th() {
        return this.bpw;
    }
}
