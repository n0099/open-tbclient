package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gEA;
    public int gEB;
    public int gEC;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gEA = 0;
        this.gEB = 0;
        this.gEC = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gEA = 0;
        this.gEB = 0;
        this.gEC = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gEA = jSONObject.optInt("loadmore_count");
            this.gEB = jSONObject.optInt("loadmore_count_pb");
            this.gEC = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bsz() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gEA);
            jSONObject.put("loadmore_count_pb", this.gEB);
            jSONObject.put("refresh_count_pb", this.gEC);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int T(boolean z, boolean z2) {
        return z2 ? z ? this.gEC : this.gEB : z ? this.refreshCount : this.gEA;
    }

    public void U(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gEC++;
            } else {
                this.gEB++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gEA++;
        }
    }
}
