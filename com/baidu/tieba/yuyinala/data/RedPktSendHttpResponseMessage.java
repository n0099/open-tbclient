package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class RedPktSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public long gTh;
    public long gTi;

    public RedPktSendHttpResponseMessage() {
        super(1031076);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gTh = optJSONObject.optLong("red_packet_id");
            this.gTi = optJSONObject.optLong("red_packet_balance");
        }
    }
}
