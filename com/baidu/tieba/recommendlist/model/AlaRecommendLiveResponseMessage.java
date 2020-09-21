package com.baidu.tieba.recommendlist.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.recommendlist.data.b lUi;
    public com.baidu.tieba.recommendlist.data.b lUj;

    public AlaRecommendLiveResponseMessage() {
        super(1021193);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("follow");
            if (optJSONObject2 != null) {
                this.lUi = new com.baidu.tieba.recommendlist.data.b();
                this.lUi.type = 0;
                this.lUi.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.lUj = new com.baidu.tieba.recommendlist.data.b();
                this.lUj.type = 1;
                this.lUj.parserJson(optJSONObject3);
            }
        }
    }
}
