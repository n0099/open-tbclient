package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    public String forumName;
    public int jBs;
    public int jBt;
    public int jBu;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jBs = 0;
        this.jBt = 0;
        this.jBu = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jBs = 0;
        this.jBt = 0;
        this.jBu = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jBs = jSONObject.optInt("loadmore_count");
            this.jBt = jSONObject.optInt("loadmore_count_pb");
            this.jBu = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Gu() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jBs);
            jSONObject.put("loadmore_count_pb", this.jBt);
            jSONObject.put("refresh_count_pb", this.jBu);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aj(boolean z, boolean z2) {
        return z2 ? z ? this.jBu : this.jBt : z ? this.refreshCount : this.jBs;
    }

    public void ak(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jBu++;
            } else {
                this.jBt++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jBs++;
        }
    }
}
