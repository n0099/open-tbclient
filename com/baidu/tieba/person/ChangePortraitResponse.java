package com.baidu.tieba.person;

import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ChangePortraitResponse extends JsonHttpResponsedMessage {
    private int errCode;

    public ChangePortraitResponse() {
        super(CmdConfigHttp.CMD_CHANGE_PORTRAIT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.errCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
        }
    }

    public int getErrCode() {
        return this.errCode;
    }
}
