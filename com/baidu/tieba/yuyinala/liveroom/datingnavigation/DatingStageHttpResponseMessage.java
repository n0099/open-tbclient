package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DatingStageHttpResponseMessage extends JsonHttpResponsedMessage {
    private b opp;

    public b ecE() {
        return this.opp;
    }

    public DatingStageHttpResponseMessage() {
        super(1031081);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && i == 1031081) {
            if (this.opp == null) {
                this.opp = new b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.opp.opo = optJSONObject.optString("activity_stage");
                this.opp.opn = optJSONObject.optString("num_fields");
            }
        }
    }
}
