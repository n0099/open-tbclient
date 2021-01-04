package com.baidu.tieba.recommendlist.data;

import android.text.TextUtils;
import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaRecommendLiveData extends AlaLiveInfoData {
    public String bdPortrait;
    public String distance;
    public String duration;
    public c interactTag;
    public int mixType;
    public String portrait;
    public String scheme;

    @Override // com.baidu.live.data.AlaLiveInfoData
    public void parserJson(JSONObject jSONObject) {
        super.parserJson(jSONObject);
        if (jSONObject != null) {
            this.distance = jSONObject.optString("distance");
            this.portrait = jSONObject.optString("portrait");
            this.bdPortrait = jSONObject.optString("bd_portrait");
            this.mixType = jSONObject.optInt("mix_type");
            this.scheme = jSONObject.optString("scheme");
            this.duration = jSONObject.optString("time_length");
            this.interactTag = new c(jSONObject.optString("live_interact_tag"));
        }
    }

    public String getLivePortrait() {
        return TextUtils.isEmpty(this.bdPortrait) ? this.portrait : this.bdPortrait;
    }
}
