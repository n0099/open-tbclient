package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class f {
    public String forumName;
    public int krs;
    public int krt;
    public int kru;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.krs = 0;
        this.krt = 0;
        this.kru = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.krs = 0;
        this.krt = 0;
        this.kru = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.krs = jSONObject.optInt("loadmore_count");
            this.krt = jSONObject.optInt("loadmore_count_pb");
            this.kru = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject QV() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.krs);
            jSONObject.put("loadmore_count_pb", this.krt);
            jSONObject.put("refresh_count_pb", this.kru);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int al(boolean z, boolean z2) {
        return z2 ? z ? this.kru : this.krt : z ? this.refreshCount : this.krs;
    }

    public void am(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.kru++;
            } else {
                this.krt++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.krs++;
        }
    }
}
