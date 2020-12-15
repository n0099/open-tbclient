package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RedPktSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public long gJq;
    public long gJr;

    public RedPktSendHttpResponseMessage() {
        super(1031076);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gJq = optJSONObject.optLong("red_packet_id");
            this.gJr = optJSONObject.optLong("red_packet_balance");
        }
    }
}
