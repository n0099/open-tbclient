package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaInviteConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String ozm;
    private String ozn;
    private int ozo;

    public AlaInviteConnectionWheatHttpResponseMessage() {
        super(1031008);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031008 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ozo = optJSONObject.optInt("online");
            this.ozm = optJSONObject.optString("push_url");
            this.ozn = optJSONObject.optString("push_single_url");
        }
    }

    public boolean ecm() {
        return this.ozo == 1;
    }

    public String getPushUrl() {
        return this.ozm;
    }

    public String ecd() {
        return this.ozn;
    }
}
