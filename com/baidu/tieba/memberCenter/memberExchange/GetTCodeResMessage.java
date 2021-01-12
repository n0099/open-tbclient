package com.baidu.tieba.memberCenter.memberExchange;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetTCodeResMessage extends JsonHttpResponsedMessage {
    public static final String ACTIVATION_CODE = "activation_code";
    private b mData;

    public GetTCodeResMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new b();
            this.mData.parseJson(jSONObject);
        }
    }

    public b getTCodeInfo() {
        return this.mData;
    }
}
