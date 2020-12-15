package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRoomPlayIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private h onm;

    public AlaGetRoomPlayIntroduceHttpResponseMessage() {
        super(1031021);
    }

    public h edI() {
        return this.onm;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031021) {
            this.onm = new h();
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.onm.onE = optJSONObject.optString("game_content");
                this.onm.onD = optJSONObject.optString("game_title");
            }
        }
    }
}
