package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.data.q;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private q gqQ;

    public AlaGetAudienceHttpResponseMessage() {
        super(1031042);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gqQ = new q();
            this.gqQ.parserJson(optJSONObject);
        }
    }

    public q bOQ() {
        return this.gqQ;
    }
}
