package com.baidu.tieba.recommendlist.data;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public int iDa;
    public List<AlaRecommendLiveData> list;
    public int total_count;
    public int type;

    public void parserJson(JSONObject jSONObject) {
        this.total_count = jSONObject.optInt("total_count");
        this.iDa = jSONObject.optInt("has_more");
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
