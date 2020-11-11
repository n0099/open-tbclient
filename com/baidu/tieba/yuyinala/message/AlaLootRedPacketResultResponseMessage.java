package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLootRedPacketResultResponseMessage extends JsonHttpResponsedMessage {
    private b oiA;

    public AlaLootRedPacketResultResponseMessage() {
        super(1031075);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oiA = new b();
            this.oiA.parserJson(optJSONObject);
        }
    }

    public b eaO() {
        return this.oiA;
    }
}
