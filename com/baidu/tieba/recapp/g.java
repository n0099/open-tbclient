package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int goc;
    public int god;
    public int goe;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.goc = 0;
        this.god = 0;
        this.goe = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.goc = 0;
        this.god = 0;
        this.goe = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.goc = jSONObject.optInt("loadmore_count");
            this.god = jSONObject.optInt("loadmore_count_pb");
            this.goe = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bng() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.goc);
            jSONObject.put("loadmore_count_pb", this.god);
            jSONObject.put("refresh_count_pb", this.goe);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int O(boolean z, boolean z2) {
        return z2 ? z ? this.goe : this.god : z ? this.refreshCount : this.goc;
    }

    public void P(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.goe++;
            } else {
                this.god++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.goc++;
        }
    }
}
