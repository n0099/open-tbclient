package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String ozl;
    private String ozm;
    private int ozn;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.ozn = optJSONObject.optInt("online");
            this.ozl = optJSONObject.optString("push_url");
            this.ozm = optJSONObject.optString("push_single_url");
        }
    }

    public int ece() {
        return this.ozn;
    }

    public String getPushUrl() {
        return this.ozl;
    }

    public String ecd() {
        return this.ozm;
    }
}
