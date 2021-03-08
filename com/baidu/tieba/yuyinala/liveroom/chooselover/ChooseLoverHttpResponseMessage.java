package com.baidu.tieba.yuyinala.liveroom.chooselover;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ChooseLoverHttpResponseMessage extends JsonHttpResponsedMessage {
    public ChooseLoverHttpResponseMessage() {
        super(1031080);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || i != 1031080) {
        }
    }
}
