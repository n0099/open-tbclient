package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    public String forumName;
    public int mRF;
    public int mRG;
    public int mRH;
    public int refreshCount;

    public h() {
        this.refreshCount = 0;
        this.mRF = 0;
        this.mRG = 0;
        this.mRH = 0;
    }

    public h(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mRF = 0;
        this.mRG = 0;
        this.mRH = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mRF = jSONObject.optInt("loadmore_count");
            this.mRG = jSONObject.optInt("loadmore_count_pb");
            this.mRH = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ajv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mRF);
            jSONObject.put("loadmore_count_pb", this.mRG);
            jSONObject.put("refresh_count_pb", this.mRH);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ay(boolean z, boolean z2) {
        return z2 ? z ? this.mRH : this.mRG : z ? this.refreshCount : this.mRF;
    }

    public void az(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mRH++;
            } else {
                this.mRG++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mRF++;
        }
    }
}
