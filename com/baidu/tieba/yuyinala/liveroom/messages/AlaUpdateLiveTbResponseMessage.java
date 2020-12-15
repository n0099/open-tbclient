package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.data.aq;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaUpdateLiveTbResponseMessage extends JsonHttpResponsedMessage {
    private aq hxS;

    public aq cja() {
        return this.hxS;
    }

    public AlaUpdateLiveTbResponseMessage() {
        super(1031030);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("live_info")) != null) {
                AlaLiveSwitchData.liveActivityType = optJSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
            }
            this.hxS = new aq();
            this.hxS.parseJson(jSONObject);
            setError(this.hxS.mErrorCode);
            setErrorString(this.hxS.mErrorMsg);
        }
    }
}
