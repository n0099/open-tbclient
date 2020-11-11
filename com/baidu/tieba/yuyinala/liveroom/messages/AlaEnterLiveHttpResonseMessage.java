package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private w aES;

    public AlaEnterLiveHttpResonseMessage() {
        super(1031023);
    }

    public w Hi() {
        return this.aES;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject2 = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject2 != null) {
                setErrorString(optJSONObject2.optString("usermsg"));
            }
            if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.aES = new w();
                this.aES.bp(true);
                this.aES.parserJson(optJSONObject);
                com.baidu.live.aa.b.Qa().cw(this.aES.aJU);
                this.aES.logId = jSONObject.optLong("logid");
                if (this.aES.mLiveInfo != null && this.aES.mLiveInfo.live_id > 0) {
                    com.baidu.live.d.AZ().putLong("ala_live_room_last_live_id", this.aES.mLiveInfo.live_id);
                }
                if (this.aES.mLiveInfo != null && this.aES.mLiveInfo.broadGiftMsgId > 0) {
                    com.baidu.live.gift.a.broadGiftMsgId = this.aES.mLiveInfo.broadGiftMsgId;
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("live_info");
                if (optJSONObject3 != null) {
                    AlaLiveSwitchData.isHotLive = optJSONObject3.optInt(HttpRequest.SDK_LIVE_IS_HOT);
                    AlaLiveSwitchData.liveActivityType = optJSONObject3.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                }
            }
        }
    }
}
