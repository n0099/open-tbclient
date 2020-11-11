package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private b nVQ;

    public b dXR() {
        return this.nVQ;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.nVQ == null) {
                this.nVQ = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.nVQ.nVP = optJSONObject.optString("activity_stage");
                this.nVQ.nVO = optJSONObject.optString("num_fields");
            }
        }
    }
}
