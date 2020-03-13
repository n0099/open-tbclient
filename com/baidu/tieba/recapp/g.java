package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class g {
    public String forumName;
    public int jGe;
    public int jGf;
    public int jGg;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jGe = 0;
        this.jGf = 0;
        this.jGg = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jGe = 0;
        this.jGf = 0;
        this.jGg = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jGe = jSONObject.optInt("loadmore_count");
            this.jGf = jSONObject.optInt("loadmore_count_pb");
            this.jGg = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Jh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jGe);
            jSONObject.put("loadmore_count_pb", this.jGf);
            jSONObject.put("refresh_count_pb", this.jGg);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int al(boolean z, boolean z2) {
        return z2 ? z ? this.jGg : this.jGf : z ? this.refreshCount : this.jGe;
    }

    public void am(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jGg++;
            } else {
                this.jGf++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jGe++;
        }
    }
}
