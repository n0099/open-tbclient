package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class f {
    public String forumName;
    public int kro;
    public int krp;
    public int krq;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.kro = 0;
        this.krp = 0;
        this.krq = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.kro = 0;
        this.krp = 0;
        this.krq = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.kro = jSONObject.optInt("loadmore_count");
            this.krp = jSONObject.optInt("loadmore_count_pb");
            this.krq = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject QW() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.kro);
            jSONObject.put("loadmore_count_pb", this.krp);
            jSONObject.put("refresh_count_pb", this.krq);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int al(boolean z, boolean z2) {
        return z2 ? z ? this.krq : this.krp : z ? this.refreshCount : this.kro;
    }

    public void am(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.krq++;
            } else {
                this.krp++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.kro++;
        }
    }
}
