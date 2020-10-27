package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetRoomPlayIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private h nPy;

    public AlaGetRoomPlayIntroduceHttpResponseMessage() {
        super(1031021);
    }

    public h dVp() {
        return this.nPy;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031021) {
            this.nPy = new h();
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.nPy.nPQ = optJSONObject.optString("game_content");
                this.nPy.nPP = optJSONObject.optString("game_title");
            }
        }
    }
}
