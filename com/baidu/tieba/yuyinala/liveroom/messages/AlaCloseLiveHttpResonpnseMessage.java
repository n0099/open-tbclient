package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCloseLiveHttpResonpnseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.data.b nXx;

    public AlaCloseLiveHttpResonpnseMessage() {
        super(1021036);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.nXx = new com.baidu.tieba.yuyinala.liveroom.data.b();
            this.nXx.dR(optJSONObject);
        }
    }
}
