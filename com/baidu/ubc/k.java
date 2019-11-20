package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Cj;
    private int bOG;
    private JSONObject bOH;
    private String bOI;
    private boolean bOJ = false;
    private JSONArray bOM;
    private long ban;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bOG = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public k(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.bOG = i;
        this.bOH = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int acH() {
        return this.bOG;
    }

    public void gX(int i) {
        this.bOG = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject acJ() {
        return this.bOH;
    }

    public long acN() {
        return this.Cj;
    }

    public void aA(long j) {
        this.Cj = j;
    }

    public long getEndTime() {
        return this.ban;
    }

    public void setEndTime(long j) {
        this.ban = j;
    }

    public String acO() {
        return this.mState;
    }

    public void lz(String str) {
        this.mState = str;
    }

    public int getOption() {
        return this.mOption;
    }

    public String acI() {
        return this.bOI;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean acE() {
        return this.bOJ;
    }

    public void dI(boolean z) {
        this.bOJ = z;
    }

    public void lA(String str) {
        this.bOI = str;
    }

    public void acL() {
        if (e.cAT().ls(this.mId)) {
            this.bOI = UBC.getUBCContext().Nd();
        }
    }

    public void lB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bOM = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray acP() {
        return this.bOM;
    }
}
