package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class g {
    public String forumName;
    public int mHA;
    public int mHy;
    public int mHz;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.mHy = 0;
        this.mHz = 0;
        this.mHA = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mHy = 0;
        this.mHz = 0;
        this.mHA = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mHy = jSONObject.optInt("loadmore_count");
            this.mHz = jSONObject.optInt("loadmore_count_pb");
            this.mHA = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject alG() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mHy);
            jSONObject.put("loadmore_count_pb", this.mHz);
            jSONObject.put("refresh_count_pb", this.mHA);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aw(boolean z, boolean z2) {
        return z2 ? z ? this.mHA : this.mHz : z ? this.refreshCount : this.mHy;
    }

    public void ax(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mHA++;
            } else {
                this.mHz++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mHy++;
        }
    }
}
