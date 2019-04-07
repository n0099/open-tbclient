package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int igA;
    public int igy;
    public int igz;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.igy = 0;
        this.igz = 0;
        this.igA = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.igy = 0;
        this.igz = 0;
        this.igA = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.igy = jSONObject.optInt("loadmore_count");
            this.igz = jSONObject.optInt("loadmore_count_pb");
            this.igA = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bWy() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.igy);
            jSONObject.put("loadmore_count_pb", this.igz);
            jSONObject.put("refresh_count_pb", this.igA);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ae(boolean z, boolean z2) {
        return z2 ? z ? this.igA : this.igz : z ? this.refreshCount : this.igy;
    }

    public void af(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.igA++;
            } else {
                this.igz++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.igy++;
        }
    }
}
