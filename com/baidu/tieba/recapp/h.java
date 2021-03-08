package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {
    public String forumName;
    public int mTL;
    public int mTM;
    public int mTN;
    public int refreshCount;

    public h() {
        this.refreshCount = 0;
        this.mTL = 0;
        this.mTM = 0;
        this.mTN = 0;
    }

    public h(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mTL = 0;
        this.mTM = 0;
        this.mTN = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mTL = jSONObject.optInt("loadmore_count");
            this.mTM = jSONObject.optInt("loadmore_count_pb");
            this.mTN = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ajy() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mTL);
            jSONObject.put("loadmore_count_pb", this.mTM);
            jSONObject.put("refresh_count_pb", this.mTN);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ay(boolean z, boolean z2) {
        return z2 ? z ? this.mTN : this.mTM : z ? this.refreshCount : this.mTL;
    }

    public void az(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mTN++;
            } else {
                this.mTM++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mTL++;
        }
    }
}
