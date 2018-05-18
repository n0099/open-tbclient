package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public int fXI;
    public int fXJ;
    public int fXK;
    public String forumName;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.fXI = 0;
        this.fXJ = 0;
        this.fXK = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.fXI = 0;
        this.fXJ = 0;
        this.fXK = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.fXI = jSONObject.optInt("loadmore_count");
            this.fXJ = jSONObject.optInt("loadmore_count_pb");
            this.fXK = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bjd() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.fXI);
            jSONObject.put("loadmore_count_pb", this.fXJ);
            jSONObject.put("refresh_count_pb", this.fXK);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int L(boolean z, boolean z2) {
        return z2 ? z ? this.fXK : this.fXJ : z ? this.refreshCount : this.fXI;
    }

    public void M(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.fXK++;
            } else {
                this.fXJ++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.fXI++;
        }
    }
}
