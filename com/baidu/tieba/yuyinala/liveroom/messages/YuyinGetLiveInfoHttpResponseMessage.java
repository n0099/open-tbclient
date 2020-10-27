package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YuyinGetLiveInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    private w aEc;

    public YuyinGetLiveInfoHttpResponseMessage() {
        super(1031024);
    }

    public w GH() {
        return this.aEc;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && getError() == 0) {
            this.aEc = new w();
            this.aEc.bo(true);
            this.aEc.parserJson(optJSONObject);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("live_info");
            if (optJSONObject2 != null) {
                AlaLiveSwitchData.isHotLive = optJSONObject2.optInt(HttpRequest.SDK_LIVE_IS_HOT);
                AlaLiveSwitchData.liveActivityType = optJSONObject2.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
            }
        }
    }
}
