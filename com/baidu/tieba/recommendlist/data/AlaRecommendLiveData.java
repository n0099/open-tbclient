package com.baidu.tieba.recommendlist.data;

import com.baidu.live.data.AlaLiveInfoData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
