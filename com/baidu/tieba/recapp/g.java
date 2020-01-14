package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g {
    public String forumName;
    public int jEZ;
    public int jFa;
    public int jFb;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jEZ = 0;
        this.jFa = 0;
        this.jFb = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jEZ = 0;
        this.jFa = 0;
        this.jFb = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jEZ = jSONObject.optInt("loadmore_count");
            this.jFa = jSONObject.optInt("loadmore_count_pb");
            this.jFb = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject GQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jEZ);
            jSONObject.put("loadmore_count_pb", this.jFa);
            jSONObject.put("refresh_count_pb", this.jFb);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aj(boolean z, boolean z2) {
        return z2 ? z ? this.jFb : this.jFa : z ? this.refreshCount : this.jEZ;
    }

    public void ak(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jFb++;
            } else {
                this.jFa++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jEZ++;
        }
    }
}
