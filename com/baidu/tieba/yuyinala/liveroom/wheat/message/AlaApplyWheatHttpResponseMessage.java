package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String oJu;
    private String oJv;
    private int oJw;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oJw = optJSONObject.optInt("online");
            this.oJu = optJSONObject.optString("push_url");
            this.oJv = optJSONObject.optString("push_single_url");
        }
    }

    public int eeA() {
        return this.oJw;
    }

    public String getPushUrl() {
        return this.oJu;
    }

    public String eez() {
        return this.oJv;
    }
}
