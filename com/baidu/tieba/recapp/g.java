package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int igS;
    public int igT;
    public int igU;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.igS = 0;
        this.igT = 0;
        this.igU = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.igS = 0;
        this.igT = 0;
        this.igU = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.igS = jSONObject.optInt("loadmore_count");
            this.igT = jSONObject.optInt("loadmore_count_pb");
            this.igU = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bWA() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.igS);
            jSONObject.put("loadmore_count_pb", this.igT);
            jSONObject.put("refresh_count_pb", this.igU);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ag(boolean z, boolean z2) {
        return z2 ? z ? this.igU : this.igT : z ? this.refreshCount : this.igS;
    }

    public void ah(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.igU++;
            } else {
                this.igT++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.igS++;
        }
    }
}
