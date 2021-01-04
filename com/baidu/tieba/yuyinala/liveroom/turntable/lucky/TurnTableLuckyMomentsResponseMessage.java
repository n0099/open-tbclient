package com.baidu.tieba.yuyinala.liveroom.turntable.lucky;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class TurnTableLuckyMomentsResponseMessage extends JsonHttpResponsedMessage {
    public b oxa;

    public TurnTableLuckyMomentsResponseMessage() {
        super(1031063);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031063 && (optJSONObject = jSONObject.optJSONObject("result")) != null) {
            this.oxa = new b(optJSONObject);
        }
    }
}
