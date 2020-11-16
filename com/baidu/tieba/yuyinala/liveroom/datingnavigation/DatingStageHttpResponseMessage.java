package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private b nXt;

    public b dXQ() {
        return this.nXt;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.nXt == null) {
                this.nXt = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.nXt.nXs = optJSONObject.optString("activity_stage");
                this.nXt.nXr = optJSONObject.optString("num_fields");
            }
        }
    }
}
