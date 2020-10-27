package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaInviteConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int nYA;
    private String nYy;
    private String nYz;

    public AlaInviteConnectionWheatHttpResponseMessage() {
        super(1031008);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031008 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.nYA = optJSONObject.optInt("online");
            this.nYy = optJSONObject.optString("push_url");
            this.nYz = optJSONObject.optString("push_single_url");
        }
    }

    public boolean dXe() {
        return this.nYA == 1;
    }

    public String getPushUrl() {
        return this.nYy;
    }

    public String dWW() {
        return this.nYz;
    }
}
