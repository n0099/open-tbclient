package com.baidu.tieba.memberCenter.bubble;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ResponseBubbleListMessage extends JsonHttpResponsedMessage {
    private BubbleListData bubbleListData;

    public ResponseBubbleListMessage(int i) {
        super(i);
    }

    public BubbleListData getBubbleListData() {
        return this.bubbleListData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.bubbleListData = (BubbleListData) OrmObject.objectWithJsonStr(jSONObject.toString(), BubbleListData.class);
        }
    }
}
