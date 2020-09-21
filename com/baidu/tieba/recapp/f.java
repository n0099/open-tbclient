package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f {
    public String forumName;
    public int lLk;
    public int lLl;
    public int lLm;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.lLk = 0;
        this.lLl = 0;
        this.lLm = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.lLk = 0;
        this.lLl = 0;
        this.lLm = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.lLk = jSONObject.optInt("loadmore_count");
            this.lLl = jSONObject.optInt("loadmore_count_pb");
            this.lLm = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject aca() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.lLk);
            jSONObject.put("loadmore_count_pb", this.lLl);
            jSONObject.put("refresh_count_pb", this.lLm);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ax(boolean z, boolean z2) {
        return z2 ? z ? this.lLm : this.lLl : z ? this.refreshCount : this.lLk;
    }

    public void ay(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.lLm++;
            } else {
                this.lLl++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.lLk++;
        }
    }
}
