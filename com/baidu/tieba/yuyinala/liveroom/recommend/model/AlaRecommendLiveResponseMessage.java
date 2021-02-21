package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.yuyinala.liveroom.recommend.data.b oyF;
    public com.baidu.tieba.yuyinala.liveroom.recommend.data.b oyG;

    public AlaRecommendLiveResponseMessage() {
        super(1031053);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("follow");
            if (optJSONObject2 != null) {
                this.oyF = new com.baidu.tieba.yuyinala.liveroom.recommend.data.b();
                this.oyF.type = 0;
                this.oyF.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.oyG = new com.baidu.tieba.yuyinala.liveroom.recommend.data.b();
                this.oyG.type = 1;
                this.oyG.parserJson(optJSONObject3);
            }
        }
    }
}
