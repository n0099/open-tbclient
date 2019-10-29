package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long CJ;
    private boolean bPA = false;
    private JSONArray bPD;
    private int bPx;
    private JSONObject bPy;
    private String bPz;
    private long baF;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bPx = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public k(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.bPx = i;
        this.bPy = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int acJ() {
        return this.bPx;
    }

    public void gY(int i) {
        this.bPx = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject acL() {
        return this.bPy;
    }

    public long acP() {
        return this.CJ;
    }

    public void aB(long j) {
        this.CJ = j;
    }

    public long getEndTime() {
        return this.baF;
    }

    public void setEndTime(long j) {
        this.baF = j;
    }

    public String acQ() {
        return this.mState;
    }

    public void lz(String str) {
        this.mState = str;
    }

    public int getOption() {
        return this.mOption;
    }

    public String acK() {
        return this.bPz;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean acG() {
        return this.bPA;
    }

    public void dI(boolean z) {
        this.bPA = z;
    }

    public void lA(String str) {
        this.bPz = str;
    }

    public void acN() {
        if (e.cAV().ls(this.mId)) {
            this.bPz = UBC.getUBCContext().Nc();
        }
    }

    public void lB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bPD = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray acR() {
        return this.bPD;
    }
}
