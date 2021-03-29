package com.baidu.tieba.newinterest.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class InterestCommitHttpResMsg extends JsonHttpResponsedMessage {
    public int errno;

    public InterestCommitHttpResMsg() {
        super(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        this.errno = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.errno = jSONObject.optInt("errno");
    }

    public int getErrno() {
        return this.errno;
    }
}
