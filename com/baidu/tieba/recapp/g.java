package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int igR;
    public int igS;
    public int igT;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.igR = 0;
        this.igS = 0;
        this.igT = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.igR = 0;
        this.igS = 0;
        this.igT = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.igR = jSONObject.optInt("loadmore_count");
            this.igS = jSONObject.optInt("loadmore_count_pb");
            this.igT = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bWz() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.igR);
            jSONObject.put("loadmore_count_pb", this.igS);
            jSONObject.put("refresh_count_pb", this.igT);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ag(boolean z, boolean z2) {
        return z2 ? z ? this.igT : this.igS : z ? this.refreshCount : this.igR;
    }

    public void ah(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.igT++;
            } else {
                this.igS++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.igR++;
        }
    }
}
