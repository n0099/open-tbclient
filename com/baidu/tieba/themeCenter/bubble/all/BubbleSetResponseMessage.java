package com.baidu.tieba.themeCenter.bubble.all;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BubbleSetResponseMessage extends JsonHttpResponsedMessage {
    private SetBubbleResultData setBubbleResultData;

    public BubbleSetResponseMessage(int i) {
        super(i);
    }

    public SetBubbleResultData getSetBubbleResultData() {
        return this.setBubbleResultData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (getStatusCode() == 200 && jSONObject != null) {
            this.setBubbleResultData = (SetBubbleResultData) i.objectWithJsonStr(jSONObject.toString(), SetBubbleResultData.class);
        }
    }
}
