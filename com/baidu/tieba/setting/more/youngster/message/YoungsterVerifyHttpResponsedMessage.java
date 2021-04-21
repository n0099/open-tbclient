package com.baidu.tieba.setting.more.youngster.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.j0.v2.c.k.a.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YoungsterVerifyHttpResponsedMessage extends JsonHttpResponsedMessage {
    public a mSearchMajorResultData;

    public YoungsterVerifyHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_GET_YOUNGSTER_VERIFY_AUTHID);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            a aVar = new a();
            this.mSearchMajorResultData = aVar;
            aVar.a(optJSONObject);
        }
    }

    public a getData() {
        return this.mSearchMajorResultData;
    }
}
