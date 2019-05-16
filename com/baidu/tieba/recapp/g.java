package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int izl;
    public int izm;
    public int izn;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.izl = 0;
        this.izm = 0;
        this.izn = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.izl = 0;
        this.izm = 0;
        this.izn = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.izl = jSONObject.optInt("loadmore_count");
            this.izm = jSONObject.optInt("loadmore_count_pb");
            this.izn = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ceC() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.izl);
            jSONObject.put("loadmore_count_pb", this.izm);
            jSONObject.put("refresh_count_pb", this.izn);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int af(boolean z, boolean z2) {
        return z2 ? z ? this.izn : this.izm : z ? this.refreshCount : this.izl;
    }

    public void ag(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.izn++;
            } else {
                this.izm++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.izl++;
        }
    }
}
