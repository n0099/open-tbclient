package com.baidu.yuyinala.mode.b;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private String mIconUrl;
    private int mMode;
    private String mTitle;
    private boolean ovz;

    public void parse(JSONObject jSONObject) {
        this.mMode = jSONObject.optInt(UbcStatConstant.KEY_CONTENT_EXT_MODE);
        this.mTitle = jSONObject.optString("text");
        this.mIconUrl = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        this.ovz = jSONObject.optInt("is_chosen", 0) == 1;
    }

    public int getMode() {
        return this.mMode;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public boolean eey() {
        return this.ovz;
    }

    public void zM(boolean z) {
        this.ovz = z;
    }
}
