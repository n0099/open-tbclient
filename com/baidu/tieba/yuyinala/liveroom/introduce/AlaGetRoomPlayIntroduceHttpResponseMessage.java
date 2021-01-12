package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRoomPlayIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private h olT;

    public AlaGetRoomPlayIntroduceHttpResponseMessage() {
        super(1031021);
    }

    public h dZi() {
        return this.olT;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031021) {
            this.olT = new h();
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.olT.oml = optJSONObject.optString("game_content");
                this.olT.omk = optJSONObject.optString("game_title");
            }
        }
    }
}
