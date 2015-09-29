package com.baidu.tieba.payment.message;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.payment.data.PayResultData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponsePaymentPayMessage extends JsonHttpResponsedMessage {
    private PayResultData payResultData;

    public ResponsePaymentPayMessage(int i) {
        super(i);
    }

    public PayResultData getPayRequestDataData() {
        return this.payResultData;
    }

    public void setPayRequestData(PayResultData payResultData) {
        this.payResultData = payResultData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (getStatusCode() == 200 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.payResultData = (PayResultData) i.objectWithJson(optJSONObject, PayResultData.class);
        }
    }
}
