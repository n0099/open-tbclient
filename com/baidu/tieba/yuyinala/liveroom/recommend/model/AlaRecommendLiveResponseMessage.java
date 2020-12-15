package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.yuyinala.liveroom.recommend.data.b opF;
    public com.baidu.tieba.yuyinala.liveroom.recommend.data.b opG;

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
                this.opF = new com.baidu.tieba.yuyinala.liveroom.recommend.data.b();
                this.opF.type = 0;
                this.opF.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.opG = new com.baidu.tieba.yuyinala.liveroom.recommend.data.b();
                this.opG.type = 1;
                this.opG.parserJson(optJSONObject3);
            }
        }
    }
}
