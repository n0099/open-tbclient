package com.baidu.tieba.yuyinala.liveroom.wheat.model;

import com.baidu.live.data.AlaWheatInfoDataWrapper;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetWheatListHttpResponseMessage extends JsonHttpResponsedMessage {
    public AlaWheatInfoDataWrapper aIY;

    public GetWheatListHttpResponseMessage() {
        super(1031084);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        String optString;
        String optString2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031084 && (optString = jSONObject.optString("data")) != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            if (jSONObject2.has("user_info_list") && (optString2 = jSONObject2.optString("user_info_list")) != null) {
                this.aIY = new AlaWheatInfoDataWrapper(optString2);
            }
        }
    }
}
