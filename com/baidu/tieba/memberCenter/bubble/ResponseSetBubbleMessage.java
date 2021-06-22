package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseSetBubbleMessage extends JsonHttpResponsedMessage {
    public SetBubbleResultData setBubbleResultData;

    public ResponseSetBubbleMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.setBubbleResultData = (SetBubbleResultData) OrmObject.objectWithJsonStr(jSONObject.toString(), SetBubbleResultData.class);
    }

    public SetBubbleResultData getSetBubbleResultData() {
        return this.setBubbleResultData;
    }
}
