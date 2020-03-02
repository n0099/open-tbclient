package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class g {
    public String forumName;
    public int jFS;
    public int jFT;
    public int jFU;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jFS = 0;
        this.jFT = 0;
        this.jFU = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jFS = 0;
        this.jFT = 0;
        this.jFU = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jFS = jSONObject.optInt("loadmore_count");
            this.jFT = jSONObject.optInt("loadmore_count_pb");
            this.jFU = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Jh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jFS);
            jSONObject.put("loadmore_count_pb", this.jFT);
            jSONObject.put("refresh_count_pb", this.jFU);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int al(boolean z, boolean z2) {
        return z2 ? z ? this.jFU : this.jFT : z ? this.refreshCount : this.jFS;
    }

    public void am(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jFU++;
            } else {
                this.jFT++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jFS++;
        }
    }
}
