package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YuyinGetLiveInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private ab aED;

    public YuyinGetLiveInfoHttpResponseMessage() {
        super(1031024);
    }

    public ab Fp() {
        return this.aED;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.aED = new ab();
            this.aED.bx(true);
            this.aED.parserJson(optJSONObject);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                AlaLiveSwitchData.isHotLive = optJSONObject2.optInt(HttpRequest.SDK_LIVE_IS_HOT);
                AlaLiveSwitchData.liveActivityType = optJSONObject2.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
            }
        }
    }
}
