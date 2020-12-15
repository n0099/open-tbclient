package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String owW;
    private String owX;
    private int owY;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.owY = optJSONObject.optInt("online");
            this.owW = optJSONObject.optString("push_url");
            this.owX = optJSONObject.optString("push_single_url");
        }
    }

    public int efM() {
        return this.owY;
    }

    public String getPushUrl() {
        return this.owW;
    }

    public String efL() {
        return this.owX;
    }
}
