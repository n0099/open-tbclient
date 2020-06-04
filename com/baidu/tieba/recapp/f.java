package com.baidu.tieba.recapp;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class f {
    public String forumName;
    public int kKu;
    public int kKv;
    public int kKw;
    public int refreshCount;

    public f() {
        this.refreshCount = 0;
        this.kKu = 0;
        this.kKv = 0;
        this.kKw = 0;
    }

    public f(JSONObject jSONObject) {
        this.refreshCount = 0;
        this.kKu = 0;
        this.kKv = 0;
        this.kKw = 0;
        if (jSONObject != null) {
            this.forumName = jSONObject.optString("forum_name");
            this.refreshCount = jSONObject.optInt("refresh_count");
            this.kKu = jSONObject.optInt("loadmore_count");
            this.kKv = jSONObject.optInt("loadmore_count_pb");
            this.kKw = jSONObject.optInt("refresh_count_pb");
        }
    }

    public JSONObject TA() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put("refresh_count", this.refreshCount);
            jSONObject.put("loadmore_count", this.kKu);
            jSONObject.put("loadmore_count_pb", this.kKv);
            jSONObject.put("refresh_count_pb", this.kKw);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public int ao(boolean z, boolean z2) {
        return z2 ? z ? this.kKw : this.kKv : z ? this.refreshCount : this.kKu;
    }

    public void ap(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.kKw++;
            } else {
                this.kKv++;
            }
        } else if (z) {
            this.refreshCount++;
        } else {
            this.kKu++;
        }
    }
}
