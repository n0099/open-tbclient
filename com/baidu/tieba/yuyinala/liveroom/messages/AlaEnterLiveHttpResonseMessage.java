package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaEnterLiveHttpResonseMessage extends JsonHttpResponsedMessage {
    private ab aDd;

    public AlaEnterLiveHttpResonseMessage() {
        super(1031023);
    }

    public ab Fm() {
        return this.aDd;
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
                this.aDd = new ab();
                this.aDd.bx(true);
                this.aDd.parserJson(optJSONObject);
                com.baidu.live.ae.b.Qv().cU(this.aDd.aJd);
                this.aDd.logId = jSONObject.optLong("logid");
                if (this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.live_id > 0) {
                    com.baidu.live.d.xc().putLong("ala_live_room_last_live_id", this.aDd.mLiveInfo.live_id);
                }
                if (this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.broadGiftMsgId > 0) {
                    com.baidu.live.gift.a.broadGiftMsgId = this.aDd.mLiveInfo.broadGiftMsgId;
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
