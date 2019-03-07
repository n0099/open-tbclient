package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SubmitPbShowTipHttpResponseMessage extends JsonHttpResponsedMessage {
    public SubmitPbShowTipHttpResponseMessage() {
        super(CmdConfigHttp.CMD_SUBMIT_PB_SHOW_TIP);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
    }
}
