package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f {
    public String forumName;
    public int lCq;
    public int lCr;
    public int lCs;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.lCq = 0;
        this.lCr = 0;
        this.lCs = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.lCq = 0;
        this.lCr = 0;
        this.lCs = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.lCq = jSONObject.optInt("loadmore_count");
            this.lCr = jSONObject.optInt("loadmore_count_pb");
            this.lCs = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject abr() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.lCq);
            jSONObject.put("loadmore_count_pb", this.lCr);
            jSONObject.put("refresh_count_pb", this.lCs);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int av(boolean z, boolean z2) {
        return z2 ? z ? this.lCs : this.lCr : z ? this.refreshCount : this.lCq;
    }

    public void aw(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.lCs++;
            } else {
                this.lCr++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.lCq++;
        }
    }
}
