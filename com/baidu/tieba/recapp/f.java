package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class f {
    public String forumName;
    public int lep;
    public int leq;
    public int ler;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.lep = 0;
        this.leq = 0;
        this.ler = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.lep = 0;
        this.leq = 0;
        this.ler = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.lep = jSONObject.optInt("loadmore_count");
            this.leq = jSONObject.optInt("loadmore_count_pb");
            this.ler = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject UG() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.lep);
            jSONObject.put("loadmore_count_pb", this.leq);
            jSONObject.put("refresh_count_pb", this.ler);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ap(boolean z, boolean z2) {
        return z2 ? z ? this.ler : this.leq : z ? this.refreshCount : this.lep;
    }

    public void aq(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.ler++;
            } else {
                this.leq++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.lep++;
        }
    }
}
