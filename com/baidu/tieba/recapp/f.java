package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f {
    public String forumName;
    public int llE;
    public int llF;
    public int llG;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.llE = 0;
        this.llF = 0;
        this.llG = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.llE = 0;
        this.llF = 0;
        this.llG = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.llE = jSONObject.optInt("loadmore_count");
            this.llF = jSONObject.optInt("loadmore_count_pb");
            this.llG = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Vl() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.llE);
            jSONObject.put("loadmore_count_pb", this.llF);
            jSONObject.put("refresh_count_pb", this.llG);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aq(boolean z, boolean z2) {
        return z2 ? z ? this.llG : this.llF : z ? this.refreshCount : this.llE;
    }

    public void ar(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.llG++;
            } else {
                this.llF++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.llE++;
        }
    }
}
