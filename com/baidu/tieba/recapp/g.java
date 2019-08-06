package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int iGK;
    public int iGL;
    public int iGM;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.iGK = 0;
        this.iGL = 0;
        this.iGM = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.iGK = 0;
        this.iGL = 0;
        this.iGM = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.iGK = jSONObject.optInt("loadmore_count");
            this.iGL = jSONObject.optInt("loadmore_count_pb");
            this.iGM = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject chO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.iGK);
            jSONObject.put("loadmore_count_pb", this.iGL);
            jSONObject.put("refresh_count_pb", this.iGM);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ai(boolean z, boolean z2) {
        return z2 ? z ? this.iGM : this.iGL : z ? this.refreshCount : this.iGK;
    }

    public void aj(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.iGM++;
            } else {
                this.iGL++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.iGK++;
        }
    }
}
