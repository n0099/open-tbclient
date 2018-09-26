package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gvx;
    public int gvy;
    public int gvz;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gvx = 0;
        this.gvy = 0;
        this.gvz = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gvx = 0;
        this.gvy = 0;
        this.gvz = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gvx = jSONObject.optInt("loadmore_count");
            this.gvy = jSONObject.optInt("loadmore_count_pb");
            this.gvz = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bpO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gvx);
            jSONObject.put("loadmore_count_pb", this.gvy);
            jSONObject.put("refresh_count_pb", this.gvz);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int Q(boolean z, boolean z2) {
        return z2 ? z ? this.gvz : this.gvy : z ? this.refreshCount : this.gvx;
    }

    public void R(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gvz++;
            } else {
                this.gvy++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gvx++;
        }
    }
}
