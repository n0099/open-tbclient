package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ResponseSetBubbleMessage extends JsonHttpResponsedMessage {
    private SetBubbleResultData setBubbleResultData;

    public ResponseSetBubbleMessage(int i) {
        super(i);
    }

    public SetBubbleResultData getSetBubbleResultData() {
        return this.setBubbleResultData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.setBubbleResultData = (SetBubbleResultData) OrmObject.objectWithJsonStr(jSONObject.toString(), SetBubbleResultData.class);
        }
    }
}
