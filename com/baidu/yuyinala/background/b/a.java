package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mName;
    private String oJP;
    private String oJQ;
    private boolean oJR;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oJP = jSONObject.optString("thumbnail_url");
        this.oJQ = jSONObject.optString("original_url");
        this.oJR = jSONObject.optInt("is_chosen", 0) == 1;
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oJP;
    }

    public String getOriginalUrl() {
        return this.oJQ;
    }

    public boolean ekl() {
        return this.oJR;
    }

    public void Aq(boolean z) {
        this.oJR = z;
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
