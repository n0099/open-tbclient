package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gPm;
    public int gPn;
    public int gPo;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gPm = 0;
        this.gPn = 0;
        this.gPo = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gPm = 0;
        this.gPn = 0;
        this.gPo = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gPm = jSONObject.optInt("loadmore_count");
            this.gPn = jSONObject.optInt("loadmore_count_pb");
            this.gPo = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bvM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gPm);
            jSONObject.put("loadmore_count_pb", this.gPn);
            jSONObject.put("refresh_count_pb", this.gPo);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int T(boolean z, boolean z2) {
        return z2 ? z ? this.gPo : this.gPn : z ? this.refreshCount : this.gPm;
    }

    public void U(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gPo++;
            } else {
                this.gPn++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gPm++;
        }
    }
}
