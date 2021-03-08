package com.baidu.tieba.yuyinala.liveroom.introduce;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetRoomPlayIntroduceHttpResponseMessage extends JsonHttpResponsedMessage {
    private h oyr;

    public AlaGetRoomPlayIntroduceHttpResponseMessage() {
        super(1031021);
    }

    public h ebK() {
        return this.oyr;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031021) {
            this.oyr = new h();
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.oyr.oyJ = optJSONObject.optString("game_content");
                this.oyr.oyI = optJSONObject.optString("game_title");
            }
        }
    }
}
