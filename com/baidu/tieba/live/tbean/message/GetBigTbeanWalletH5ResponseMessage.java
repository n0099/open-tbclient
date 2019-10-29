package com.baidu.tieba.live.tbean.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetBigTbeanWalletH5ResponseMessage extends JsonHttpResponsedMessage {
    public String url;

    public GetBigTbeanWalletH5ResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.url = optJSONObject.optString("return_url");
        }
    }
}
