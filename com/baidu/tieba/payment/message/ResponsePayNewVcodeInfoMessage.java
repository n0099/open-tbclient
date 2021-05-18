package com.baidu.tieba.payment.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponsePayNewVcodeInfoMessage extends JsonHttpResponsedMessage {
    public PayVcodeInfoData payNewVcodeInfoData;

    public ResponsePayNewVcodeInfoMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (getStatusCode() != 200 || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        this.payNewVcodeInfoData = (PayVcodeInfoData) OrmObject.objectWithJson(optJSONObject, PayVcodeInfoData.class);
    }

    public PayVcodeInfoData getPayNewVcodeInfoData() {
        return this.payNewVcodeInfoData;
    }
}
