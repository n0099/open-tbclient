package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i extends BaseData {
    private ArrayList<c> gaX;
    private g nTt;
    private int nTu = 10;

    public ArrayList<c> getList() {
        return this.gaX;
    }

    public g dXq() {
        return this.nTt;
    }

    public int dXr() {
        return this.nTu;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.nTu = jSONObject.optInt("rank_size");
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.gaX = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject);
                    this.gaX.add(cVar);
                }
            }
            this.nTt = new g();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject2 != null) {
                this.nTt.parserJson(optJSONObject2);
            }
        }
    }
}
