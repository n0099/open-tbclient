package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaInviteConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String ohU;
    private String ohV;
    private int ohW;

    public AlaInviteConnectionWheatHttpResponseMessage() {
        super(1031008);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031008 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ohW = optJSONObject.optInt("online");
            this.ohU = optJSONObject.optString("push_url");
            this.ohV = optJSONObject.optString("push_single_url");
        }
    }

    public boolean ean() {
        return this.ohW == 1;
    }

    public String getPushUrl() {
        return this.ohU;
    }

    public String eaf() {
        return this.ohV;
    }
}
