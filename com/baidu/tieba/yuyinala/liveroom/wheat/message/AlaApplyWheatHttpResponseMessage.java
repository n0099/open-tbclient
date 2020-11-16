package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String ohU;
    private String ohV;
    private int ohW;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ohW = optJSONObject.optInt("online");
            this.ohU = optJSONObject.optString("push_url");
            this.ohV = optJSONObject.optString("push_single_url");
        }
    }

    public int eag() {
        return this.ohW;
    }

    public String getPushUrl() {
        return this.ohU;
    }

    public String eaf() {
        return this.ohV;
    }
}
