package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.s1.f.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseCardBoxMemberPayMessage extends JsonHttpResponsedMessage {
    public f mData;

    public ResponseCardBoxMemberPayMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            f fVar = new f();
            this.mData = fVar;
            fVar.a(jSONObject);
        }
    }

    public f getMemberPayResult() {
        if (this.mData == null) {
            this.mData = new f();
        }
        return this.mData;
    }
}
