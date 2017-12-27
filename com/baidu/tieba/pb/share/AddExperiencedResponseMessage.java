package com.baidu.tieba.pb.share;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddExperiencedResponseMessage extends JsonHttpResponsedMessage {
    public AddExperiencedResponseMessage(int i) {
        super(CmdConfigHttp.CMD_ADD_EXPERIENCED);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
    }
}
