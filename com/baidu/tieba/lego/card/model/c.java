package com.baidu.tieba.lego.card.model;

import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private final String gHi;
    private final int gHj;
    private final int gHk;
    private final String gHl;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gHi = jSONObject.optString("moreText");
            this.gHj = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("moreColor", ""));
            this.gHk = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("moreColorNight", ""));
            this.gHl = jSONObject.optString("moreScheme");
            return;
        }
        this.gHi = "";
        this.gHj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.gHk = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.gHl = "";
    }

    public static c bu(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.gHi);
    }

    public String bzY() {
        return this.gHi;
    }

    public int bzZ() {
        return this.gHj;
    }

    public String bAa() {
        return this.gHl;
    }

    public int bAb() {
        return this.gHk;
    }
}
