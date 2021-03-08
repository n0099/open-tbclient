package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mMd5;
    private String mName;
    private int mType;
    private String oYk;
    private String oYl;
    private String oYm;
    private boolean oYn;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oYk = jSONObject.optString("thumbnail_url");
        this.oYl = jSONObject.optString("original_url");
        this.oYn = jSONObject.optInt("is_chosen", 0) == 1;
        this.oYm = jSONObject.optString("cover_mp4_zip");
        this.mMd5 = jSONObject.optString("mp4_md5");
        this.mType = jSONObject.optInt("is_dynamic_cover", 0);
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oYk;
    }

    public String getOriginalUrl() {
        return this.oYl;
    }

    public boolean ejl() {
        return this.oYn;
    }

    public void AF(boolean z) {
        this.oYn = z;
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

    public String ejm() {
        return this.oYm;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public int getType() {
        return this.mType;
    }
}
