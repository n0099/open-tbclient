package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class PlayableUrl {
    public String transcodingPresetName;
    public String url;

    public static PlayableUrl formatFromJson(JSONObject jSONObject) throws JSONException {
        PlayableUrl playableUrl = new PlayableUrl();
        playableUrl.setUrl(jSONObject.getString("url"));
        playableUrl.setTranscodingPresetName(jSONObject.optString("transcodingPresetName"));
        return playableUrl;
    }

    public String getTranscodingPresetName() {
        return this.transcodingPresetName;
    }

    public String getUrl() {
        return this.url;
    }

    public void setTranscodingPresetName(String str) {
        this.transcodingPresetName = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "PlayableUrl { \n   transcodingPresetName = " + this.transcodingPresetName + "\n   url = " + this.url + "\n  }\n";
    }
}
