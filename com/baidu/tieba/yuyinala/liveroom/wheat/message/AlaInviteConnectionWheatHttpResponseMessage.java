package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaInviteConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String oIU;
    private String oIV;
    private int oIW;

    public AlaInviteConnectionWheatHttpResponseMessage() {
        super(1031008);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031008 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oIW = optJSONObject.optInt("online");
            this.oIU = optJSONObject.optString("push_url");
            this.oIV = optJSONObject.optString("push_single_url");
        }
    }

    public boolean eeA() {
        return this.oIW == 1;
    }

    public String getPushUrl() {
        return this.oIU;
    }

    public String eer() {
        return this.oIV;
    }
}
