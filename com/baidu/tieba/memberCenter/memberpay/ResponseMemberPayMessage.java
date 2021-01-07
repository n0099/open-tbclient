package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ResponseMemberPayMessage extends JsonHttpResponsedMessage {
    private f mData;

    public f getMemberPayResult() {
        if (this.mData == null) {
            this.mData = new f();
        }
        return this.mData;
    }

    public ResponseMemberPayMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new f();
            this.mData.parseJson(jSONObject);
        }
    }
}
