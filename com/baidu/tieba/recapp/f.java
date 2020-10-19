package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class f {
    public String forumName;
    public int maB;
    public int maC;
    public int maD;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.maB = 0;
        this.maC = 0;
        this.maD = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.maB = 0;
        this.maC = 0;
        this.maD = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.maB = jSONObject.optInt("loadmore_count");
            this.maC = jSONObject.optInt("loadmore_count_pb");
            this.maD = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject aeM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.maB);
            jSONObject.put("loadmore_count_pb", this.maC);
            jSONObject.put("refresh_count_pb", this.maD);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aw(boolean z, boolean z2) {
        return z2 ? z ? this.maD : this.maC : z ? this.refreshCount : this.maB;
    }

    public void ax(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.maD++;
            } else {
                this.maC++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.maB++;
        }
    }
}
