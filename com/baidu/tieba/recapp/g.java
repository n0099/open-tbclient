package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gBS;
    public int gBT;
    public int gBU;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gBS = 0;
        this.gBT = 0;
        this.gBU = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gBS = 0;
        this.gBT = 0;
        this.gBU = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gBS = jSONObject.optInt("loadmore_count");
            this.gBT = jSONObject.optInt("loadmore_count_pb");
            this.gBU = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bnY() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gBS);
            jSONObject.put("loadmore_count_pb", this.gBT);
            jSONObject.put("refresh_count_pb", this.gBU);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int R(boolean z, boolean z2) {
        return z2 ? z ? this.gBU : this.gBT : z ? this.refreshCount : this.gBS;
    }

    public void S(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gBU++;
            } else {
                this.gBT++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gBS++;
        }
    }
}
