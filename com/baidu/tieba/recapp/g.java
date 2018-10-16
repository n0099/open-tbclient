package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gCY;
    public int gCZ;
    public int gDa;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gCY = 0;
        this.gCZ = 0;
        this.gDa = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gCY = 0;
        this.gCZ = 0;
        this.gDa = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gCY = jSONObject.optInt("loadmore_count");
            this.gCZ = jSONObject.optInt("loadmore_count_pb");
            this.gDa = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject btd() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gCY);
            jSONObject.put("loadmore_count_pb", this.gCZ);
            jSONObject.put("refresh_count_pb", this.gDa);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int R(boolean z, boolean z2) {
        return z2 ? z ? this.gDa : this.gCZ : z ? this.refreshCount : this.gCY;
    }

    public void S(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gDa++;
            } else {
                this.gCZ++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gCY++;
        }
    }
}
