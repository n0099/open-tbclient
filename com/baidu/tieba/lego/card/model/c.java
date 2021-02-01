package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private final String lbT;
    private final int lbU;
    private final int lbV;
    private final String lbW;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lbT = jSONObject.optString("moreText");
            this.lbU = com.baidu.tieba.lego.card.c.b.rM(jSONObject.optString("moreColor", ""));
            this.lbV = com.baidu.tieba.lego.card.c.b.rM(jSONObject.optString("moreColorNight", ""));
            this.lbW = jSONObject.optString("moreScheme");
            return;
        }
        this.lbT = "";
        this.lbU = Integer.MAX_VALUE;
        this.lbV = Integer.MAX_VALUE;
        this.lbW = "";
    }

    public static c ez(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.lbT);
    }

    public String dbI() {
        return this.lbT;
    }

    public int dbJ() {
        return this.lbU;
    }

    public String dbK() {
        return this.lbW;
    }

    public int dbL() {
        return this.lbV;
    }
}
