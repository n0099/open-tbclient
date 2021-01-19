package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mMd5;
    private String mName;
    private int mType;
    private String oLA;
    private String oLB;
    private boolean oLC;
    private String oLz;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oLz = jSONObject.optString("thumbnail_url");
        this.oLA = jSONObject.optString("original_url");
        this.oLC = jSONObject.optInt("is_chosen", 0) == 1;
        this.oLB = jSONObject.optString("cover_mp4_zip");
        this.mMd5 = jSONObject.optString("mp4_md5");
        this.mType = jSONObject.optInt("is_dynamic_cover", 0);
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oLz;
    }

    public String getOriginalUrl() {
        return this.oLA;
    }

    public boolean egB() {
        return this.oLC;
    }

    public void An(boolean z) {
        this.oLC = z;
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

    public String egC() {
        return this.oLB;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public int getType() {
        return this.mType;
    }
}
