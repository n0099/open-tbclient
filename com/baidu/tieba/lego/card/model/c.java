package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private final String lek;
    private final int lel;
    private final int lem;
    private final String leo;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lek = jSONObject.optString("moreText");
            this.lel = com.baidu.tieba.lego.card.c.b.rT(jSONObject.optString("moreColor", ""));
            this.lem = com.baidu.tieba.lego.card.c.b.rT(jSONObject.optString("moreColorNight", ""));
            this.leo = jSONObject.optString("moreScheme");
            return;
        }
        this.lek = "";
        this.lel = Integer.MAX_VALUE;
        this.lem = Integer.MAX_VALUE;
        this.leo = "";
    }

    public static c eB(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.lek);
    }

    public String dbY() {
        return this.lek;
    }

    public int dbZ() {
        return this.lel;
    }

    public String dca() {
        return this.leo;
    }

    public int dcb() {
        return this.lem;
    }
}
