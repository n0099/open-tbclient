package com.baidu.tieba.yuyinala.liveroom.roomcard;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetCollectRoomHttpResponseMessage extends JsonHttpResponsedMessage {
    public AlaGetCollectRoomHttpResponseMessage() {
        super(1031018);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || i != 1031018) {
        }
    }
}
