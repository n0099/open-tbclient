package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.f;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketResponseMessage extends JsonHttpResponsedMessage {
    private f oze;

    public AlaSnatchRedPacketResponseMessage() {
        super(1031074);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oze = new f();
            this.oze.parserJson(optJSONObject);
        }
    }

    public f egt() {
        return this.oze;
    }
}
