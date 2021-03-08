package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaApplyWheatHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private String oLA;
    private int oLB;
    private String oLz;

    public AlaApplyWheatHttpResponseMessage() {
        super(1031007);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031007 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oLB = optJSONObject.optInt("online");
            this.oLz = optJSONObject.optString("push_url");
            this.oLA = optJSONObject.optString("push_single_url");
        }
    }

    public int eeI() {
        return this.oLB;
    }

    public String getPushUrl() {
        return this.oLz;
    }

    public String eeH() {
        return this.oLA;
    }
}
