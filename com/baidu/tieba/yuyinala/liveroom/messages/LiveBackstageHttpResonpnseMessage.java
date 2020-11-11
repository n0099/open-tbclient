package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.data.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveBackstageHttpResonpnseMessage extends JsonHttpResponsedMessage {
    private f nXA;

    public LiveBackstageHttpResonpnseMessage() {
        super(1021123);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.nXA = new f();
            this.nXA.parserJson(optJSONObject);
        }
    }
}
