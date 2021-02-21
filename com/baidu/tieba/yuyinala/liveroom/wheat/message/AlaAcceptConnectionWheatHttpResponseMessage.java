package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaAcceptConnectionWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String oJu;
    private String oJv;

    public AlaAcceptConnectionWheatHttpResponseMessage() {
        super(1031009);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031009 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oJu = optJSONObject.optString("push_url");
            this.oJv = optJSONObject.optString("push_single_url");
        }
    }

    public String getPushUrl() {
        return this.oJu;
    }

    public String eez() {
        return this.oJv;
    }
}
