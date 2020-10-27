package com.baidu.tieba.yuyinala.liveroom.recommend.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.yuyinala.liveroom.recommend.data.b nRM;
    public com.baidu.tieba.yuyinala.liveroom.recommend.data.b nRN;

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
                this.nRM = new com.baidu.tieba.yuyinala.liveroom.recommend.data.b();
                this.nRM.type = 0;
                this.nRM.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.nRN = new com.baidu.tieba.yuyinala.liveroom.recommend.data.b();
                this.nRN.type = 1;
                this.nRN.parserJson(optJSONObject3);
            }
        }
    }
}
