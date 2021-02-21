package com.baidu.tieba.recommendlist.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.recommendlist.data.e;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public e nbA;
    public e nbz;

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
                this.nbz = new e();
                this.nbz.type = 0;
                this.nbz.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.nbA = new e();
                this.nbA.type = 1;
                this.nbA.parserJson(optJSONObject3);
            }
        }
    }
}
