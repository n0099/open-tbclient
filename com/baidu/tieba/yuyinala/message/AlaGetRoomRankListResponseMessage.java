package com.baidu.tieba.yuyinala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.data.i;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetRoomRankListResponseMessage extends JsonHttpResponsedMessage {
    private i oMm;

    public AlaGetRoomRankListResponseMessage() {
        super(1031033);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.oMm = new i();
            this.oMm.parserJson(optJSONObject);
        }
    }

    public i efx() {
        return this.oMm;
    }
}
