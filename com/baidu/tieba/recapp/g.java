package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int igA;
    public int igB;
    public int igz;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.igz = 0;
        this.igA = 0;
        this.igB = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.igz = 0;
        this.igA = 0;
        this.igB = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.igz = jSONObject.optInt("loadmore_count");
            this.igA = jSONObject.optInt("loadmore_count_pb");
            this.igB = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bWy() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.igz);
            jSONObject.put("loadmore_count_pb", this.igA);
            jSONObject.put("refresh_count_pb", this.igB);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ae(boolean z, boolean z2) {
        return z2 ? z ? this.igB : this.igA : z ? this.refreshCount : this.igz;
    }

    public void af(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.igB++;
            } else {
                this.igA++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.igz++;
        }
    }
}
