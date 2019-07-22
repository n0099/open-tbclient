package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int iFG;
    public int iFH;
    public int iFI;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.iFG = 0;
        this.iFH = 0;
        this.iFI = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.iFG = 0;
        this.iFH = 0;
        this.iFI = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.iFG = jSONObject.optInt("loadmore_count");
            this.iFH = jSONObject.optInt("loadmore_count_pb");
            this.iFI = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject chw() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.iFG);
            jSONObject.put("loadmore_count_pb", this.iFH);
            jSONObject.put("refresh_count_pb", this.iFI);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ai(boolean z, boolean z2) {
        return z2 ? z ? this.iFI : this.iFH : z ? this.refreshCount : this.iFG;
    }

    public void aj(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.iFI++;
            } else {
                this.iFH++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.iFG++;
        }
    }
}
