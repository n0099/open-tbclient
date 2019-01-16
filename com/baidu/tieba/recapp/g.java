package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gPl;
    public int gPm;
    public int gPn;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gPl = 0;
        this.gPm = 0;
        this.gPn = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gPl = 0;
        this.gPm = 0;
        this.gPn = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gPl = jSONObject.optInt("loadmore_count");
            this.gPm = jSONObject.optInt("loadmore_count_pb");
            this.gPn = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bvM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gPl);
            jSONObject.put("loadmore_count_pb", this.gPm);
            jSONObject.put("refresh_count_pb", this.gPn);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int T(boolean z, boolean z2) {
        return z2 ? z ? this.gPn : this.gPm : z ? this.refreshCount : this.gPl;
    }

    public void U(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gPn++;
            } else {
                this.gPm++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gPl++;
        }
    }
}
