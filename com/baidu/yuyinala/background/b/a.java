package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mName;
    private String otf;
    private String otg;
    private boolean oth;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.otf = jSONObject.optString("thumbnail_url");
        this.otg = jSONObject.optString("original_url");
        this.oth = jSONObject.optInt("is_chosen", 0) == 1;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.otf;
    }

    public String getOriginalUrl() {
        return this.otg;
    }

    public boolean eeA() {
        return this.oth;
    }

    public void zF(boolean z) {
        this.oth = z;
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
