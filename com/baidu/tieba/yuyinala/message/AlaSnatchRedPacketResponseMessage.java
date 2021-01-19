package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private f oCg;

    public AlaSnatchRedPacketResponseMessage() {
        super(1031074);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oCg = new f();
            this.oCg.parserJson(optJSONObject);
        }
    }

    public f edi() {
        return this.oCg;
    }
}
