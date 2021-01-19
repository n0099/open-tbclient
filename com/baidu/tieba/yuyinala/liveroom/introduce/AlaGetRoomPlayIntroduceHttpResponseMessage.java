package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRoomPlayIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private h olU;

    public AlaGetRoomPlayIntroduceHttpResponseMessage() {
        super(1031021);
    }

    public h dZi() {
        return this.olU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031021) {
            this.olU = new h();
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.olU.omm = optJSONObject.optString("game_content");
                this.olU.oml = optJSONObject.optString("game_title");
            }
        }
    }
}
