package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int igM;
    public int igN;
    public int igO;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.igM = 0;
        this.igN = 0;
        this.igO = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.igM = 0;
        this.igN = 0;
        this.igO = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.igM = jSONObject.optInt("loadmore_count");
            this.igN = jSONObject.optInt("loadmore_count_pb");
            this.igO = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bWC() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.igM);
            jSONObject.put("loadmore_count_pb", this.igN);
            jSONObject.put("refresh_count_pb", this.igO);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ag(boolean z, boolean z2) {
        return z2 ? z ? this.igO : this.igN : z ? this.refreshCount : this.igM;
    }

    public void ah(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.igO++;
            } else {
                this.igN++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.igM++;
        }
    }
}
