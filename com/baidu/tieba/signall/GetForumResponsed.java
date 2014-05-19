package com.baidu.tieba.signall;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GetForumResponsed extends JsonHttpResponsedMessage {
    public a listData;

    public GetForumResponsed(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (getError() == 0) {
            this.listData = new a();
            this.listData.a(jSONObject);
        }
    }
}
