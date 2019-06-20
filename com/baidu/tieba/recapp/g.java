package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int izo;
    public int izp;
    public int izq;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.izo = 0;
        this.izp = 0;
        this.izq = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.izo = 0;
        this.izp = 0;
        this.izq = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.izo = jSONObject.optInt("loadmore_count");
            this.izp = jSONObject.optInt("loadmore_count_pb");
            this.izq = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ceF() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.izo);
            jSONObject.put("loadmore_count_pb", this.izp);
            jSONObject.put("refresh_count_pb", this.izq);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int af(boolean z, boolean z2) {
        return z2 ? z ? this.izq : this.izp : z ? this.refreshCount : this.izo;
    }

    public void ag(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.izq++;
            } else {
                this.izp++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.izo++;
        }
    }
}
