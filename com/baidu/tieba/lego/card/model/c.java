package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private final String kTQ;
    private final int kTR;
    private final int kTS;
    private final String kTT;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kTQ = jSONObject.optString("moreText");
            this.kTR = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("moreColor", ""));
            this.kTS = com.baidu.tieba.lego.card.c.b.rt(jSONObject.optString("moreColorNight", ""));
            this.kTT = jSONObject.optString("moreScheme");
            return;
        }
        this.kTQ = "";
        this.kTR = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.kTS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.kTT = "";
    }

    public static c ey(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.kTQ);
    }

    public String cZK() {
        return this.kTQ;
    }

    public int cZL() {
        return this.kTR;
    }

    public String cZM() {
        return this.kTT;
    }

    public int cZN() {
        return this.kTS;
    }
}
