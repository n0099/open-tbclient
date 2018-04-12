package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public int fWF;
    public int fWG;
    public int fWH;
    public String forumName;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.fWF = 0;
        this.fWG = 0;
        this.fWH = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.fWF = 0;
        this.fWG = 0;
        this.fWH = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.fWF = jSONObject.optInt("loadmore_count");
            this.fWG = jSONObject.optInt("loadmore_count_pb");
            this.fWH = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bje() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.fWF);
            jSONObject.put("loadmore_count_pb", this.fWG);
            jSONObject.put("refresh_count_pb", this.fWH);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int L(boolean z, boolean z2) {
        return z2 ? z ? this.fWH : this.fWG : z ? this.refreshCount : this.fWF;
    }

    public void M(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.fWH++;
            } else {
                this.fWG++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.fWF++;
        }
    }
}
