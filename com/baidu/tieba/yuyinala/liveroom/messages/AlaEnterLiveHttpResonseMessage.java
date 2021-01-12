package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private x aBr;

    public AlaEnterLiveHttpResonseMessage() {
        super(1031023);
    }

    public x DW() {
        return this.aBr;
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
                this.aBr = new x();
                this.aBr.bs(true);
                this.aBr.parserJson(optJSONObject);
                com.baidu.live.af.b.OU().cL(this.aBr.aGI);
                this.aBr.logId = jSONObject.optLong("logid");
                if (this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.live_id > 0) {
                    com.baidu.live.d.xf().putLong("ala_live_room_last_live_id", this.aBr.mLiveInfo.live_id);
                }
                if (this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.broadGiftMsgId > 0) {
                    com.baidu.live.gift.a.broadGiftMsgId = this.aBr.mLiveInfo.broadGiftMsgId;
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
