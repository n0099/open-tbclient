package com.baidu.tieba.message;

import com.baidu.gson.Gson;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.data.BubbleListData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseBubbleListMessage extends JsonHttpResponsedMessage {
    private BubbleListData a;

    public ResponseBubbleListMessage(int i) {
        super(i);
    }

    public final BubbleListData i() {
        return this.a;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        if (d() == 200 && jSONObject != null) {
            this.a = (BubbleListData) new Gson().fromJson(jSONObject.toString(), (Class<Object>) BubbleListData.class);
        }
    }
}
