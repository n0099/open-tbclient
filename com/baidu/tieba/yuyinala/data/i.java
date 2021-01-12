package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i extends BaseData {
    private ArrayList<c> goH;
    private g ohe;
    private int ohf = 10;

    public ArrayList<c> getList() {
        return this.goH;
    }

    public g dXZ() {
        return this.ohe;
    }

    public int dYa() {
        return this.ohf;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ohf = jSONObject.optInt("rank_size");
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.goH = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject);
                    this.goH.add(cVar);
                }
            }
            this.ohe = new g();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject2 != null) {
                this.ohe.parserJson(optJSONObject2);
            }
        }
    }
}
