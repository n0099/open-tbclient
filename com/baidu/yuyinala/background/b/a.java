package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mName;
    private String oka;
    private String okb;
    private boolean okc;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oka = jSONObject.optString("thumbnail_url");
        this.okb = jSONObject.optString("original_url");
        this.okc = jSONObject.optInt("is_chosen", 0) == 1;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oka;
    }

    public String getOriginalUrl() {
        return this.okb;
    }

    public boolean eaS() {
        return this.okc;
    }

    public void zu(boolean z) {
        this.okc = z;
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
