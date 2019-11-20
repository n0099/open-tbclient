package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int iHa;
    public int iHb;
    public int iHc;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.iHa = 0;
        this.iHb = 0;
        this.iHc = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.iHa = 0;
        this.iHb = 0;
        this.iHc = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.iHa = jSONObject.optInt("loadmore_count");
            this.iHb = jSONObject.optInt("loadmore_count_pb");
            this.iHc = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject cfC() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.iHa);
            jSONObject.put("loadmore_count_pb", this.iHb);
            jSONObject.put("refresh_count_pb", this.iHc);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ai(boolean z, boolean z2) {
        return z2 ? z ? this.iHc : this.iHb : z ? this.refreshCount : this.iHa;
    }

    public void aj(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.iHc++;
            } else {
                this.iHb++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.iHa++;
        }
    }
}
