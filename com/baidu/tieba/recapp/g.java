package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class g {
    public String forumName;
    public int mHw;
    public int mHx;
    public int mHy;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.mHw = 0;
        this.mHx = 0;
        this.mHy = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mHw = 0;
        this.mHx = 0;
        this.mHy = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mHw = jSONObject.optInt("loadmore_count");
            this.mHx = jSONObject.optInt("loadmore_count_pb");
            this.mHy = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject alG() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mHw);
            jSONObject.put("loadmore_count_pb", this.mHx);
            jSONObject.put("refresh_count_pb", this.mHy);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aw(boolean z, boolean z2) {
        return z2 ? z ? this.mHy : this.mHx : z ? this.refreshCount : this.mHw;
    }

    public void ax(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mHy++;
            } else {
                this.mHx++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mHw++;
        }
    }
}
