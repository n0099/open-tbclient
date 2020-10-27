package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCancelApplyOrCancelInviteHttpResponseMessage extends BaseJsonHttpResponsedMessage {
    public AlaCancelApplyOrCancelInviteHttpResponseMessage() {
        super(1031010);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage, com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || i != 1031010) {
        }
    }
}
