package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i extends BaseData {
    private ArrayList<c> grE;
    private int orA = 10;
    private g orz;

    public ArrayList<c> getList() {
        return this.grE;
    }

    public g eas() {
        return this.orz;
    }

    public int eat() {
        return this.orA;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.orA = jSONObject.optInt("rank_size");
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.grE = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject);
                    this.grE.add(cVar);
                }
            }
            this.orz = new g();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject2 != null) {
                this.orz.parserJson(optJSONObject2);
            }
        }
    }
}
