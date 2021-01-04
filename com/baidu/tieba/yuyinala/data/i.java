package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class i extends BaseData {
    private ArrayList<c> gto;
    private g olK;
    private int olL = 10;

    public ArrayList<c> getList() {
        return this.gto;
    }

    public g ebQ() {
        return this.olK;
    }

    public int ebR() {
        return this.olL;
    }

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.olL = jSONObject.optInt("rank_size");
            JSONArray optJSONArray = jSONObject.optJSONArray("rank_list");
            if (optJSONArray != null) {
                this.gto = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    c cVar = new c();
                    cVar.parserJson(optJSONObject);
                    this.gto.add(cVar);
                }
            }
            this.olK = new g();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("charm_data");
            if (optJSONObject2 != null) {
                this.olK.parserJson(optJSONObject2);
            }
        }
    }
}
