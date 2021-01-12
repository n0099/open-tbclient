package com.baidu.tieba.payment.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ResponsePaymentConfirmInfoMessage extends JsonHttpResponsedMessage {
    private PaymentConfirmInfoData paymentConfirmInfoData;

    public ResponsePaymentConfirmInfoMessage(int i) {
        super(i);
    }

    public PaymentConfirmInfoData getPaymentConfirmInfoData() {
        return this.paymentConfirmInfoData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (getStatusCode() == 200 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.paymentConfirmInfoData = (PaymentConfirmInfoData) OrmObject.objectWithJsonStr(optJSONObject.toString(), PaymentConfirmInfoData.class);
        }
    }
}
