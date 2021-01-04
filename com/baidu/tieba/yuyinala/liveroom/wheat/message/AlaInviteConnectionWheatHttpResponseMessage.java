package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaInviteConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String oDR;
    private String oDS;
    private int oDT;

    public AlaInviteConnectionWheatHttpResponseMessage() {
        super(1031008);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031008 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oDT = optJSONObject.optInt("online");
            this.oDR = optJSONObject.optString("push_url");
            this.oDS = optJSONObject.optString("push_single_url");
        }
    }

    public boolean egd() {
        return this.oDT == 1;
    }

    public String getPushUrl() {
        return this.oDR;
    }

    public String efU() {
        return this.oDS;
    }
}
