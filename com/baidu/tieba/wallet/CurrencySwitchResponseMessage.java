package com.baidu.tieba.wallet;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CurrencySwitchResponseMessage extends JsonHttpResponsedMessage {
    public boolean isSwitchSuccess;
    public String logId;
    public String tipMessage;

    public CurrencySwitchResponseMessage() {
        super(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST);
        this.isSwitchSuccess = false;
        this.tipMessage = "";
        this.logId = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject != null) {
            this.isSwitchSuccess = jSONObject.optInt("convert_success", 0) == 1;
            this.tipMessage = jSONObject.optString("convert_msg");
            this.logId = jSONObject.optString("logid");
        }
    }

    public String getLogId() {
        return this.logId;
    }

    public String getTipMessage() {
        return this.tipMessage;
    }

    public boolean isSwitchSuccess() {
        return this.isSwitchSuccess;
    }
}
