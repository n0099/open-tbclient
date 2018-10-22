package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gCZ;
    public int gDa;
    public int gDb;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gCZ = 0;
        this.gDa = 0;
        this.gDb = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gCZ = 0;
        this.gDa = 0;
        this.gDb = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gCZ = jSONObject.optInt("loadmore_count");
            this.gDa = jSONObject.optInt("loadmore_count_pb");
            this.gDb = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject btd() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gCZ);
            jSONObject.put("loadmore_count_pb", this.gDa);
            jSONObject.put("refresh_count_pb", this.gDb);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int R(boolean z, boolean z2) {
        return z2 ? z ? this.gDb : this.gDa : z ? this.refreshCount : this.gCZ;
    }

    public void S(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gDb++;
            } else {
                this.gDa++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gCZ++;
        }
    }
}
