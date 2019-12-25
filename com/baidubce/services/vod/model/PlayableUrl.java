package com.baidubce.services.vod.model;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PlayableUrl {
    private String transcodingPresetName;
    private String url;

    public String getTranscodingPresetName() {
        return this.transcodingPresetName;
    }

    public void setTranscodingPresetName(String str) {
        this.transcodingPresetName = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public static PlayableUrl formatFromJson(JSONObject jSONObject) throws JSONException {
        PlayableUrl playableUrl = new PlayableUrl();
        playableUrl.setUrl(jSONObject.getString("url"));
        playableUrl.setTranscodingPresetName(jSONObject.optString("transcodingPresetName"));
        return playableUrl;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlayableUrl { \n");
        sb.append("   transcodingPresetName = ").append(this.transcodingPresetName).append("\n");
        sb.append("   url = ").append(this.url).append("\n");
        sb.append("  }\n");
        return sb.toString();
    }
}
