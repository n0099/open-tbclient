package com.baidu.tieba.yuyinala.charm.audiencelist;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BaseData {
    private List<a> aJb;

    public List<a> getList() {
        return this.aJb;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("user_info")) != null) {
            this.aJb = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a aVar = new a();
                aVar.parserJson(optJSONObject);
                this.aJb.add(aVar);
            }
        }
    }
}
