package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaRecommendLiveData extends AlaLiveInfoData {
    public String distance;

    @Override // com.baidu.live.data.AlaLiveInfoData
    public void parserJson(JSONObject jSONObject) {
        super.parserJson(jSONObject);
        if (jSONObject != null) {
            this.distance = jSONObject.optString("distance");
        }
    }
}
