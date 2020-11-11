package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class f {
    public String forumName;
    public int msX;
    public int msY;
    public int msZ;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.msX = 0;
        this.msY = 0;
        this.msZ = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.msX = 0;
        this.msY = 0;
        this.msZ = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.msX = jSONObject.optInt("loadmore_count");
            this.msY = jSONObject.optInt("loadmore_count_pb");
            this.msZ = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject ajg() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.msX);
            jSONObject.put("loadmore_count_pb", this.msY);
            jSONObject.put("refresh_count_pb", this.msZ);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int az(boolean z, boolean z2) {
        return z2 ? z ? this.msZ : this.msY : z ? this.refreshCount : this.msX;
    }

    public void aA(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.msZ++;
            } else {
                this.msY++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.msX++;
        }
    }
}
