package com.baidu.tieba.setting.more.youngster.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.setting.more.youngster.a.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class YoungsterVerifyHttpResponsedMessage extends JsonHttpResponsedMessage {
    private a mSearchMajorResultData;

    public YoungsterVerifyHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.mSearchMajorResultData = new a();
            this.mSearchMajorResultData.parseJson(optJSONObject);
        }
    }

    public a getData() {
        return this.mSearchMajorResultData;
    }
}
