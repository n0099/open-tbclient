package com.baidu.tieba.sdk.verify;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.sapi2.views.SmsLoginView;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VerifyStatusResponseMessage extends JsonHttpResponsedMessage {
    private int verifyStatus;

    public VerifyStatusResponseMessage(int i) {
        super(1003403);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.verifyStatus = jSONObject.optInt(SmsLoginView.f.j, 0);
        }
    }
}
