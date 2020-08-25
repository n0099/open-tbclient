package com.baidu.tieba.message;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoHolyCardResponseMessage extends JsonHttpResponsedMessage {
    public boolean isVideoHolyCard;

    public VideoHolyCardResponseMessage() {
        super(1003400);
        this.isVideoHolyCard = false;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.isVideoHolyCard = jSONObject.optInt("data") == 1;
        }
    }
}
