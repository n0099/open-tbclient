package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public String gKV;
    public String pic;
    public String scheme;
    public String shareContent;
    public String shareImageUrl;
    public String shareTitle;
    public int type;

    public boolean isValid() {
        if (TextUtils.isEmpty(this.scheme)) {
            return false;
        }
        if (this.type == 2) {
            if (TextUtils.isEmpty(this.shareTitle) || TextUtils.isEmpty(this.shareContent) || TextUtils.isEmpty(this.shareImageUrl)) {
                return false;
            }
        } else if (TextUtils.isEmpty(this.pic) || TextUtils.isEmpty(this.gKV)) {
            return false;
        }
        return true;
    }

    public void parseFromJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            this.pic = jSONObject.optString("pic");
            this.gKV = jSONObject.optString("picNight");
            this.scheme = jSONObject.optString("scheme");
            this.type = jSONObject.optInt("type", 1);
            if (this.type == 2 && (optJSONObject = jSONObject.optJSONObject("extra")) != null) {
                this.shareTitle = optJSONObject.optString("title");
                this.shareContent = optJSONObject.optString("content");
                this.shareImageUrl = optJSONObject.optString("imageUrl");
            }
        }
    }
}
