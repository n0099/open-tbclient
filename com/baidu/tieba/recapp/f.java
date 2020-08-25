package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f {
    public String forumName;
    public int lCf;
    public int lCg;
    public int lCh;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.lCf = 0;
        this.lCg = 0;
        this.lCh = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.lCf = 0;
        this.lCg = 0;
        this.lCh = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.lCf = jSONObject.optInt("loadmore_count");
            this.lCg = jSONObject.optInt("loadmore_count_pb");
            this.lCh = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject abr() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.lCf);
            jSONObject.put("loadmore_count_pb", this.lCg);
            jSONObject.put("refresh_count_pb", this.lCh);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int av(boolean z, boolean z2) {
        return z2 ? z ? this.lCh : this.lCg : z ? this.refreshCount : this.lCf;
    }

    public void aw(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.lCh++;
            } else {
                this.lCg++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.lCf++;
        }
    }
}
