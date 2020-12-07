package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String owU;
    private String owV;
    private int owW;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.owW = optJSONObject.optInt("online");
            this.owU = optJSONObject.optString("push_url");
            this.owV = optJSONObject.optString("push_single_url");
        }
    }

    public int efL() {
        return this.owW;
    }

    public String getPushUrl() {
        return this.owU;
    }

    public String efK() {
        return this.owV;
    }
}
