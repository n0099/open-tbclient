package com.baidu.tieba.yuyinala.liveroom.publishlover;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PublishLoverHttpResponseMessage extends JsonHttpResponsedMessage {
    public PublishLoverHttpResponseMessage() {
        super(1031082);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || i != 1031082) {
        }
    }
}
