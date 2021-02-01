package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public String forumName;
    public int mRp;
    public int mRq;
    public int mRr;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.mRp = 0;
        this.mRq = 0;
        this.mRr = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mRp = 0;
        this.mRq = 0;
        this.mRr = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mRp = jSONObject.optInt("loadmore_count");
            this.mRq = jSONObject.optInt("loadmore_count_pb");
            this.mRr = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ajv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mRp);
            jSONObject.put("loadmore_count_pb", this.mRq);
            jSONObject.put("refresh_count_pb", this.mRr);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ay(boolean z, boolean z2) {
        return z2 ? z ? this.mRr : this.mRq : z ? this.refreshCount : this.mRp;
    }

    public void az(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mRr++;
            } else {
                this.mRq++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mRp++;
        }
    }
}
