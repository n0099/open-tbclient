package com.baidu.tieba.recommendlist.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.recommendlist.data.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public d mQO;
    public d mQP;

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
                this.mQO = new d();
                this.mQO.type = 0;
                this.mQO.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.mQP = new d();
                this.mQP.type = 1;
                this.mQP.parserJson(optJSONObject3);
            }
        }
    }
}
