package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRedPacketInfoResponseMessage extends JsonHttpResponsedMessage {
    private a oiy;

    public AlaGetRedPacketInfoResponseMessage() {
        super(1031073);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oiy = new a();
            this.oiy.parserJson(optJSONObject);
        }
    }

    public a eaM() {
        return this.oiy;
    }
}
