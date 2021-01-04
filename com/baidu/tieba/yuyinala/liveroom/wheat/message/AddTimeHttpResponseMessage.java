package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AddTimeHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    private int success;

    public AddTimeHttpResponseMessage() {
        super(1031086);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031086 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.success = optJSONObject.optInt("success", 0);
        }
    }
}
