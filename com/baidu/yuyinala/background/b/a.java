package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mMd5;
    private String mName;
    private int mType;
    private String oVF;
    private String oVG;
    private String oVH;
    private boolean oVI;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oVF = jSONObject.optString("thumbnail_url");
        this.oVG = jSONObject.optString("original_url");
        this.oVI = jSONObject.optInt("is_chosen", 0) == 1;
        this.oVH = jSONObject.optString("cover_mp4_zip");
        this.mMd5 = jSONObject.optString("mp4_md5");
        this.mType = jSONObject.optInt("is_dynamic_cover", 0);
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oVF;
    }

    public String getOriginalUrl() {
        return this.oVG;
    }

    public boolean eiT() {
        return this.oVI;
    }

    public void AG(boolean z) {
        this.oVI = z;
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

    public String eiU() {
        return this.oVH;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public int getType() {
        return this.mType;
    }
}
