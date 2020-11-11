package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaDiversionInfoResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.yuyinala.liveroom.data.c nXy;

    public AlaDiversionInfoResponseMessage() {
        super(1031069);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.nXy = new com.baidu.tieba.yuyinala.liveroom.data.c();
            this.nXy.parse(optJSONObject);
        }
    }
}
