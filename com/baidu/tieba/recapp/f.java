package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class f {
    public String forumName;
    public int kJm;
    public int kJn;
    public int kJo;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.kJm = 0;
        this.kJn = 0;
        this.kJo = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.kJm = 0;
        this.kJn = 0;
        this.kJo = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.kJm = jSONObject.optInt("loadmore_count");
            this.kJn = jSONObject.optInt("loadmore_count_pb");
            this.kJo = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject TA() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.kJm);
            jSONObject.put("loadmore_count_pb", this.kJn);
            jSONObject.put("refresh_count_pb", this.kJo);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ao(boolean z, boolean z2) {
        return z2 ? z ? this.kJo : this.kJn : z ? this.refreshCount : this.kJm;
    }

    public void ap(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.kJo++;
            } else {
                this.kJn++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.kJm++;
        }
    }
}
