package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f {
    public String forumName;
    public int mtp;
    public int mtq;
    public int mtr;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.mtp = 0;
        this.mtq = 0;
        this.mtr = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mtp = 0;
        this.mtq = 0;
        this.mtr = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mtp = jSONObject.optInt("loadmore_count");
            this.mtq = jSONObject.optInt("loadmore_count_pb");
            this.mtr = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject aiy() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mtp);
            jSONObject.put("loadmore_count_pb", this.mtq);
            jSONObject.put("refresh_count_pb", this.mtr);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aw(boolean z, boolean z2) {
        return z2 ? z ? this.mtr : this.mtq : z ? this.refreshCount : this.mtp;
    }

    public void ax(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mtr++;
            } else {
                this.mtq++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mtp++;
        }
    }
}
