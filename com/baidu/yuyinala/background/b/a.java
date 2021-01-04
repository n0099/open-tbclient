package com.baidu.yuyinala.background.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private boolean isLoading;
    private String mId;
    private String mMd5;
    private String mName;
    private int mType;
    private String oQa;
    private String oQb;
    private String oQc;
    private boolean oQd;

    public void parse(JSONObject jSONObject) {
        this.mId = jSONObject.optString("id");
        this.mName = jSONObject.optString("name");
        this.oQa = jSONObject.optString("thumbnail_url");
        this.oQb = jSONObject.optString("original_url");
        this.oQd = jSONObject.optInt("is_chosen", 0) == 1;
        this.oQc = jSONObject.optString("cover_mp4_zip");
        this.mMd5 = jSONObject.optString("mp4_md5");
        this.mType = jSONObject.optInt("is_dynamic_cover", 0);
    }

    public String getName() {
        return this.mName;
    }

    public String getThumbnailUrl() {
        return this.oQa;
    }

    public String getOriginalUrl() {
        return this.oQb;
    }

    public boolean eku() {
        return this.oQd;
    }

    public void Ar(boolean z) {
        this.oQd = z;
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

    public String ekv() {
        return this.oQc;
    }

    public String getMd5() {
        return this.mMd5;
    }

    public int getType() {
        return this.mType;
    }
}
