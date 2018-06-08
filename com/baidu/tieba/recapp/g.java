package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public String forumName;
    public int gja;
    public int gjb;
    public int gjc;
    public int refreshCount;

    public g() {
        this.refreshCount = 0;
        this.gja = 0;
        this.gjb = 0;
        this.gjc = 0;
    }

    public g(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.gja = 0;
        this.gjb = 0;
        this.gjc = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.gja = jSONObject.optInt("loadmore_count");
            this.gjb = jSONObject.optInt("loadmore_count_pb");
            this.gjc = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject boc() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.gja);
            jSONObject.put("loadmore_count_pb", this.gjb);
            jSONObject.put("refresh_count_pb", this.gjc);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int L(boolean z, boolean z2) {
        return z2 ? z ? this.gjc : this.gjb : z ? this.refreshCount : this.gja;
    }

    public void M(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.gjc++;
            } else {
                this.gjb++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.gja++;
        }
    }
}
