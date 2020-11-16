package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mName;
    private String ouJ;
    private String ouK;
    private boolean ouL;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.ouJ = jSONObject.optString("thumbnail_url");
        this.ouK = jSONObject.optString("original_url");
        this.ouL = jSONObject.optInt("is_chosen", 0) == 1;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.ouJ;
    }

    public String getOriginalUrl() {
        return this.ouK;
    }

    public boolean eey() {
        return this.ouL;
    }

    public void zM(boolean z) {
        this.ouL = z;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void setLoading(boolean z) {
        this.isLoading = z;
    }

    public String getId() {
        return this.mId;
    }
}
