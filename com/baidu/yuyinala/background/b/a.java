package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mMd5;
    private String mName;
    private int mType;
    private String oWf;
    private String oWg;
    private String oWh;
    private boolean oWi;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oWf = jSONObject.optString("thumbnail_url");
        this.oWg = jSONObject.optString("original_url");
        this.oWi = jSONObject.optInt("is_chosen", 0) == 1;
        this.oWh = jSONObject.optString("cover_mp4_zip");
        this.mMd5 = jSONObject.optString("mp4_md5");
        this.mType = jSONObject.optInt("is_dynamic_cover", 0);
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oWf;
    }

    public String getOriginalUrl() {
        return this.oWg;
    }

    public boolean ejb() {
        return this.oWi;
    }

    public void AG(boolean z) {
        this.oWi = z;
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

    public String ejc() {
        return this.oWh;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public int getType() {
        return this.mType;
    }
}
