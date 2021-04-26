package com.baidu.tieba.tbean.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetBigTbeanWalletH5ResponseMessage extends JsonHttpResponsedMessage {
    public String url;

    public GetBigTbeanWalletH5ResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.url = optJSONObject.optString("return_url");
        }
    }
}
