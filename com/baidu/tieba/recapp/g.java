package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gBC;
    public int gBD;
    public int gBE;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gBC = 0;
        this.gBD = 0;
        this.gBE = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gBC = 0;
        this.gBD = 0;
        this.gBE = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gBC = jSONObject.optInt("loadmore_count");
            this.gBD = jSONObject.optInt("loadmore_count_pb");
            this.gBE = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bnX() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gBC);
            jSONObject.put("loadmore_count_pb", this.gBD);
            jSONObject.put("refresh_count_pb", this.gBE);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int R(boolean z, boolean z2) {
        return z2 ? z ? this.gBE : this.gBD : z ? this.refreshCount : this.gBC;
    }

    public void S(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gBE++;
            } else {
                this.gBD++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gBC++;
        }
    }
}
