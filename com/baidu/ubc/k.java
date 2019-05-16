package com.baidu.ubc;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k {
    private long Tb;
    private long aGl;
    private int bvC;
    private JSONObject bvD;
    private String bvE;
    private boolean bvF = false;
    private JSONArray bvI;
    private String mCategory;
    private String mContent;
    private String mId;
    private int mOption;
    private String mState;

    public k() {
    }

    public k(String str, int i, String str2, int i2) {
        this.mId = str;
        this.bvC = i;
        this.mContent = str2;
        this.mOption = i2;
    }

    public k(String str, int i, JSONObject jSONObject, int i2) {
        this.mId = str;
        this.bvC = i;
        this.bvD = jSONObject;
        this.mOption = i2;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public int WV() {
        return this.bvC;
    }

    public void fY(int i) {
        this.bvC = i;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public JSONObject WX() {
        return this.bvD;
    }

    public long Xb() {
        return this.Tb;
    }

    public void ah(long j) {
        this.Tb = j;
    }

    public long getEndTime() {
        return this.aGl;
    }

    public void setEndTime(long j) {
        this.aGl = j;
    }

    public String getState() {
        return this.mState;
    }

    public void kO(String str) {
        this.mState = str;
    }

    public int getOption() {
        return this.mOption;
    }

    public String WW() {
        return this.bvE;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public boolean WS() {
        return this.bvF;
    }

    public void dm(boolean z) {
        this.bvF = z;
    }

    public void kP(String str) {
        this.bvE = str;
    }

    public void WZ() {
        if (e.cAd().kH(this.mId)) {
            this.bvE = UBC.getUBCContext().Hs();
        }
    }

    public void kQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.bvI = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONArray Xc() {
        return this.bvI;
    }
}
