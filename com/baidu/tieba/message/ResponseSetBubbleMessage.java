package com.baidu.tieba.message;

import com.baidu.gson.Gson;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.data.SetBubbleResultData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseSetBubbleMessage extends JsonHttpResponsedMessage {
    private SetBubbleResultData a;

    public ResponseSetBubbleMessage(int i) {
        super(i);
    }

    public final SetBubbleResultData i() {
        return this.a;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        if (d() == 200 && jSONObject != null) {
            this.a = (SetBubbleResultData) new Gson().fromJson(jSONObject.toString(), (Class<Object>) SetBubbleResultData.class);
        }
    }
}
