package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public String forumName;
    public int mMO;
    public int mMP;
    public int mMQ;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.mMO = 0;
        this.mMP = 0;
        this.mMQ = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.mMO = 0;
        this.mMP = 0;
        this.mMQ = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.mMO = jSONObject.optInt("loadmore_count");
            this.mMP = jSONObject.optInt("loadmore_count_pb");
            this.mMQ = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject amQ() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.mMO);
            jSONObject.put("loadmore_count_pb", this.mMP);
            jSONObject.put("refresh_count_pb", this.mMQ);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ay(boolean z, boolean z2) {
        return z2 ? z ? this.mMQ : this.mMP : z ? this.refreshCount : this.mMO;
    }

    public void az(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mMQ++;
            } else {
                this.mMP++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.mMO++;
        }
    }
}
