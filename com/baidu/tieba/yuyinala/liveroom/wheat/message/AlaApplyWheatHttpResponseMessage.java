package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String oDQ;
    private String oDR;
    private int oDS;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oDS = optJSONObject.optInt("online");
            this.oDQ = optJSONObject.optString("push_url");
            this.oDR = optJSONObject.optString("push_single_url");
        }
    }

    public int efW() {
        return this.oDS;
    }

    public String getPushUrl() {
        return this.oDQ;
    }

    public String efV() {
        return this.oDR;
    }
}
