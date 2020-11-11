package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaInviteConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String ogr;
    private String ogs;
    private int ogt;

    public AlaInviteConnectionWheatHttpResponseMessage() {
        super(1031008);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031008 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ogt = optJSONObject.optInt("online");
            this.ogr = optJSONObject.optString("push_url");
            this.ogs = optJSONObject.optString("push_single_url");
        }
    }

    public boolean eao() {
        return this.ogt == 1;
    }

    public String getPushUrl() {
        return this.ogr;
    }

    public String eag() {
        return this.ogs;
    }
}
