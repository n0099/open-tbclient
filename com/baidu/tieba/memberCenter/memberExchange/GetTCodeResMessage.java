package com.baidu.tieba.memberCenter.memberExchange;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.k0.r1.d.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetTCodeResMessage extends JsonHttpResponsedMessage {
    public static final String ACTIVATION_CODE = "activation_code";
    public b mData;

    public GetTCodeResMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            b bVar = new b();
            this.mData = bVar;
            bVar.a(jSONObject);
        }
    }

    public b getTCodeInfo() {
        return this.mData;
    }
}
