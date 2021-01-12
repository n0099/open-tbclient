package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public String forumName;
    public int mIf;
    public int mIg;
    public int mIh;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.mIf = 0;
        this.mIg = 0;
        this.mIh = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mIf = 0;
        this.mIg = 0;
        this.mIh = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mIf = jSONObject.optInt("loadmore_count");
            this.mIg = jSONObject.optInt("loadmore_count_pb");
            this.mIh = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject aiX() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mIf);
            jSONObject.put("loadmore_count_pb", this.mIg);
            jSONObject.put("refresh_count_pb", this.mIh);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ay(boolean z, boolean z2) {
        return z2 ? z ? this.mIh : this.mIg : z ? this.refreshCount : this.mIf;
    }

    public void az(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mIh++;
            } else {
                this.mIg++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mIf++;
        }
    }
}
