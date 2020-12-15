package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLootRedPacketResultResponseMessage extends JsonHttpResponsedMessage {
    private b ozf;

    public AlaLootRedPacketResultResponseMessage() {
        super(1031075);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ozf = new b();
            this.ozf.parserJson(optJSONObject);
        }
    }

    public b egt() {
        return this.ozf;
    }
}
