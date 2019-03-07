package com.baidu.tieba.lego.card.model;

import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private final String gHh;
    private final int gHi;
    private final int gHj;
    private final String gHk;

    private c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gHh = jSONObject.optString("moreText");
            this.gHi = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("moreColor", ""));
            this.gHj = com.baidu.tieba.lego.card.d.a.parseColor(jSONObject.optString("moreColorNight", ""));
            this.gHk = jSONObject.optString("moreScheme");
            return;
        }
        this.gHh = "";
        this.gHi = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.gHj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.gHk = "";
    }

    public static c bu(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.gHh);
    }

    public String bzX() {
        return this.gHh;
    }

    public int bzY() {
        return this.gHi;
    }

    public String bzZ() {
        return this.gHk;
    }

    public int bAa() {
        return this.gHj;
    }
}
