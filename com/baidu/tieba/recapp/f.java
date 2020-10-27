package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class f {
    public String forumName;
    public int mmZ;
    public int mna;
    public int mnb;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.mmZ = 0;
        this.mna = 0;
        this.mnb = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mmZ = 0;
        this.mna = 0;
        this.mnb = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mmZ = jSONObject.optInt("loadmore_count");
            this.mna = jSONObject.optInt("loadmore_count_pb");
            this.mnb = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject agG() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mmZ);
            jSONObject.put("loadmore_count_pb", this.mna);
            jSONObject.put("refresh_count_pb", this.mnb);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int az(boolean z, boolean z2) {
        return z2 ? z ? this.mnb : this.mna : z ? this.refreshCount : this.mmZ;
    }

    public void aA(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mnb++;
            } else {
                this.mna++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mmZ++;
        }
    }
}
