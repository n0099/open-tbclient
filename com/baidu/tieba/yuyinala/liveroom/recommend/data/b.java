package com.baidu.tieba.yuyinala.liveroom.recommend.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public int jrF;
    public List<AlaRecommendLiveData> list;
    public int total_count;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        this.total_count = jSONObject.optInt("total_count");
        this.jrF = jSONObject.optInt("has_more");
        this.list = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AlaRecommendLiveData alaRecommendLiveData = new AlaRecommendLiveData();
                    alaRecommendLiveData.parserJson(optJSONObject);
                    this.list.add(alaRecommendLiveData);
                }
            }
        }
    }
}
