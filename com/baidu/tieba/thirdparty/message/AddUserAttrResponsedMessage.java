package com.baidu.tieba.thirdparty.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AddUserAttrResponsedMessage extends JsonHttpResponsedMessage {
    public AddUserAttrResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (i == 1003018 && jSONObject == null) {
        }
    }
}
