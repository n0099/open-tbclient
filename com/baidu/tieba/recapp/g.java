package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    public String forumName;
    public int jEU;
    public int jEV;
    public int jEW;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jEU = 0;
        this.jEV = 0;
        this.jEW = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jEU = 0;
        this.jEV = 0;
        this.jEW = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jEU = jSONObject.optInt("loadmore_count");
            this.jEV = jSONObject.optInt("loadmore_count_pb");
            this.jEW = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject GQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jEU);
            jSONObject.put("loadmore_count_pb", this.jEV);
            jSONObject.put("refresh_count_pb", this.jEW);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aj(boolean z, boolean z2) {
        return z2 ? z ? this.jEW : this.jEV : z ? this.refreshCount : this.jEU;
    }

    public void ak(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jEW++;
            } else {
                this.jEV++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jEU++;
        }
    }
}
