package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class g {
    public String forumName;
    public int jHD;
    public int jHE;
    public int jHF;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.jHD = 0;
        this.jHE = 0;
        this.jHF = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.jHD = 0;
        this.jHE = 0;
        this.jHF = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.jHD = jSONObject.optInt("loadmore_count");
            this.jHE = jSONObject.optInt("loadmore_count_pb");
            this.jHF = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Jk() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.jHD);
            jSONObject.put("loadmore_count_pb", this.jHE);
            jSONObject.put("refresh_count_pb", this.jHF);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int al(boolean z, boolean z2) {
        return z2 ? z ? this.jHF : this.jHE : z ? this.refreshCount : this.jHD;
    }

    public void am(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.jHF++;
            } else {
                this.jHE++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.jHD++;
        }
    }
}
