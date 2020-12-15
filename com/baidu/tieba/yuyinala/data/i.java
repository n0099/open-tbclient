package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i extends BaseData {
    private ArrayList<c> giR;
    private g ojW;
    private int ojX = 10;

    public ArrayList<c> getList() {
        return this.giR;
    }

    public g ecU() {
        return this.ojW;
    }

    public int ecV() {
        return this.ojX;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ojX = jSONObject.optInt("rank_size");
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.giR = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject);
                    this.giR.add(cVar);
                }
            }
            this.ojW = new g();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject2 != null) {
                this.ojW.parserJson(optJSONObject2);
            }
        }
    }
}
