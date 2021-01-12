package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetApplyWheatListHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int count;
    private List<com.baidu.live.data.e> ozr;
    private int ozs;
    private int phone_order;
    private int position;

    public AlaGetApplyWheatListHttpResponseMessage() {
        super(1031006);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray jSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031006) {
            if (this.ozr == null) {
                this.ozr = new ArrayList();
            }
            this.ozr.clear();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("list")) != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    com.baidu.live.data.e eVar = new com.baidu.live.data.e();
                    eVar.parseJson((JSONObject) jSONArray.get(i2));
                    this.ozr.add(eVar);
                }
            }
            if (optJSONObject != null) {
                this.count = optJSONObject.optInt("count", 0);
                this.position = optJSONObject.optInt("pos", 0);
                this.phone_order = optJSONObject.optInt("phone_order", 0);
                this.ozs = optJSONObject.optInt("link_status", 0);
            }
        }
    }

    public List<com.baidu.live.data.e> eci() {
        return this.ozr;
    }

    public int getPosition() {
        return this.position;
    }

    public int getCount() {
        return this.count;
    }

    public boolean ecj() {
        return this.ozs == 1;
    }

    public int eck() {
        return this.phone_order;
    }
}
