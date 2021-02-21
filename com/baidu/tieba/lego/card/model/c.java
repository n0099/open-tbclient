package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private final String lch;
    private final int lci;
    private final int lcj;
    private final String lck;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lch = jSONObject.optString("moreText");
            this.lci = com.baidu.tieba.lego.card.c.b.rM(jSONObject.optString("moreColor", ""));
            this.lcj = com.baidu.tieba.lego.card.c.b.rM(jSONObject.optString("moreColorNight", ""));
            this.lck = jSONObject.optString("moreScheme");
            return;
        }
        this.lch = "";
        this.lci = Integer.MAX_VALUE;
        this.lcj = Integer.MAX_VALUE;
        this.lck = "";
    }

    public static c ez(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.lch);
    }

    public String dbP() {
        return this.lch;
    }

    public int dbQ() {
        return this.lci;
    }

    public String dbR() {
        return this.lck;
    }

    public int dbS() {
        return this.lcj;
    }
}
