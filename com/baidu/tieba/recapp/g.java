package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gof;
    public int gog;
    public int goh;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gof = 0;
        this.gog = 0;
        this.goh = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gof = 0;
        this.gog = 0;
        this.goh = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gof = jSONObject.optInt("loadmore_count");
            this.gog = jSONObject.optInt("loadmore_count_pb");
            this.goh = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bnh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gof);
            jSONObject.put("loadmore_count_pb", this.gog);
            jSONObject.put("refresh_count_pb", this.goh);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int O(boolean z, boolean z2) {
        return z2 ? z ? this.goh : this.gog : z ? this.refreshCount : this.gof;
    }

    public void P(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.goh++;
            } else {
                this.gog++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gof++;
        }
    }
}
