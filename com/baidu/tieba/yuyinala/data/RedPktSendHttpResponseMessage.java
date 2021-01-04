package com.baidu.tieba.yuyinala.data;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class RedPktSendHttpResponseMessage extends JsonHttpResponsedMessage {
    public long gVd;
    public long gVe;

    public RedPktSendHttpResponseMessage() {
        super(1031076);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gVd = optJSONObject.optLong("red_packet_id");
            this.gVe = optJSONObject.optLong("red_packet_balance");
        }
    }
}
