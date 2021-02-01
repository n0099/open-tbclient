package com.baidu.tieba.sharesdk;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CommandShareHttpResMsg extends JsonHttpResponsedMessage {
    public String token;

    public CommandShareHttpResMsg() {
        super(CmdConfigHttp.CMD_SHARE_COMMAND_GENERATE);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && jSONObject != null) {
            try {
                this.token = jSONObject.optJSONObject("data").optString("token");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
