package com.baidu.tieba.payment.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ResponsePayNewVcodeInfoMessage extends JsonHttpResponsedMessage {
    private PayVcodeInfoData payNewVcodeInfoData;

    public ResponsePayNewVcodeInfoMessage(int i) {
        super(i);
    }

    public PayVcodeInfoData getPayNewVcodeInfoData() {
        return this.payNewVcodeInfoData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (getStatusCode() == 200 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.payNewVcodeInfoData = (PayVcodeInfoData) OrmObject.objectWithJson(optJSONObject, PayVcodeInfoData.class);
        }
    }
}
