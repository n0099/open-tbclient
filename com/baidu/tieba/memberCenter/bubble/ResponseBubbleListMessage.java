package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseBubbleListMessage extends JsonHttpResponsedMessage {
    public BubbleListData bubbleListData;

    public ResponseBubbleListMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.bubbleListData = (BubbleListData) OrmObject.objectWithJsonStr(jSONObject.toString(), BubbleListData.class);
    }

    public BubbleListData getBubbleListData() {
        return this.bubbleListData;
    }
}
