package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class g {
    public String forumName;
    public int jFQ;
    public int jFR;
    public int jFS;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jFQ = 0;
        this.jFR = 0;
        this.jFS = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jFQ = 0;
        this.jFR = 0;
        this.jFS = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jFQ = jSONObject.optInt("loadmore_count");
            this.jFR = jSONObject.optInt("loadmore_count_pb");
            this.jFS = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Jf() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jFQ);
            jSONObject.put("loadmore_count_pb", this.jFR);
            jSONObject.put("refresh_count_pb", this.jFS);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int al(boolean z, boolean z2) {
        return z2 ? z ? this.jFS : this.jFR : z ? this.refreshCount : this.jFQ;
    }

    public void am(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jFS++;
            } else {
                this.jFR++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jFQ++;
        }
    }
}
