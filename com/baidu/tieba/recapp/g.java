package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public int fWC;
    public int fWD;
    public int fWE;
    public String forumName;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.fWC = 0;
        this.fWD = 0;
        this.fWE = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.fWC = 0;
        this.fWD = 0;
        this.fWE = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.fWC = jSONObject.optInt("loadmore_count");
            this.fWD = jSONObject.optInt("loadmore_count_pb");
            this.fWE = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bje() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.fWC);
            jSONObject.put("loadmore_count_pb", this.fWD);
            jSONObject.put("refresh_count_pb", this.fWE);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int L(boolean z, boolean z2) {
        return z2 ? z ? this.fWE : this.fWD : z ? this.refreshCount : this.fWC;
    }

    public void M(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.fWE++;
            } else {
                this.fWD++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.fWC++;
        }
    }
}
