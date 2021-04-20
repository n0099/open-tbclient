package com.baidu.tieba.memberCenter.memberpay;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.r1.f.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseMemberPayMessage extends JsonHttpResponsedMessage {
    public f mData;

    public ResponseMemberPayMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
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
