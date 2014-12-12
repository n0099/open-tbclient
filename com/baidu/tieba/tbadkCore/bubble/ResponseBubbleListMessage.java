package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseBubbleListMessage extends JsonHttpResponsedMessage {
    private BubbleListData bubbleListData;

    public ResponseBubbleListMessage(int i) {
        super(i);
    }

    public BubbleListData getBubbleListData() {
        return this.bubbleListData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.bubbleListData = (BubbleListData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(jSONObject.toString(), BubbleListData.class);
        }
    }
}
