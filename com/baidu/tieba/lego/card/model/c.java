package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    private final String kYv;
    private final int kYw;
    private final int kYx;
    private final String kYy;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kYv = jSONObject.optString("moreText");
            this.kYw = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("moreColor", ""));
            this.kYx = com.baidu.tieba.lego.card.c.b.sF(jSONObject.optString("moreColorNight", ""));
            this.kYy = jSONObject.optString("moreScheme");
            return;
        }
        this.kYv = "";
        this.kYw = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.kYx = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.kYy = "";
    }

    public static c ey(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.kYv);
    }

    public String ddC() {
        return this.kYv;
    }

    public int ddD() {
        return this.kYw;
    }

    public String ddE() {
        return this.kYy;
    }

    public int ddF() {
        return this.kYx;
    }
}
