package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mName;
    private String oJR;
    private String oJS;
    private boolean oJT;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oJR = jSONObject.optString("thumbnail_url");
        this.oJS = jSONObject.optString("original_url");
        this.oJT = jSONObject.optInt("is_chosen", 0) == 1;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oJR;
    }

    public String getOriginalUrl() {
        return this.oJS;
    }

    public boolean ekm() {
        return this.oJT;
    }

    public void Aq(boolean z) {
        this.oJT = z;
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
