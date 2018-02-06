package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gBR;
    public int gBS;
    public int gBT;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gBR = 0;
        this.gBS = 0;
        this.gBT = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gBR = 0;
        this.gBS = 0;
        this.gBT = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gBR = jSONObject.optInt("loadmore_count");
            this.gBS = jSONObject.optInt("loadmore_count_pb");
            this.gBT = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bnY() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gBR);
            jSONObject.put("loadmore_count_pb", this.gBS);
            jSONObject.put("refresh_count_pb", this.gBT);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int R(boolean z, boolean z2) {
        return z2 ? z ? this.gBT : this.gBS : z ? this.refreshCount : this.gBR;
    }

    public void S(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gBT++;
            } else {
                this.gBS++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gBR++;
        }
    }
}
