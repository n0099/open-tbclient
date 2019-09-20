package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int iJb;
    public int iJc;
    public int iJd;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.iJb = 0;
        this.iJc = 0;
        this.iJd = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.iJb = 0;
        this.iJc = 0;
        this.iJd = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.iJb = jSONObject.optInt("loadmore_count");
            this.iJc = jSONObject.optInt("loadmore_count_pb");
            this.iJd = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ciC() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.iJb);
            jSONObject.put("loadmore_count_pb", this.iJc);
            jSONObject.put("refresh_count_pb", this.iJd);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ag(boolean z, boolean z2) {
        return z2 ? z ? this.iJd : this.iJc : z ? this.refreshCount : this.iJb;
    }

    public void ah(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.iJd++;
            } else {
                this.iJc++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.iJb++;
        }
    }
}
