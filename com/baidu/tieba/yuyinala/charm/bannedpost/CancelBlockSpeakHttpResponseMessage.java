package com.baidu.tieba.yuyinala.charm.bannedpost;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CancelBlockSpeakHttpResponseMessage extends JsonHttpResponsedMessage {
    public CancelBlockSpeakHttpResponseMessage() {
        super(1031039);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() != 0) {
        }
    }
}
