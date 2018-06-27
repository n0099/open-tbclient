package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gmS;
    public int gmT;
    public int gmU;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gmS = 0;
        this.gmT = 0;
        this.gmU = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gmS = 0;
        this.gmT = 0;
        this.gmU = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gmS = jSONObject.optInt("loadmore_count");
            this.gmT = jSONObject.optInt("loadmore_count_pb");
            this.gmU = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject boC() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gmS);
            jSONObject.put("loadmore_count_pb", this.gmT);
            jSONObject.put("refresh_count_pb", this.gmU);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int O(boolean z, boolean z2) {
        return z2 ? z ? this.gmU : this.gmT : z ? this.refreshCount : this.gmS;
    }

    public void P(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gmU++;
            } else {
                this.gmT++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gmS++;
        }
    }
}
