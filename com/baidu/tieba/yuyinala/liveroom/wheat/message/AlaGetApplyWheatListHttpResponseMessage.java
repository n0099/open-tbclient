package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetApplyWheatListHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int count;
    private List<com.baidu.live.data.e> oLF;
    private int oLG;
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
            if (this.oLF == null) {
                this.oLF = new ArrayList();
            }
            this.oLF.clear();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && (jSONArray = optJSONObject.getJSONArray("list")) != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    com.baidu.live.data.e eVar = new com.baidu.live.data.e();
                    eVar.parseJson((JSONObject) jSONArray.get(i2));
                    this.oLF.add(eVar);
                }
            }
            if (optJSONObject != null) {
                this.count = optJSONObject.optInt("count", 0);
                this.position = optJSONObject.optInt("pos", 0);
                this.phone_order = optJSONObject.optInt("phone_order", 0);
                this.oLG = optJSONObject.optInt("link_status", 0);
            }
        }
    }

    public List<com.baidu.live.data.e> eeM() {
        return this.oLF;
    }

    public int getPosition() {
        return this.position;
    }

    public int getCount() {
        return this.count;
    }

    public boolean eeN() {
        return this.oLG == 1;
    }

    public int eeO() {
        return this.phone_order;
    }
}
