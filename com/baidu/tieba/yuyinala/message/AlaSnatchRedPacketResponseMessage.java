package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private f ozg;

    public AlaSnatchRedPacketResponseMessage() {
        super(1031074);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ozg = new f();
            this.ozg.parserJson(optJSONObject);
        }
    }

    public f egu() {
        return this.ozg;
    }
}
