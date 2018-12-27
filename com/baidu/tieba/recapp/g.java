package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gOh;
    public int gOi;
    public int gOj;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gOh = 0;
        this.gOi = 0;
        this.gOj = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gOh = 0;
        this.gOi = 0;
        this.gOj = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gOh = jSONObject.optInt("loadmore_count");
            this.gOi = jSONObject.optInt("loadmore_count_pb");
            this.gOj = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject bvd() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gOh);
            jSONObject.put("loadmore_count_pb", this.gOi);
            jSONObject.put("refresh_count_pb", this.gOj);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int T(boolean z, boolean z2) {
        return z2 ? z ? this.gOj : this.gOi : z ? this.refreshCount : this.gOh;
    }

    public void U(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gOj++;
            } else {
                this.gOi++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gOh++;
        }
    }
}
