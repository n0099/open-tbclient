package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f {
    public String forumName;
    public int llC;
    public int llD;
    public int llE;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.llC = 0;
        this.llD = 0;
        this.llE = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.llC = 0;
        this.llD = 0;
        this.llE = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.llC = jSONObject.optInt("loadmore_count");
            this.llD = jSONObject.optInt("loadmore_count_pb");
            this.llE = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject Vl() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.llC);
            jSONObject.put("loadmore_count_pb", this.llD);
            jSONObject.put("refresh_count_pb", this.llE);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int aq(boolean z, boolean z2) {
        return z2 ? z ? this.llE : this.llD : z ? this.refreshCount : this.llC;
    }

    public void ar(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.llE++;
            } else {
                this.llD++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.llC++;
        }
    }
}
