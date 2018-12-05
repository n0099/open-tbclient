package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gLq;
    public int gLr;
    public int gLs;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gLq = 0;
        this.gLr = 0;
        this.gLs = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gLq = 0;
        this.gLr = 0;
        this.gLs = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gLq = jSONObject.optInt("loadmore_count");
            this.gLr = jSONObject.optInt("loadmore_count_pb");
            this.gLs = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bus() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gLq);
            jSONObject.put("loadmore_count_pb", this.gLr);
            jSONObject.put("refresh_count_pb", this.gLs);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int T(boolean z, boolean z2) {
        return z2 ? z ? this.gLs : this.gLr : z ? this.refreshCount : this.gLq;
    }

    public void U(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gLs++;
            } else {
                this.gLr++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gLq++;
        }
    }
}
