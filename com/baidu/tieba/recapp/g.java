package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int iHR;
    public int iHS;
    public int iHT;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.iHR = 0;
        this.iHS = 0;
        this.iHT = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.iHR = 0;
        this.iHS = 0;
        this.iHT = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.iHR = jSONObject.optInt("loadmore_count");
            this.iHS = jSONObject.optInt("loadmore_count_pb");
            this.iHT = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject cfE() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.iHR);
            jSONObject.put("loadmore_count_pb", this.iHS);
            jSONObject.put("refresh_count_pb", this.iHT);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ai(boolean z, boolean z2) {
        return z2 ? z ? this.iHT : this.iHS : z ? this.refreshCount : this.iHR;
    }

    public void aj(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.iHT++;
            } else {
                this.iHS++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.iHR++;
        }
    }
}
